package Q6;

public class Main {

    public static void processPaymentMethod(String Type, String offerCode) {
        PaymentService service = new PaymentService();

        try {
            service.paymentMethod(Type, offerCode);
        } catch (PaymentException e) {
            if (e instanceof InvalidPaymentMethodException ipme) {
                System.out.println("Payment failed: " + ipme.getMessage());
            } else if (e instanceof InvalidOfferAppliedException ioae) {
                System.out.println("Offer error: " + ioae.getMessage());
            } else {
                System.out.println("General Payment Error: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        processPaymentMethod("UPI", "DISCOUNT10");       
        processPaymentMethod("Cash", "DISCOUNT10");      
        processPaymentMethod("Card", "INVALIDOFFER");    
    }
}

