/*
 * @Author: Victor Sun
 * @Github: https://github.com/victorsun0926/
 * @Date: 2020-02-05 10:01:02
 * @LastEditTime : 2020-02-05 12:15:59
 */

import java.io.IOException;
import java.util.Scanner;
 public class JustTest {

	public static void main(String[] args) throws IOException {
		System.out.println("Hello World.");
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入成绩：");
		int score = sc.nextInt();
		if(score < 0 | score > 300) {
        System.out.println("成绩无效");
		}
		else if(score >= 0 & score < 210) {
			System.out.println("考试不通过");
		}
		else if(score > 210 & score <=300) {
			System.out.println("考试通过");
		}
		sc.close();
	}
}
