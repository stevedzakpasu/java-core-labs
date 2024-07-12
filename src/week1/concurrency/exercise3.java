package week1.concurrency;

// Demonstrates synchronization in a multi-threaded environment
public class exercise3 {

    // Method to increment a shared counter with synchronization to avoid race conditions
    public static void sharedCounterWithSynchronization() {
        SharedCounter sharedCounter = new SharedCounter();

        // Task to increment the counter 1000 times
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                sharedCounter.increment();
            }
        };

        // Creating two threads that share the same counter
        Thread thread1 = new Thread(task, "Thread 1");
        Thread thread2 = new Thread(task, "Thread 2");

        // Starting both threads
        thread1.start();
        thread2.start();

        // Waiting for both threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Printing the final value of the counter
        System.out.println("Final counter value: " + sharedCounter.getCounter());
    }

    public static void main(String[] args) {
        sharedCounterWithSynchronization();
    }
}