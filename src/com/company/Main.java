package com.company;
public class Main {
    // [+][-]
    public static void main(String[] args) throws InterruptedException {

	    MyThread thread1 = new MyThread("+");
	    thread1.start();
        MyThread thread2 = new MyThread("-");
        thread2.start();
        Thread.sleep(2000);
        thread1.flag = false;
        thread1.join(); // ждем завершения 1-потока
        test("Stopped 1-st thread!");
    }

    public static Object key = new Object();

    public static void test(String message) {
        synchronized (key) {
            try {
                System.out.print("[");
                Thread.sleep(1000);
                System.out.print(message);
                Thread.sleep(1000);
                System.out.print("]");
             //   key.notify(); // возобновить поток
              //  key.wait(); // поставить поток в режим ожидания
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class MyThread extends Thread {
    private String mess;
    public boolean flag = true;

    MyThread(String m) {
        this.mess = m;
    }
    @Override
    public void run() {
        while(flag) {
            Main.test(mess);
        }
    }
}

