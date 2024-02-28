import java.util.NoSuchElementException;

interface FindMinMaxStrategy {
  public int findMin(int[] a);

  public int findMax(int[] a);
}

class FindMinMaxSortedStrategy implements FindMinMaxStrategy {

  @Override
  public int findMin(int[] a) {
    if (a.length == 0) {
      throw new NoSuchElementException("This array is empty");
    }
    return a[0];
  }

  @Override
  public int findMax(int[] a) {
    if (a.length == 0) {
      throw new NoSuchElementException("This array is empty");
    }
    return a[a.length - 1];
  }

}

class FindMinMaxUnSortedStrategy implements FindMinMaxStrategy {

  @Override
  public int findMin(int[] a) {
    if (a.length == 0) {
      throw new NoSuchElementException("This array is empty");
    }
    int min = a[0];
    for (int i = 0; i < a.length; i++) {
      if (a[i] < min) {
        min = a[i];
      }
    }
    return min;
  }

  @Override
  public int findMax(int[] a) {
    if (a.length == 0) {
      throw new NoSuchElementException("This array is empty");
    }
    int max = a[0];
    for (int e : a) {
      if (e > max) {
        max = e;
      }
    }
    return max;
  }

}

public class PythonList {
  private int[] v;
  private FindMinMaxStrategy findMinMax;
  private ListStrategy listStrategy;

  public PythonList(int[] v) {
    this.v = new int[v.length];
    for (int i = 0; i < v.length; i++) {
      this.v[i] = v[i];
    }
    this.findMinMax = new FindMinMaxUnSortedStrategy();
    this.listStrategy = new UnsortedListStrategy();
  }

  public void append(int value) {
    v = listStrategy.append(v, value);
  }

  public boolean contains(int value) {
    return listStrategy.contains(v, value);
  }

  public String toString() {
    if (v.length == 0)
      return "[]";
    String out = "[";
    for (int a : v) {
      out += a + ", ";
    }
    out = out.substring(0, out.length() - 2) + "]";
    return out;
  }

  public void setStrategy(ListStrategy listStrategy) {
    this.listStrategy = listStrategy;
  }

  public int findMax() {
    return findMinMax.findMax(v);
  }

  public int findMin() {
    return findMinMax.findMin(v);
  }

  public void setNormalMode() {
    this.findMinMax = new FindMinMaxUnSortedStrategy();
  }

  public void setFastMode() {
    for (int lastIndex = v.length - 1; lastIndex >= 1; lastIndex--) {
      int maxIndex = 0;
      for (int i = 0; i <= lastIndex; i++) {
        if (v[i] > v[maxIndex]) {
          maxIndex = i;
        }
      }
      int temp = v[maxIndex];
      v[maxIndex] = v[lastIndex];
      v[lastIndex] = temp;
    }
    this.findMinMax = new FindMinMaxSortedStrategy();
  }
}
