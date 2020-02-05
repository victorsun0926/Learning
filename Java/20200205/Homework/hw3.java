/*
 * @Author: Victor Sun
 * @Github: https://github.com/victorsun0926/
 * @CreateTime: 2020-02-05 17:04:11
 * @LastEditTime : 2020-02-05 17:51:18
 */
import java.io.IOException;

public class hw3{
    public static void main(String[] args) throws IOException {
        int x=1,y=2,z=0;
        System.out.println(x);
        System.out.println(y);
        for(int i=1;i<=8;i++) {
            z=x+y;
            System.out.println(z);
            x=y;
            y=z;
        }
    }
}
