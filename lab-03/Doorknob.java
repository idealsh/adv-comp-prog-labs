public class Doorknob {
  private String doorknobID;

  Doorknob(String doorknobID) {
    this.doorknobID = doorknobID;
  }

  public String getDoorknobID() {
    return doorknobID;
  }

  public boolean canUnlock(Key key) {
    return doorknobID.equals(key.getID());
  }
}
