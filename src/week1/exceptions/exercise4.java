package week1.exceptions;

public class exercise4 {

    // Custom exception class extending RuntimeException
    public static class InvalidInputException extends RuntimeException {
        public InvalidInputException(String message) {
            super(message);
        }
    }

    // Method to simulate a scenario where the custom exception is thrown
    public void validateUserInput(int input) {
        try {
            // Simulating a scenario where only positive numbers are valid
            if (input < 0) {
                throw new InvalidInputException("Input must be a positive number.");
            }
            System.out.println("Valid input: " + input);
        } catch (InvalidInputException e) {
            System.out.println("Caught an invalid input exception: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        exercise4 example = new exercise4();
        example.validateUserInput(-5); // This will throw and catch the custom exception
    }
}