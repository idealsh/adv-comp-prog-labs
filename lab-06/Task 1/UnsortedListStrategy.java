class UnsortedListStrategy implements ListStrategy {

  @Override
  public int[] append(int[] currentArr, int value) {
    int[] a = new int[currentArr.length + 1];
    for (int i = 0; i < currentArr.length; i++) {
      a[i] = currentArr[i];
    }
    a[currentArr.length] = value;
    return a;
  }

  @Override
  public boolean contains(int[] currentArr, int value) {
    for (int a : currentArr) {
      if (a == value)
        return true;
    }
    return false;
  }
}
