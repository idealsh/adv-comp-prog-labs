class SortedListStrategy implements ListStrategy {

  @Override
  public int[] append(int[] currentArr, int value) {
    int[] a = new int[currentArr.length + 1];
    int i = 0;
    while (value > currentArr[i]) {
      a[i] = currentArr[i];
      i++;
    }
    a[i++] = value;
    for (int j = i - 1; j < currentArr.length; j++) {
      a[i++] = currentArr[j];
    }
    return a;
  }

  @Override
  public boolean contains(int[] currentArr, int value) {
    int left = 0;
    int right = currentArr.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;

      // If the middle element is equal to v, return true
      if (currentArr[mid] == value) {
        return true;
      }

      // If v is less than the middle element, search in the left half
      if (currentArr[mid] > value) {
        right = mid - 1;
      }
      // If v is greater than the middle element, search in the right half
      else {
        left = mid + 1;
      }
    }

    // If the loop finishes without finding v, return false
    return false;
  }

}
