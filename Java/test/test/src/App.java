/*
 * @Author: Victor Sun
 * @Github: https://github.com/victorsun0926/
 * @CreateTime: 2021-03-19 19:16:07
 * @LastEditTime: 2021-03-19 19:16:36
 */
public class App{
    public static void main(String[] args){
    t1 t1 = new t1();
    t1.run();
    t2 t2 = new t2();
    t2.run();
    t3 t3 = new t3();
    t3.run();
    }
}

class t1{
    public void run(){
        char a[] = {'你','我','他'};
        for(int i = 0;i < 3;i++) System.out.println("\"" + a[i] + "\"" + "在Unicode表中位置是：" + (int)a[i]);
    }
}

class t2{
    public void run(){
        char b = 'α';
        for(int j = 0;j < 25;j++){
            System.out.print(b + " ");
            b++;
        }
        System.out.println("");
    }
}

class t3{
    public void run(){
        char c[] = {'海','上','升','明','月'};
        for(int k = 0;k < 5;k++) System.out.print(c[k] + " ");
        System.out.println("");
        for(int k = 4;k >= 0;k--) System.out.print(c[k] + " ");
    }
}
