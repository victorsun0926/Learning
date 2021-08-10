package com.victor;

public class Main {

    public static void main(String[] args) {
        // write your code here
        tickets tickets = new tickets();
        Thread t1 = new Thread(tickets, "No.1");
        Thread t2 = new Thread(tickets, "No.2");
        Thread t3 = new Thread(tickets, "No.3");
        t1.start();
        t2.start();
        t3.start();
    }
}

class tickets implements Runnable{
    int tickets = 20;
    @Override
    public void run(){
        System.out.println("Start Selling...");
        try{
            while(tickets >= 1) {
                synchronized(this){
                    tickets--;
                    System.out.println(Thread.currentThread().getName() + " Sell one ticket.");
                    System.out.println("Remains: " + tickets);
                }
                Thread.sleep(100);
            }
            System.out.println("Sold out.");
        } catch(InterruptedException e){
            System.out.println(Thread.currentThread().getName() + "Interruped.");
        }
    }
}