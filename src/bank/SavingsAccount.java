package bank;

public class SavingsAccount implements IAccount {
    private double balance;
    private int withdrawCounting;

    public SavingsAccount(double starterAmount) {
        if (starterAmount < 0.01) {
            throw new IllegalArgumentException("The starter amount has to be overed 1cent");
        }
        this.balance = starterAmount;
        this.withdrawCounting = 0;

    }
    @Override
    public void deposit(double amount) {
        balance += amount;

    }

    @Override
    public boolean withdraw(double amount) {
        balance -= amount;
        withdrawCounting ++;
        return true;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void performMonthlyMaintenance() {
        withdrawCounting = 0;

    }
}
