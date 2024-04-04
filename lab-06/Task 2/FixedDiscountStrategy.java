class FixedDiscountStrategy implements DiscountStrategy {
  double discount;

  FixedDiscountStrategy(double discount) {
    this.discount = discount;
  }

  @Override
  public double getDiscountedPrice(double initialPrice) {
    return initialPrice - discount;
  }
}
