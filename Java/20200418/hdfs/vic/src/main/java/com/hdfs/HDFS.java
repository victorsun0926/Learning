/*
 * @Author: Victor Sun
 * @Github: https://github.com/victorsun0926/
 * @CreateTime: 2020-04-23 19:52:51
 * @LastEditTime: 2020-04-23 19:53:53
 */
package com.hdfs;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class HDFS {
    FileSystem fs = null;
    Configuration conf = null;


    public void init() throws IOException
    {
        conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://192.168.25.100:8020");
        fs = FileSystem.get(conf);
    }

    public void mkdir(String a) throws IllegalArgumentException, IOException
    {
        boolean status = fs.mkdirs(new Path(a));
        System.out.println(status);
    }

}
