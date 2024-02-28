public class SimpleTransactionManager implements TransactionManager {
  private String[] wallets = new String[1000];
  private String[] transactions = new String[10000];
  private int walletCount = 0;
  private int transactionCount;

  public SimpleTransactionManager(String[] wallets) {
    for (int i = 0; i < wallets.length; i++) {
      this.wallets[i] = wallets[i];
      walletCount++;
    }
  }

  @Override
  public boolean transferFunds(String senderWalletId, String receiverWalletId, double amount)
      throws InvalidTransactionException, IllegalArgumentException {

    if (!isValidWallet(senderWalletId))
      throw new IllegalArgumentException("Sender wallet does not exist.");

    double senderBalance = getBalance(senderWalletId);

    if (!senderWalletId.equals("Wallet0") && senderBalance < amount)
      throw new InvalidTransactionException("Not enough balance in the source wallet.");

    if (!isValidWallet(receiverWalletId)) {
      wallets[walletCount++] = receiverWalletId;
    }

    transactions[transactionCount++] = senderWalletId + "|" + receiverWalletId + "|" + amount;
    return true;
  }

  @Override
  public double getBalance(String walletId) {
    if (!isValidWallet(walletId))
      throw new IllegalArgumentException("Invalid wallet ID.");

    double balance = 0.0;
    for (int i = 0; i < transactionCount; i++) {
      String[] parts = transactions[i].split("\\|");
      String senderId = parts[0];
      String receiverId = parts[1];
      double amount = Double.parseDouble(parts[2]);

      if (senderId.equals(walletId))
        balance -= amount;
      if (receiverId.equals(walletId))
        balance += amount;
    }

    return balance;
  }

  @Override
  public boolean isValidWallet(String walletId) {
    for (int i = 0; i < walletCount; i++) {
      if (wallets[i].equals(walletId))
        return true;
    }

    return false;
  }
}
