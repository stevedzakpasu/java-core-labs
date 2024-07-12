package week1.oop;

public class exercise2 {

    // Field to store data
    private int data;

    // Constructor to initialize data
    public exercise2(int data) {
        this.data = data;
    }

    // Inner class to access and modify the outer class's data field
    public class Inner {
        // Returns the data field of the outer class
        public int getData() {
            return data;
        }

        // Sets the data field of the outer class to a new value
        public void setData(int newData) {
            data = newData;
        }
    }
}