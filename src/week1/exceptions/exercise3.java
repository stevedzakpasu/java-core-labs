package week1.exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class exercise3 {

    public void readFileSafely(String filePath) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
    exercise3 example = new exercise3();
    example.readFileSafely("file.txt");
}
}