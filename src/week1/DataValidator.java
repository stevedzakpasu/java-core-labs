package week1;//Lab Exercise #3: Create a Generic Method for Data Validation

public class DataValidator {
    public static <T extends Comparable<T>> boolean validateData(T data, T threshold) {
        return data.compareTo(threshold) > 0;
    }
}
