/*
 * @Author: Victor Sun
 * @Github: https://github.com/victorsun0926/
 * @CreateTime: 2020-04-23 19:52:14
 * @LastEditTime: 2020-04-23 22:42:24
 */
package com.hdfs;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

public class HBase {

    public void NewTable() throws IOException {
    Configuration cof = HBaseConfiguration.create();
    cof.set("hbase.zookeeper.quorum", "node01:2181,node02:2181,node03:2181");
    Connection con = ConnectionFactory.createConnection(cof);
    Admin admin = con.getAdmin();
    TableName tn = TableName.valueOf("vic");
    if(!admin.tableExists(tn)) {
        HTableDescriptor htd = new HTableDescriptor(tn);
        htd.addFamily(new HColumnDescriptor("base_info"));
        admin.createTable(htd);
        }
    }

}
