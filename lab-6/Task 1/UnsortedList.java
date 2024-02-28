public class UnsortedList extends PythonList {
  public UnsortedList(int[] list) {
    super(list);
    setStrategy(new UnsortedListStrategy());
  }
}
