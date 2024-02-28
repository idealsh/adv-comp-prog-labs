class ShoppingCart {
  private Item[] items;
  private DiscountStrategy discountStrategy;

  public ShoppingCart() {
    items = new Item[0];
    discountStrategy = new FixedDiscountStrategy(0); // Default strategy
  }

  public void setDiscountStrategy(DiscountStrategy newDiscountStrategy) {
    discountStrategy = newDiscountStrategy;
  }

  public void addItem(Item item) {
    // Extend the array to accommodate the new item
    Item[] newItems = new Item[items.length + 1];
    for (int i = 0; i < items.length; i++)
      newItems[i] = items[i];
    newItems[items.length] = item;
    items = newItems;
  }

  public double calculateTotal() {
    double total = 0;
    for (Item item : items) {
      total += item.getPrice();
    }

    return discountStrategy.getDiscountedPrice(total);
  }
}