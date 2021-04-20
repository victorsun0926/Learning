package com.victor;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        FOne f1 = new FOne();
        System.out.print("Please Input a number: ");
        int x;
        Scanner s = new Scanner(System.in);
        x = s.nextInt();
        f1.run(x);
        FTwo f2 = new FTwo();
        f2.run();
        FThree f3 = new FThree();
        f3.run();
        FFour f4 = new FFour();
        f4.run();
    }
}

class fOne{
    
}