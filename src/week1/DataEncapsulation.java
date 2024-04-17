package week1;//Lab Exercise #2: Leverage Inner Classes for Data Encapsulation

public class DataEncapsulation {

        private int data;

        public DataEncapsulation(int data) {
            this.data = data;
        }

        public class Inner {
            public int getData() {
                return data;
            }

            public void setData(int newData) {
                data = newData;
            }
        }
    }



