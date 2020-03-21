/*
 * @Author: Victor Sun
 * @Github: https://github.com/victorsun0926/
 * @CreateTime: 2020-02-08 09:38:17
 * @LastEditTime : 2020-02-08 09:54:49
 */
package app;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

public class write {
    public FileSystem fs;

    public write(FileSystem hdfsFile) {
        this.fs = hdfsFile;
    }

    public void byteWrite(String strContent, String strPath) throws IllegalArgumentException, IOException {
    FSDataOutputStream out = null;
    InputStream in = (InputStream) new ByteArrayInputStream(strContent.getBytes());
    out = fs.append(new Path(strPath),4096);
    IOUtils.copyBytes(in,out,4096);
    out.close();
    }
}
