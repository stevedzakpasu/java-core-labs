package week2.designpatterns;

public class FactoryMethod {

    public interface Shape {
        void draw();
    }

    public static class Circle implements Shape {
        @Override
        public void draw() {
            System.out.println("Drawing Circle");
        }
    }

    public static class Square implements Shape {
        @Override
        public void draw() {
            System.out.println("Drawing Square");
        }
    }

    public static class ShapeFactory {
        public Shape createShape(String type) {
            if (type.equalsIgnoreCase("circle")) {
                return new Circle();
            } else if (type.equalsIgnoreCase("square")) {
                return new Square();
            } else {
                return null;
            }
        }
    }
}
