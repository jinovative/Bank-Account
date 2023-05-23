package bank;

public class CheckingAccount implements IAccount {
    private double balance;

    public CheckingAccount(double starterAmount) {
        if (starterAmount < 0.01) {
            throw new IllegalArgumentException("The starter amount has to be overed 1cent");
        }
        this.balance = starterAmount;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;

    }

    @Override
    public boolean withdraw(double amount) {
        balance -= amount;
        return true;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void performMonthlyMaintenance() {
        if (balance <100) {
            balance -= 5;
        }
    }
}
