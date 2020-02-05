/*
 * @Author: Victor Sun
 * @Github: https://github.com/victorsun0926/
 * @Date: 2020-02-05 10:01:02
 * @LastEditTime : 2020-02-05 15:23:15
 */

import java.io.IOException;
import java.util.Scanner;
public class test0 {

	public static void main(String[] args) throws IOException {
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		while(true) {
		    System.out.println("Hello World.");
		    System.out.print("请输入成绩：");
		    int score = sc1.nextInt();
		    if(score < 0 | score > 300) {
                System.out.println("成绩无效");
		    }
		    else if(score >= 0 & score < 210) {
			    System.out.println("考试不通过");
		    }
		    else if(score > 210 & score <= 300) {
			    System.out.println("考试通过");
		    }
            System.out.println("\n是否退出程序：Y/N");
            String yn = sc2.nextLine();
            if(yn.equals("Y")||yn.equals("y")) {
			    sc1.close();
			    sc2.close();
			    break;
		    }
		}
	}
}
