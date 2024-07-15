package week2.designpatterns;

public class AbstractFactory {

    public interface Button {
        void render();
    }

    public static class WindowsButton implements Button {
        @Override
        public void render() {
            System.out.println("Rendering Windows Button");
        }
    }

    public static class MacOSButton implements Button {
        @Override
        public void render() {
            System.out.println("Rendering MacOS Button");
        }
    }

    public interface UIComponentFactory {
        Button createButton();
    }

    public static class WindowsUIComponentFactory implements UIComponentFactory {
        @Override
        public Button createButton() {
            return new WindowsButton();
        }
    }

    public static class MacOSUIComponentFactory implements UIComponentFactory {
        @Override
        public Button createButton() {
            return new MacOSButton();
        }
    }
}