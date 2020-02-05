/*
 * @Author: Victor Sun
 * @Github: https://github.com/victorsun0926/
 * @CreateTime: 2020-02-05 14:23:38
 * @LastEditTime : 2020-02-05 17:50:00
 */
import java.io.IOException;
import java.util.Scanner;

public class test01 {
    public static void main(String[] args) throws IOException {
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        while(true) {
            int[] score = {0,0,0};
            for(int i=0;i<=2;i++) {
                System.out.print("请依次输入语数英成绩：");
                score[i] = sc1.nextInt();
            }
            System.out.println("语文成绩为：" + score[0]);
            System.out.println("数学成绩为：" + score[1]);
            System.out.println("英语成绩为：" + score[2]);
            System.out.println("是否退出？Y/N");
            String yn = sc2.nextLine();
            if(yn.equals("Y")||yn.equals("y")) {
                sc1.close();
                sc2.close();
                break;
            }
        }
    }
}
