package Q6;

public sealed class PaymentException extends Exception
        permits InvalidPaymentMethodException, InvalidOfferAppliedException {

    public PaymentException(String message) {
        super(message);
    }
}

