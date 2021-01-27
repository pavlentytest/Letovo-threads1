package com.company;
public class Main {
    // [+][-]
    public static void main(String[] args) {
	    new MyThread("+").start();
        new MyThread("-").start();
    }
    public static void test(String message) {
        try {
            System.out.print("[");
            Thread.sleep(1000);
            System.out.print(message);
            Thread.sleep(1000);
            System.out.print("]");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class MyThread extends Thread {
    private String mess;
    MyThread(String m) {
        this.mess = m;
    }
    @Override
    public void run() {
        while(true) {
            Main.test(mess);
        }
    }
}

