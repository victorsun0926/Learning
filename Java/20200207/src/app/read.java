/*
 * @Author: Victor Sun
 * @Github: https://github.com/victorsun0926/
 * @CreateTime: 2020-02-07 14:21:21
 * @LastEditTime : 2020-02-07 15:43:54
 */
package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

public class read {
    // 定义一个fs对象，用于设置连接平台
    public FileSystem fs;

    // 对象初始化,fs对象对应调用read()函数时传入的hdfsFile参数
    public read(FileSystem hdfsFile) {
        this.fs = hdfsFile;
    }

    // 定义读函数（字节拷贝）
    public void byteRead(String path, int buffer) throws IllegalArgumentException, IOException {
        // 根据fs对象的open操作，打开path的文件
        FSDataInputStream in = fs.open(new Path(path));
        // 将在输入缓冲区的数据，每次buffer大小放入输出缓冲区
        IOUtils.copyBytes(in, System.out, buffer);
        // 关闭缓冲区
        in.close();
    }

    // 定义读函数（直接读取缓冲区）
    public void bufferRead(String path) throws IllegalArgumentException, IOException {
        // 打开文件
        FSDataInputStream in = fs.open(new Path(path));
        // 将文件信息放到缓冲区中
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String  sTempOneLine = null;
        StringBuffer strBuffer = new StringBuffer();
        String strALL = null;
        // 逐行读取直到遇见null
        while ((sTempOneLine = reader.readLine()) != null) {
            strBuffer.append(sTempOneLine);
            // strALL += sTempOneLine + "\n"
            strALL = strALL + "\n" + sTempOneLine;
        }
        System.out.println(strBuffer.toString());
        System.out.println(strALL);
    }
}
