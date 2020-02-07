/*
 * @Author: Victor Sun
 * @Github: https://github.com/victorsun0926/
 * @CreateTime: 2020-02-07 16:02:07
 * @LastEditTime : 2020-02-07 16:11:47
 */
package app;

import java.io.IOException;
import org.apache.hadoop.fs.FileSystem;

public class app {

public static void main(String[] args) throws IOException, InterruptedException {

    // 调用连接函数连接平台
    connect connect = new connect();
    FileSystem tkfs = connect.conHDFS();

    // 调用读函数
    // 创建读对象
    read read = new read(tkfs);
    read.byteRead("\tk.txt",1024);

    }
}
