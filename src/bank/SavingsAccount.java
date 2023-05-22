package bank;

public class SavingsAccount implements IAccount {
    private double balance;
    private int withdrawCounting;

    public SavingsAccount(double starterAmount) {
        if (starterAmount < 0.01) {
            throw new IllegalArgumentException("The starter amount has to be overed 1cent");
        }

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
