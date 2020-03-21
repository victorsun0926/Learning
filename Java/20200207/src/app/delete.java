package app;

import java.io.IOException;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class delete {
	public FileSystem fs;

    public delete(FileSystem hdfsFile) {
		this.fs = hdfsFile;
	}
	public void fileDel(String path) throws IllegalArgumentException, IOException {
		if(fs.delete(new Path(path), true)) {
			System.out.println("删除成功");
		}
		else {
			System.out.println("删除失败");
		}
	}
}
