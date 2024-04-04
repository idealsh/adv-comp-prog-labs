import java.util.ArrayList;

class ShoppingCart implements IShoppingCart {
  ArrayList<String> items = new ArrayList<String>();
  public int deliveryFee = 0;

  public void addItem(String item) {
    items.add(item);
  }

  public double calculateTotal() {
    double total = 0;
    for (String item : items) {
      String[] parts = item.split(":");
      int quantity = Integer.valueOf(parts[1]);
      double price = Double.valueOf(parts[2]);

      total += quantity * price;
    }

    return total;
  }

  public double getNetPrice() {
    return calculateTotal() + deliveryFee;
  }

  public void addDeliveryFee(int fee) {
    deliveryFee = fee;
  }

  public int getDeliveryFee() {
    return deliveryFee;
  }
}