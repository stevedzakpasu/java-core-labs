package week1.oop;

public class exercise3 {
    // Validates if data is greater than a given threshold
    public static <T extends Comparable<T>> boolean validateData(T data, T threshold) {
        return data.compareTo(threshold) > 0;
    }
}