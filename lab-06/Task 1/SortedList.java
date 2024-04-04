public class SortedList extends PythonList {
  public SortedList(int[] arr) {
    super(arr);
    setFastMode();
    setStrategy(new SortedListStrategy());
  }
}
