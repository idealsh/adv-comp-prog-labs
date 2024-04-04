class PercentageDiscountStrategy implements DiscountStrategy {
  double factor;

  PercentageDiscountStrategy(double percentage) {
    factor = (100 - percentage) / 100;
  }

  @Override
  public double getDiscountedPrice(double initialPrice) {
    return initialPrice * factor;
  }
}
