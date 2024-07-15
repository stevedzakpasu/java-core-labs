package week2.designpatterns;

public class Adapter {
    public static class LegacyPaymentLibrary {
        public void processPayment(int amount) {
            System.out.println("Processing payment with amount: " + amount);
        }
    }

    public static class PaymentAdapter {
        private LegacyPaymentLibrary legacyPaymentLibrary;

        public PaymentAdapter(LegacyPaymentLibrary legacyPaymentLibrary) {
            this.legacyPaymentLibrary = legacyPaymentLibrary;
        }

        public void processPayment(float amount) {
            int intAmount = (int) amount;
            legacyPaymentLibrary.processPayment(intAmount);
        }
    }
}