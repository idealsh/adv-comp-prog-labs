class Door implements Observer {
  private boolean isOpened = false;
  private String name;

  Door(String name) {
    this.name = name;
  }

  public void update(String status) {
    if (status.equals("open"))
      open();
    else if (status.equals("close"))
      close();
  }

  void open() {
    isOpened = true;
    System.out.println("Door " + name + " opened");
  }

  void close() {
    isOpened = false;
    System.out.println("Door " + name + " closed");
  }
}