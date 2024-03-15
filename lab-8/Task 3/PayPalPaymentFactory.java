public class PayPalPaymentFactory implements PaymentMethodFactory {
  public PaymentMethod createPaymentMethod() {
    return new PayPalPayment();
  }
}
