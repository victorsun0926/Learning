package app;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Producer {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Producer p = new Producer(false,100,"TengkeEDU_Topic");
		p.sendMessage();
	}
	public static final Logger LOG = LoggerFactory.getLogger(Producer.class);

	public KafkaProducer<Integer,String> producer;
	public Boolean isAsync;
	public int messageNumToSend;
	public String topic;
	public Properties props = new Properties();
	public Producer(Boolean isAsync,int messageNumToSend ,String topic) {
		props.put("bootstrap.servers", "192.168.222.41:21005,192.168.222.42:21005,192.168.222.43:21005");
		props.put("key.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		this.isAsync = isAsync;
		this.messageNumToSend = messageNumToSend;
		this.topic = topic;
		this.producer = new KafkaProducer<Integer,String>(props);

	}

	public void sendMessage() throws InterruptedException, ExecutionException {
		LOG.info("TengkeEDU Kafka start.....");
		int number = 0;
		String value = "";
		while(number<messageNumToSend) {
			value = "Message" + number;
			ProducerRecord<Integer, String> record = new ProducerRecord<Integer, String>(topic, number, value);
			if(!isAsync) {
				producer.send(record).get();
				LOG.info("send_sync "+"\t"+(number+1)+"\t"+"Message");
			}else {
				long startTime = System.currentTimeMillis();
				producer.send(record, new AsyncCallBack(startTime, number, value));
			}
			number++;
		}
	}
	class AsyncCallBack implements Callback{
		public long startTime;
		public int key;
		public String message;
		public AsyncCallBack(long startTime,int key,String message) {
			this.startTime = startTime;
			this.key = key;
			this.message = message;
		}
		@Override
		public void onCompletion(RecordMetadata arg0, Exception arg1) {
			long elapsedTime = System.currentTimeMillis() - startTime;
			if( arg0 !=null ) {
				LOG.info("message("+key+","+message+")  send to partition("+arg0.partition()+") offset is ("+arg0.offset()+") in"
				+ elapsedTime + "ms");
			}else if( arg1 !=null ) {
				LOG.info("This  Exception  occured:"+arg1);
			}
		}

	}
}
