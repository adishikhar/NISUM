package Q6;

public class PaymentService {

    public void paymentMethod(String Type, String offerCode) throws PaymentException {
        if (!Type.equalsIgnoreCase("UPI") &&
            !Type.equalsIgnoreCase("Card")) {
            throw new InvalidPaymentMethodException("Invalid payment type: " +Type);
        }

        if (!offerCode.equalsIgnoreCase("DISCOUNT10") &&
            !offerCode.equalsIgnoreCase("OFFER50")) {
            throw new InvalidOfferAppliedException("Invalid offer: " + offerCode);
        }

        System.out.println("Payment successful");
    }
}

