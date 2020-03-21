package com.huawei.bigdata.kafka.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Properties;

import kafka.utils.ShutdownableThread;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huawei.bigdata.kafka.example.security.LoginUtil;

public class NewConsumer extends ShutdownableThread
{
    private static final Logger LOG = LoggerFactory.getLogger(NewConsumer.class);
    
    private final KafkaConsumer<Integer, String> consumer;
    
    private final String topic;
    
    // 一次请求的最大等待时间
    private final int waitTime = 1000;
    
    // Broker连接地址
    private final String bootstrapServers = "bootstrap.servers";
    // Group id
    private final String groupId = "group.id";
    // 消息内容使用的反序列化类
    private final String valueDeserializer = "value.deserializer";
    // 消息Key值使用的反序列化类
    private final String keyDeserializer = "key.deserializer";
    // 协议类型:当前支持配置为SASL_PLAINTEXT或者PLAINTEXT
    private final String securityProtocol = "security.protocol";
    // 服务名
    private final String saslKerberosServiceName = "sasl.kerberos.service.name";
    // 域名
    private final String kerberosDomainName = "kerberos.domain.name";
    // 是否自动提交offset
    private final String enableAutoCommit = "enable.auto.commit";
    // 自动提交offset的时间间隔
    private final String autoCommitIntervalMs = "auto.commit.interval.ms";
    
    // 会话超时时间
    private final String sessionTimeoutMs = "session.timeout.ms";
    
    /**
     * 用户自己申请的机机账号keytab文件名称
     */
    private static final String USER_KEYTAB_FILE = "请修改为真实keytab文件名";
    
    /**
    * 用户自己申请的机机账号名称
    */
    private static final String USER_PRINCIPAL = "请修改为真实用户名称";
    
    /**
     * NewConsumer构造函数
     * @param topic 订阅的Topic名称
     */
    public NewConsumer(String topic)
    {
		super("KafkaConsumerExample", false);
        Properties props = new Properties();
        
        KafkaProperties kafkaProc = KafkaProperties.getInstance();
        // Broker连接地址
        props.put(bootstrapServers,
            kafkaProc.getValues(bootstrapServers, "localhost:21007"));
        // Group id
        props.put(groupId, "DemoConsumer");
        // 是否自动提交offset
        props.put(enableAutoCommit, "true");
        // 自动提交offset的时间间隔
        props.put(autoCommitIntervalMs, "1000");
        // 会话超时时间
        props.put(sessionTimeoutMs, "30000");
        // 消息Key值使用的反序列化类
        props.put(keyDeserializer,
            "org.apache.kafka.common.serialization.IntegerDeserializer");
        // 消息内容使用的反序列化类
        props.put(valueDeserializer,
            "org.apache.kafka.common.serialization.StringDeserializer");
        // 安全协议类型
        props.put(securityProtocol, kafkaProc.getValues(securityProtocol, "SASL_PLAINTEXT"));
        // 服务名
        props.put(saslKerberosServiceName, "kafka");
        // 域名
        props.put(kerberosDomainName, kafkaProc.getValues(kerberosDomainName, "hadoop.hadoop.com"));
        consumer = new KafkaConsumer<Integer, String>(props);
        this.topic = topic;
    }
    
    /**
     * 订阅Topic的消息处理函数
     */
    public void doWork()
    {
        // 订阅
        consumer.subscribe(Collections.singletonList(this.topic));
        // 消息消费请求
        ConsumerRecords<Integer, String> records = consumer.poll(waitTime);
        // 消息处理
        for (ConsumerRecord<Integer, String> record : records)
        {
            LOG.info("[NewConsumerExample], Received message: (" + record.key() + ", " + record.value()
                + ") at offset " + record.offset());
        }
    }

    public static void securityPrepare() throws IOException
    {
        String filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator;
        String krbFile = filePath + "krb5.conf";
        String userKeyTableFile = filePath + USER_KEYTAB_FILE;
        
        //windows路径下分隔符替换
        userKeyTableFile = userKeyTableFile.replace("\\", "\\\\");
        krbFile = krbFile.replace("\\", "\\\\");
        
        LoginUtil.setKrb5Config(krbFile);
        LoginUtil.setZookeeperServerPrincipal("zookeeper/hadoop.hadoop.com");
        LoginUtil.setJaasFile(USER_PRINCIPAL, userKeyTableFile);
    }
    
    public static Boolean isSecurityModel()
    {
        Boolean isSecurity = false;
        String krbFilePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "kafkaSecurityMode";
        
        Properties securityProps = new Properties();
        
        // file does not exist.
        if (!isFileExists(krbFilePath))
        {
            return isSecurity;
        }
        
        try 
        {
            securityProps.load(new FileInputStream(krbFilePath));
            if ("yes".equalsIgnoreCase(securityProps.getProperty("kafka.client.security.mode")))
            {
                isSecurity = true;
            }
        }
        catch (Exception e)
        {
            LOG.info("The Exception occured : {}.", e);
        }
        
        return isSecurity;
    }
    
    /*
     * 判断文件是否存在
     */
    private static boolean isFileExists(String fileName)
    {
        File file = new File(fileName);
        
        return file.exists();
    }
    
    public static void main(String[] args)
    {
        if (isSecurityModel())
        {
            try
            {
                LOG.info("Securitymode start.");
                
                //!!注意，安全认证时，需要用户手动修改为自己申请的机机账号
                securityPrepare();
            }
            catch (IOException e)
            {
                LOG.error("Security prepare failure.");
                LOG.error("The IOException occured : {}.", e);
                return;
            }
            LOG.info("Security prepare success.");
        }
        
        NewConsumer consumerThread = new NewConsumer(KafkaProperties.TOPIC);
        consumerThread.start();
        
        // 等到60s后将consumer关闭，实际执行过程中可修改
        try
        {
            Thread.sleep(60000);
        }
        catch (InterruptedException e)
        {
            LOG.info("The InterruptedException occured : {}.", e);
        }
        finally
        {
            consumerThread.shutdown();
            consumerThread.consumer.close();
        }
    }
    
}
