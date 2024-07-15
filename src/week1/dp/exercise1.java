package week1.dp;
import java.util.Arrays;
import java.util.Comparator;

public class exercise1 {


    class Item {
        int value, weight;
        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }

    public class FractionalKnapsack {
        // Function to get maximum value
        private static double getMaxValue(int capacity, Item[] items) {
            // Sort items by value-to-weight ratio
            Arrays.sort(items, new Comparator<Item>() {
                @Override
                public int compare(Item a, Item b) {
                    double r1 = (double) a.value / a.weight;
                    double r2 = (double) b.value / b.weight;
                    return Double.compare(r2, r1);
                }
            });

            double totalValue = 0;

            for (Item item : items) {
                if (capacity - item.weight >= 0) {
                    // This weight can be picked whole
                    capacity -= item.weight;
                    totalValue += item.value;
                } else {
                    // Item can't be picked whole
                    double fraction = ((double) capacity / (double) item.weight);
                    totalValue += (item.value * fraction);
                    capacity = (int) (capacity - (item.weight * fraction));
                    break;
                }
            }
            return totalValue;
        }

        public void main(String[] args) {
            Item[] items = {
                    new Item(60, 10),
                    new Item(100, 20),
                    new Item(120, 30)
            };
            int capacity = 50;

            double maxValue = getMaxValue(capacity, items);
            System.out.println("Maximum value we can obtain = " + maxValue);
        }
    }

}
