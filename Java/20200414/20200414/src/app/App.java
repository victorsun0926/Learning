/*
 * @Author: Victor Sun
 * @Github: https://github.com/victorsun0926/
 * @CreateTime: 2020-04-14 19:13:40
 * @LastEditTime: 2020-04-14 21:58:34
 */
package app;


public class App {
    public static void main(String[] args) throws Exception {
        int [] a = {1,2,3,4,5};
        int [][] b = {{1,2,3,4,5},{9,8,7,6,5}};

        for(int k:a){
            System.out.print(k+"\t");
        };
        System.out.println();

        for(int i=0;i<b.length;i++){
            for(int j=0;j<b[0].length;j++){
                System.out.print(b[i][j]+"\t");
            }
            System.out.println();
        };
    }
}
