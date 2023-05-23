package bank;

/**
 * Representing checking account in bank.
 */
public class CheckingAccount implements IAccount {

    private double balance;

    /**
     * Construct CheckingAccount with starterAmount.
     *
     * @param starterAmount initial amount in account
     * @throws IllegalArgumentException if staterAmount is under 1 cent
     */
    public CheckingAccount(double starterAmount) {
        if (starterAmount < 0.01) {
            throw new IllegalArgumentException("The starter amount has to be overed 1cent");
        }
        this.balance = starterAmount;
    }

    /**
     * Deposit money to account.
     *
     * @param amount amount to deposit
     */
    @Override
    public void deposit(double amount) {
        balance += amount;

    }

    /**
     * Withdraw money to account.
     *
     * @param amount amount to
     * @throws IllegalArgumentException amount can not be negative
     * @return true if withdraw is successfully done
     */
    @Override
    public boolean withdraw(double amount) {
        if (amount <0) {
            throw new IllegalArgumentException("Amount must be overed 0");
        }
        balance -= amount;
        return true;
    }

    /**
     * Return current balance.
     *
     * @return show balance
     */
    @Override
    public double getBalance() {
        return balance;
    }

    /**
     * Withdraw $5 for monthly maintenance account.
     * If the valance falls under $100, it will be charged $5.
     */
    @Override
    public void performMonthlyMaintenance() {
        if (balance <100) {
            balance -= 5;
        }
    }

    /**
     * Represent account balance.
     *
     * @return account balance to use dollar sign
     */
    public String toString() {
        return String.format("$%.2f", balance);
    }
}

