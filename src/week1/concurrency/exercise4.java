package week1.concurrency;

public class exercise4 {

    public static void deadlockExample() {
        // Initialize two resources that will be used to demonstrate deadlock
        Resource resource1 = new Resource(1);
        Resource resource2 = new Resource(2);

        // Task 1 tries to lock resource1 then resource2
        Runnable task1 = () -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread().getName() + " acquired lock on resource " + resource1.getId());
                try {
                    // Simulate processing by sleeping
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // Attempt to lock resource2 while holding lock on resource1
                synchronized (resource2) {
                    System.out.println(Thread.currentThread().getName() + " acquired lock on resource " + resource2.getId());
                }
            }
        };

        // Task 2 tries to lock resource2 then resource1, creating potential for deadlock
        Runnable task2 = () -> {
            synchronized (resource2) {
                System.out.println(Thread.currentThread().getName() + " acquired lock on resource " + resource2.getId());
                try {
                    // Simulate processing by sleeping
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // Attempt to lock resource1 while holding lock on resource2
                synchronized (resource1) {
                    System.out.println(Thread.currentThread().getName() + " acquired lock on resource " + resource1.getId());
                }
            }
        };

        // Start both threads
        Thread thread1 = new Thread(task1, "Thread 1");
        Thread thread2 = new Thread(task2, "Thread 2");

        thread1.start();
        thread2.start();

        // Wait for both threads to complete to ensure the application does not terminate prematurely
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        deadlockExample();
    }
}