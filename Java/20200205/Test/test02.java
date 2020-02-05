/*
 * @Author: Victor Sun
 * @Github: https://github.com/victorsun0926/
 * @CreateTime: 2020-02-05 15:10:42
 * @LastEditTime : 2020-02-05 18:25:16
 */
import java.io.IOException;

public class test02{
    public static void main(String[] args) throws IOException {
    int x,y;
    x = Max(1,2,3);
    y = Min(1,2,3);
    System.out.print("最大值是"+x+",最小值是"+y);
    }

    /*
    *@此函数用于判断三个数的最大值。
    *@n1为第一个数；
    *@n2为第二个数；
    *@n3为第三个数；
    */
    public static int Max(int n1,int n2, int n3) {
        int result;
        if(n1 > n2) {
            result = n1;
        }
        else result = n2;
        if(n3 > result) {
            result = n3;
        }
        return result;
    }

    /*
    *@此函数用于判断三个数的最小值。
    *@n1为第一个数；
    *@n2为第二个数；
    *@n3为第三个数；
    */
    public static int Min(int n1,int n2, int n3) {
        int result;
        if(n1 < n2) {
            result = n1;
        }
        else result = n2;
        if(n3 < result) {
            result = n3;
        }
        return result;
    }
}
