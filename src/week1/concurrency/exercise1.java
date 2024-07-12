package week1.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class exercise1 {

    // Method to process images using a thread pool
    public static void imageProcessingWithThreadPool() {
        // Array of image names to be processed
        String[] images = {"image1.jpg", "image2.jpg", "image3.jpg", "image4.jpg", "image5.jpg"};

        // Creating a thread pool with 3 threads
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // Submitting tasks for processing each image
        for (String image : images) {
            executorService.submit(() -> {
                System.out.println("Processing image: " + image);
                try {
                    // Simulating image processing time
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
                System.out.println("Finished processing image: " + image);
            });
        }

        // Initiating shutdown of the thread pool
        executorService.shutdown();
    }

    public static void main(String[] args) {
        imageProcessingWithThreadPool();
    }
}