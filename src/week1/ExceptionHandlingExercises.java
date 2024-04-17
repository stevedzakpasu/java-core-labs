package week1;

import java.io.*;

public class ExceptionHandlingExercises {


    public void throwCheckedException() throws IOException {
        throw new IOException("This is a checked exception");
    }

    public void throwUncheckedException() {
        throw new ArithmeticException("This is an unchecked exception");
    }


    public void nestedTryCatch() {
        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[5]);

            try {
                int result = numbers[2] / 0; // This will throw an ArithmeticException
                System.out.println(result);
            } catch (ArithmeticException e) {
                e.printStackTrace();
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }


    public void readFile() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("file.txt"));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public class CustomException extends RuntimeException {
        public CustomException(String message) {
            super(message);
        }
    }

    public void testCustomException() {
        throw new CustomException("This is a custom exception");
    }


}