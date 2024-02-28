interface Observable {
  void registerObserver(Observer subscriber);

  void removeObserver(Observer subscriber);

  void notifyAll(String data);
}
