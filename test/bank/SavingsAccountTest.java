package bank;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class SavingsAccountTest {

    @Test
    public void testDeposit() {
        SavingsAccount account = new SavingsAccount(100.0);
        account.deposit(100.0);
        assertEquals(200.0, account.getBalance(), 0.00);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDepositWithNegativeAmount() {
        SavingsAccount account = new SavingsAccount(100.0);
        account.deposit(-50.0);
    }

    @Test
    public void testWithdraw() {
        SavingsAccount account = new SavingsAccount(200.0);
        assertTrue(account.withdraw(100.0));
        assertEquals(100.0, account.getBalance(), 0.00);
    }

    @Test
    public void testWithdrawExceedBalance() {
        SavingsAccount account = new SavingsAccount(100.0);
        assertFalse(account.withdraw(150.0));
        assertEquals(100.0, account.getBalance(), 0.00);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawWithNegativeAmount() {
        SavingsAccount account = new SavingsAccount(100.0);
        account.withdraw(-50.0);
    }

    @Test
    public void testWithdrawCounting() {
        SavingsAccount account = new SavingsAccount(100.0);
        account.withdraw(10.0);
        account.withdraw(10.0);
        account.withdraw(10.0);
        account.withdraw(10.0);
        account.withdraw(10.0);
        account.withdraw(10.0);
        account.withdraw(10.0); // 7th withdrawal, should trigger charge
        assertEquals(36.0, account.getBalance(), 0.00);
        account.withdraw(10.0); // 8th withdrawal, no charge
        assertEquals(26.0, account.getBalance(), 0.00);
    }

    @Test
    public void testGetBalance() {
        SavingsAccount account = new SavingsAccount(100.0);
        assertEquals(100.0, account.getBalance(), 0.00);
    }

    @Test
    public void testPerformMonthlyMaintenance() {
        SavingsAccount account = new SavingsAccount(100.0);
        account.withdraw(50.0);
        account.performMonthlyMaintenance();
        assertEquals(50.0, account.getBalance(), 0.00);
    }

    @Test
    public void testToString() {
        SavingsAccount account = new SavingsAccount(100.0);
        assertEquals("$100.00", account.toString());
    }
}