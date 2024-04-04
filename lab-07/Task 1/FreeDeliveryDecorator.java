class FreeDeliveryDecorator extends ShoppingCartDecorator {
  FreeDeliveryDecorator(IShoppingCart cart) {
    super(cart);
  }

  @Override
  public double getNetPrice() {
    // note that this actually *sets* the delivery fee to zero,
    // despite the confusing method name
    super.addDeliveryFee(0);
    return super.getNetPrice();
  }
}
