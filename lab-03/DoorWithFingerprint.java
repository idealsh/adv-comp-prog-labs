public class DoorWithFingerprint extends Door {
  private FingerprintModule fingerprintModule;

  DoorWithFingerprint(String doorID) {
    super(doorID);
  }

  public void installFingerprintModule(FingerprintModule module) {
    fingerprintModule = module;

    System.out.println(
        "A fingerprint module with serial " + fingerprintModule.getFingerprintSerialNumber() + " already installed.");
  }

  public void close(String fingerprint) {
    fingerprintModule.registerFingerprint(fingerprint);
    super.lock();
  }

  public void open(String fingerprint) {
    if (fingerprintModule.checkFingerprint(fingerprint)) {
      super.unlock();
    }

    super.open();
  }

}
