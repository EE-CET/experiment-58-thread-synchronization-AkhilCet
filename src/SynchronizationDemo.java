class Table {
    
    synchronized void printTable(int n) {
        for (int i = 1; i <= 5; i++) {
            System.out.print(n * i + " ");
        }
        System.out.println();
    }
}

public class SynchronizationDemo {
    public static void main(String[] args) {
       
        Table sharedTable = new Table();

 
        Thread thread1 = new Thread(() -> {
            sharedTable.printTable(5);
        });

        Thread thread2 = new Thread(() -> {
            sharedTable.printTable(100);
        });

      
        thread1.start();
        thread2.start();
    }
}
