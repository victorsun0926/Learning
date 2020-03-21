/*
 * @Author: Victor Sun
 * @Github: https://github.com/victorsun0926/
 * @CreateTime: 2020-02-07 16:02:07
 * @LastEditTime : 2020-02-08 10:27:37
 */
package app;

import java.io.IOException;
import org.apache.hadoop.fs.FileSystem;

public class app {

public static void main(String[] args) throws IOException, InterruptedException {

    connect connect = new connect();

    FileSystem tkfs = connect.conHDFS();

    read read = new read(tkfs);
    read.byteRead("/tk.txt",1024);

    write write = new write(tkfs);
    write.byteWrite("Hello Java", "/tk.txt");

    delete delete = new delete(tkfs);
    delete.fileDel("/tk.txt");

    }
}
