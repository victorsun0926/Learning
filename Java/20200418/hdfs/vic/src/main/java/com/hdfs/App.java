/*
 * @Author: Victor Sun
 * @Github: https://github.com/victorsun0926/
 * @CreateTime: 2020-04-22 04:07:45
 * @LastEditTime: 2020-04-23 21:06:57
 */
package com.hdfs;

import java.io.IOException;
import java.util.Scanner;

    public class App {
        public static void main(String[] args) throws IOException {
            //HDFS hdfs = new HDFS();
            //Scanner f = new Scanner(System.in);
            //hdfs.init();
            //String a = "/"+f.nextLine();
            //System.out.println("Creating "+a);
            //hdfs.mkdir(a);
            //f.close();
            HBase hb = new HBase();
            hb.NewTable();
        }
    }
