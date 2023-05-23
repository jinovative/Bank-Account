package bank;

/**
 * Representing saving account in bank.
 */
public class SavingsAccount implements IAccount {
    private double balance;
    private int withdrawCounting;

    /**
     * Construct SavingsAccount with starterAmount.
     *
     * @param starterAmount initial amount in account
     * @throws IllegalArgumentException if staterAmount is under 1 cent
     */

    public SavingsAccount(double starterAmount) {
        if (starterAmount < 0.01) {
            throw new IllegalArgumentException("The starter amount has to be overed 1cent");
        }
        this.balance = starterAmount;
        this.withdrawCounting = 0;

    }

    /**
     * Deposit specific amount in account.
     *
     * @param amount amount to deposit
     * @throws IllegalArgumentException amount can not be negative
     */
    @Override
    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be overed 0");
        }
        balance += amount;

    }

    /**
     * Withdraw specific amount in account.
     *
     * If amount is bigger than balance, return false.
     * If withdrawing counting is over 6, charge $6.
     * @param amount amount to withdraw
     * @throws IllegalArgumentException amount can not be negative
     * @return true if withdraw is successfully done
     */
    @Override
    public boolean withdraw(double amount) {
        if (amount <0) {
            throw new IllegalArgumentException("Amount must be overed 0");
        }
        if (amount > balance) {
            return  false;
        }

        if (withdrawCounting >= 6) {
            balance -= 14;
        }

        balance -= amount;
        withdrawCounting ++;
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
     * Reset the withdrawal count to 0.
     */
    @Override
    public void performMonthlyMaintenance() {
        withdrawCounting = 0;

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
