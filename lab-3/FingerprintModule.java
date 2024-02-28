public class FingerprintModule {
  private String fingerprintSerialNumber;
  private String fingerprint;

  public String getFingerprintSerialNumber() {
    return fingerprintSerialNumber;
  }

  FingerprintModule(String fingerprintSerialNumber) {
    this.fingerprintSerialNumber = fingerprintSerialNumber;
  }

  public void registerFingerprint(String fingerprint) {
    this.fingerprint = fingerprint;
  }

  public boolean checkFingerprint(String fingerprint) {
    return this.fingerprint.equals(fingerprint);
  }
}
