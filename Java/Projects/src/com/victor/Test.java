package com.victor;

public class Test {

    public static void main(String[] args) {
        fOne f = new fOne();
        f.output();

        CPU cpu = new CPU();
        cpu.setSpeed(2200);

        HardDisk disk = new HardDisk();
        disk.setAmount(200);

        PC pc = new PC();
        pc.setCPU(cpu);
        pc.setHardDisk(disk);
        pc.show();
    }
}

class fOne{
    private char alpha;
    fOne(){
        alpha = 'A';
    }
    void output(){
        for (int i = 0; i < 26; i++) {
            System.out.print(alpha+" ");
            alpha++;
        }
        System.out.println();
    }
}

class CPU{
    private int speed;

    CPU(){
        speed = 0;
    }

    public void setSpeed(int m){
        this.speed = m;
    }

    public int getSpeed() {
        return speed;
    }
}

class HardDisk{
    private int amount;

    HardDisk(){
        amount = 0;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int m) {
        this.amount = m;
    }

}

class PC{
    private CPU c;
    private HardDisk HD;

    public void setCPU(CPU c) {
        this.c = c;
    }

    public void setHardDisk(HardDisk d) {
        this.HD = d;
    }

    void show(){
        System.out.println("CPU speed: "+ c.getSpeed());
        System.out.println("HardDisk amount: "+ HD.getAmount());
    }

}
