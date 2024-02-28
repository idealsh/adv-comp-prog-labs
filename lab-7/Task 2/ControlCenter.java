import java.util.List;
import java.util.LinkedList;

public class ControlCenter implements Observable {
  private List<Observer> observers = new LinkedList<Observer>();

  public void registerObserver(Observer observer) {
    observers.add(observer);
  }

  public void removeObserver(Observer observer) {
    observers.remove(observer);
  }

  public void notifyAll(String status) {
    for (Observer observer : observers) {
      observer.update(status);
    }
  }

  void openAllDoors() {
    notifyAll("open");
  }

  void closeAllDoors() {
    notifyAll("close");
  }
}
