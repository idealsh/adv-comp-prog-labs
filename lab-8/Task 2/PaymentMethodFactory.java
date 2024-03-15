public class PaymentMethodFactory {
  public PaymentMethod createPaymentMethod(String type) {
    if (type.equals("credit card")) {
      return new CreditCardPayment();
    } else if (type.equals("paypal")) {
      return new PayPalPayment();
    } else if (type.equals("crypto")) {
      return new CryptoPayment();
    } else {
      throw new IllegalArgumentException();
    }
  }
}
