package com.hdfs;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;

/**
 * Hello world!
 *
 */
public class App {
    FileSystem fs = null;
    Configuration conf = null;

    public void init() throws IOException
    {
        conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://192.168.10.2:8020");
        fs = FileSystem.get(conf);
    }

    public void mkdir() throws IllegalArgumentException, IOException
    {
        boolean status = fs.mkdirs(new Path("/swh"));
        System.out.println(status);
    }
}
