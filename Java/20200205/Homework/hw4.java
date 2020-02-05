/*
 * @Author: Victor Sun
 * @Github: https://github.com/victorsun0926/
 * @CreateTime: 2020-02-05 17:17:02
 * @LastEditTime : 2020-02-05 17:51:06
 */
import java.io.IOException;
import java.util.Arrays;

public class hw4{
    public static void main(String[] args) throws IOException {
        String[] StrNum={"First","Second","Third","Fourth","Fifth","Sixth","Seventh","Eighth","Ninth","Tenth"};
        int calNum[]=new int[10];
        int x=1,y=2,z=0;
        calNum[0]=x;
        calNum[1]=y;
        for(int i=2;i<=9;i++) {
            z=x+y;
            calNum[i]=z;
            x=y;
            y=z;
        }
        System.out.print(Arrays.toString(calNum));
        System.out.print(Arrays.toString(StrNum));
    }
}
