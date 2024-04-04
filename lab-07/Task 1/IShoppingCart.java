interface IShoppingCart {
  double calculateTotal();

  double getNetPrice();

  void addDeliveryFee(int fee);

  int getDeliveryFee();

  void addItem(String item);
}
