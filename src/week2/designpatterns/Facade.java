package week2.designpatterns;

public class Facade {

    public static class InventorySystem {
        public void updateInventory(String item, int quantity) {
            System.out.println("Updating inventory for " + item + " with quantity " + quantity);
        }
    }

    public static class PaymentSystem {
        public void processPayment(float amount) {
            System.out.println("Processing payment for amount: " + amount);
        }
    }

    public static class ShippingSystem {
        public void shipOrder(String address) {
            System.out.println("Shipping order to " + address);
        }
    }

    public static class OrderProcessingFacade {
        private InventorySystem inventorySystem;
        private PaymentSystem paymentSystem;
        private ShippingSystem shippingSystem;

        public OrderProcessingFacade() {
            inventorySystem = new InventorySystem();
            paymentSystem = new PaymentSystem();
            shippingSystem = new ShippingSystem();
        }

        public void placeOrder(String item, int quantity, float amount, String address) {
            inventorySystem.updateInventory(item, quantity);
            paymentSystem.processPayment(amount);
            shippingSystem.shipOrder(address);
            System.out.println("Order placed successfully!");
        }
    }
}