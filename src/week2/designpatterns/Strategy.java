package week2.designpatterns;

public class Strategy {

    public interface SortingStrategy {
        void sort(int[] array);
    }

    public static class BubbleSort implements SortingStrategy {
        @Override
        public void sort(int[] array) {
            System.out.println("Sorting array using Bubble Sort");
        }
    }

    public static class QuickSort implements SortingStrategy {
        @Override
        public void sort(int[] array) {
            System.out.println("Sorting array using Quick Sort");
        }
    }

    public static class Sorter {
        private SortingStrategy strategy;

        public Sorter(SortingStrategy strategy) {
            this.strategy = strategy;
        }

        public void setStrategy(SortingStrategy strategy) {
            this.strategy = strategy;
        }

        public void performSort(int[] array) {
            strategy.sort(array);
        }
    }
}