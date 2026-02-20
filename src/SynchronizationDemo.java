class Table {
    synchronized void printTable(int n,boolean newline) {
        for (int i = 1; i <= 5; i++) {
            System.out.print(n * i + " ");
            try {
                // Pause the thread to make synchronization effect more visible
                Thread.sleep(400);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        if (newline) {
           System.out.println("");
        }
    }
}

class MyThread1 extends Thread {
    Table t;
    MyThread1(Table t) {
        this.t = t;
    }
    public void run() {
        t.printTable(5,true);
    }
}

class MyThread2 extends Thread {
    Table t;
    MyThread2(Table t) {
        this.t = t;
    }
    public void run() {
        t.printTable(100,false);
    }
}

public class SynchronizationDemo {
    public static void main(String[] args) {
        Table obj = new Table();
        MyThread1 t1 = new MyThread1(obj);
        MyThread2 t2 = new MyThread2(obj);
        t1.start();
        t2.start();
    }
}
