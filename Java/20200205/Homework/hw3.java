/*
 * @Author: Victor Sun
 * @Github: https://github.com/victorsun0926/
 * @CreateTime: 2020-02-05 17:04:11
 * @LastEditTime : 2020-02-05 18:49:06
 */
import java.io.IOException;

public class hw3{
    public static void main(String[] args) throws IOException {
        int x=1,y=2,z=0;
        System.out.println("第1个值为"+x);
        System.out.println("第2个值为"+y);
        for(int i=1;i<=8;i++) {
            z=x+y;
            System.out.println("第"+(i+2)+"个值为"+z);
            x=y;
            y=z;
        }
    }
}
