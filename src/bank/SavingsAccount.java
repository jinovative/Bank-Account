package bank;

public class SavingsAccount implements  IAccount{
  private double balance;
  private int withdrawalCount;

  public SavingsAccount(double initialAmount) {
    if (initialAmount < 0.01) {
      throw new IllegalArgumentException("The starter amount must be greater than or equal to one cent.");
    }
    this.balance = initialAmount;
    this.withdrawalCount = 0;
  }

  @Override
  public void deposit(double amount) {

  }

  @Override
  public boolean withdraw(double amount) {
    return false;
  }

  @Override
  public double getBalance() {
    return 0;
  }

  @Override
  public void performMonthlyMaintenance() {

  }
}
