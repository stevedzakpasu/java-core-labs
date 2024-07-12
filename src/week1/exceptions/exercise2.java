package week1.exceptions;

public class exercise2 {

    public void nestedTryCatchExample() {
        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[5]);

            try {
                int result = numbers[2] / 0;
                System.out.println(result);
            } catch (ArithmeticException e) {
                System.out.println("Caught an arithmetic exception: " + e.getMessage());
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught an array index out-of-bounds exception: " + e.getMessage());

            try {
                String text = null;
                System.out.println(text.length());
            } catch (NullPointerException e2) {
                System.out.println("Caught a null pointer exception: " + e2.getMessage());
            }
        }
    }
    public static void main(String[] args) {
    exercise2 example = new exercise2();
    example.nestedTryCatchExample();
}
}