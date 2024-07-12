package week1.exceptions;

import java.io.IOException;

public class exercise1 {

    public void throwCheckedException() throws IOException {
        throw new IOException("This is a checked exception");
    }

    public void throwUncheckedException() {
        throw new ArithmeticException("This is an unchecked exception");
    }

    public void handleExceptions() {
        try {
            throwCheckedException();
        } catch (IOException e) {
            System.out.println("Caught checked exception: " + e.getMessage());
        }

        try {
            throwUncheckedException();
        } catch (ArithmeticException e) {
            System.out.println("Caught unchecked exception: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        exercise1 example = new exercise1();
        example.handleExceptions();
    }
}