class ShoppingCartDecorator implements IShoppingCart {
  protected IShoppingCart wrappee;

  ShoppingCartDecorator(IShoppingCart cart) {
    wrappee = cart;
  }

  public double calculateTotal() {
    return wrappee.calculateTotal();
  }

  public double getNetPrice() {
    return wrappee.getNetPrice();
  }

  public void addDeliveryFee(int fee) {
    wrappee.addDeliveryFee(fee);
  }

  public int getDeliveryFee() {
    return wrappee.getDeliveryFee();
  }

  public void addItem(String item) {
    wrappee.addItem(item);
  }
}
