public interface ListStrategy {
  int[] append(int[] currentArr, int value);

  boolean contains(int[] currentArr, int value);
}
