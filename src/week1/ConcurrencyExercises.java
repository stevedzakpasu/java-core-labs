package week1;

import java.util.concurrent.*;

public class ConcurrencyExercises {

    public static void imageProcessingWithThreadPool() {

        String[] images = {"image1.jpg", "image2.jpg", "image3.jpg", "image4.jpg", "image5.jpg"};

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (String image : images) {
            executorService.submit(() -> {
                System.out.println("Processing image: " + image);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Finished processing image: " + image);
            });
        }

        executorService.shutdown();
    }

    public static void threadSafeCache() {
        ConcurrentHashMap<String, String> cache = new ConcurrentHashMap<>();

        cache.put("key1", "value1");
        cache.put("key2", "value2");
        cache.put("key3", "value3");

        Runnable task = () -> {
            for (int i = 0; i < 10; i++) {
                String value = cache.get("key" + (i % 3 + 1));
                System.out.println(Thread.currentThread().getName() + " retrieved value: " + value);
            }
        };

        Thread thread1 = new Thread(task, "Thread 1");
        Thread thread2 = new Thread(task, "Thread 2");
        Thread thread3 = new Thread(task, "Thread 3");

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class SharedCounter {
        private int counter = 0;

        public synchronized void increment() {
            counter++;
        }

        public int getCounter() {
            return counter;
        }
    }

    public static void sharedCounterWithSynchronization() {
        SharedCounter sharedCounter = new SharedCounter();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                sharedCounter.increment();
            }
        };

        Thread thread1 = new Thread(task, "Thread 1");
        Thread thread2 = new Thread(task, "Thread 2");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final counter value: " + sharedCounter.getCounter());
    }

    private static class Resource {
        private final int id;

        public Resource(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }

    public static void deadlockExample() {
        Resource resource1 = new Resource(1);
        Resource resource2 = new Resource(2);

        Runnable task1 = () -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread().getName() + " acquired lock on resource " + resource1.getId());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resource2) {
                    System.out.println(Thread.currentThread().getName() + " acquired lock on resource " + resource2.getId());
                }
            }
        };

        Runnable task2 = () -> {
            synchronized (resource2) {
                System.out.println(Thread.currentThread().getName() + " acquired lock on resource " + resource2.getId());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resource1) {
                    System.out.println(Thread.currentThread().getName() + " acquired lock on resource " + resource1.getId());
                }
            }
        };

        Thread thread1 = new Thread(task1, "Thread 1");
        Thread thread2 = new Thread(task2, "Thread 2");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}