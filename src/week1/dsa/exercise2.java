package week1.dsa;

import java.util.PriorityQueue;

public class exercise2 {


    class Task implements Comparable<Task> {
        int priority;
        String description;

        public Task(int priority, String description) {
            this.priority = priority;
            this.description = description;
        }

        @Override
        public int compareTo(Task o) {
            return this.priority - o.priority;
        }
    }

    public class TaskScheduler {
        private PriorityQueue<Task> minHeap;

        public TaskScheduler() {
            minHeap = new PriorityQueue<>();
        }

        public void addTask(int priority, String description) {
            Task task = new Task(priority, description);
            minHeap.add(task);
        }

        public Task getNextTask() {
            return minHeap.poll();
        }

        public boolean isEmpty() {
            return minHeap.isEmpty();
        }

        public void main(String[] args) {
            TaskScheduler scheduler = new TaskScheduler();
            scheduler.addTask(3, "Low priority task");
            scheduler.addTask(1, "High priority task");
            scheduler.addTask(2, "Medium priority task");

            while (!scheduler.isEmpty()) {
                Task task = scheduler.getNextTask();
                System.out.println("Processing task: " + task.description + " with priority " + task.priority);
            }
        }
    }

}
