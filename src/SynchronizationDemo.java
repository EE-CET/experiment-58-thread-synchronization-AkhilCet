class Table {
    synchronized void printTable(int n) {
        for (int i = 1; i <= 5; i++) {
           
            System.out.print(n * i + " ");
        }
        
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

        try {
            
            thread1.start();
            thread1.join();

            
            System.out.print("\n");

            
            thread2.start();
            thread2.join();

        } catch (InterruptedException e) {
            System.err.println("A thread was interrupted.");
            Thread.currentThread().interrupt();
        }
    }
}
