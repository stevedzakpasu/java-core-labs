package week1.concurrency;

import java.util.concurrent.ConcurrentHashMap;

public class exercise2 {

    // Utilizes a thread-safe cache to demonstrate concurrent access and modification
    public static void threadSafeCache() {
        // Initialize a ConcurrentHashMap to ensure thread safety
        ConcurrentHashMap<String, String> cache = new ConcurrentHashMap<>();

        // Populating the cache with initial values
        cache.put("key1", "value1");
        cache.put("key2", "value2");
        cache.put("key3", "value3");

        // Define a task that reads from the cache
        Runnable task = () -> {
            for (int i = 0; i < 10; i++) {
                // Retrieving values in a round-robin fashion
                String value = cache.get("key" + (i % 3 + 1));
                // Outputting the retrieved value along with the current thread name
                System.out.println(Thread.currentThread().getName() + " retrieved value: " + value);
            }
        };

        // Creating and starting three threads to execute the task concurrently
        Thread thread1 = new Thread(task, "Thread 1");
        Thread thread2 = new Thread(task, "Thread 2");
        Thread thread3 = new Thread(task, "Thread 3");

        thread1.start();
        thread2.start();
        thread3.start();

        // Waiting for all threads to finish execution
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            // Handling possible interruption during thread join
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        threadSafeCache();
    }
}