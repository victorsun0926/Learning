/*
 * @Author: Victor Sun
 * @Github: https://github.com/victorsun0926/
 * @CreateTime: 2020-02-07 12:32:19
 * @LastEditTime : 2020-02-07 16:12:27
 */
package app;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class connect {
    public FileSystem conHDFS() throws IOException, InterruptedException {
        // 1.获取项目所处文件夹
        String MDir = System.getProperty("user.dir");

        // 2.获取配置文件存放位置
        String BDir = MDir + File.separator + "hdfs-conf";

        // 3.获取文件路径
        String corePath = BDir + File.separator + "core-site.xml";
        String hdfsPath = BDir + File.separator + "hdfs-site.xml";

        // 配置类，连接大数据平台
        Configuration conf = new Configuration();

        // 配置conf
        conf.addResource(new Path(corePath));
        conf.addResource(new Path(hdfsPath));

        // 连接HDFS
        FileSystem fs = FileSystem.get(URI.create(""), conf, "omm");
        return fs;
    }
}
