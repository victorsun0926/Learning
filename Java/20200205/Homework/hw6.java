/*
 * @Author: Victor Sun
 * @Github: https://github.com/victorsun0926/
 * @CreateTime: 2020-02-05 18:34:01
 * @LastEditTime: 2020-02-05 18:34:59
 */
import java.io.IOException;

public class hw6{
    public static void main(String[] args) throws IOException {
        int x,y;
        x = Max(1,2,3,4,5);
        y = Min(1,2,3,4,5);
        System.out.print("最大值是"+x+",最小值是"+y);
        }
    public static int Max(int n1,int n2, int n3,int n4,int n5) {
        int result;
        if(n1 > n2) {
            result = n1;
        }
        else result = n2;
        if(n3 > result) {
            result = n3;
        }
        if(n4 > result) {
            result = n4;
        }
        if(n5 > result) {
            result = n5;
        }
        return result;
    }
    public static int Min(int n1,int n2, int n3,int n4,int n5) {
        int result;
        if(n1 < n2) {
            result = n1;
        }
        else result = n2;
        if(n3 < result) {
            result = n3;
        }
        if(n4 < result) {
            result = n4;
        }
        if(n5 < result) {
            result = n5;
        }
        return result;
    }
}
