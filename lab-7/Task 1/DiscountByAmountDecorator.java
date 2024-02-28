class DiscountByAmountDecorator extends ShoppingCartDecorator {
  double discount;

  DiscountByAmountDecorator(IShoppingCart cart, double amount) {
    super(cart);
    this.discount = amount;
  }

  @Override
  public double getNetPrice() {
    return super.getNetPrice() - discount;
  }
}