class DiscountByPercentDecorator extends ShoppingCartDecorator {
  double percentage;

  DiscountByPercentDecorator(IShoppingCart cart, double percentage) {
    super(cart);
    this.percentage = percentage;
  }

  @Override
  public double getNetPrice() {
    // Remove the flat delivery fee that was included in super.getNetPrice()
    double priceWithoutDeliveryFee = super.getNetPrice() - super.getDeliveryFee();

    // Apply the discount to the price without delivery fee
    double discountedPrice = priceWithoutDeliveryFee * (100 - percentage) / 100;

    // Add the flat delivery fee back to the discounted price
    return discountedPrice + super.getDeliveryFee();
  }
}
