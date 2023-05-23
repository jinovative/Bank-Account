package bank;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class CheckingAccountTest {

    @Test
    public void testDeposit() {
        CheckingAccount account = new CheckingAccount(100.0);
        account.deposit(100.0);
        assertEquals(200.0, account.getBalance(), 0.00);
    }


    @Test
    public void testWithdraw() {
        CheckingAccount account = new CheckingAccount(200.0);
        assertTrue(account.withdraw(100.0));
        assertEquals(100.0, account.getBalance(), 0.00);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawWithNegativeAmount() {
        CheckingAccount account = new CheckingAccount(100.0);
        account.withdraw(-100.0);
    }

    @Test
    public void testGetBalance() {
        CheckingAccount account = new CheckingAccount(100.0);
        assertEquals(100.0, account.getBalance(), 0.00);
    }

    @Test
    public void testPerformMonthlyMaintenance() {
        CheckingAccount account = new CheckingAccount(100.0);
        account.performMonthlyMaintenance();
        assertEquals(100.0, account.getBalance(), 0.00);

        account.withdraw(50.0);
        account.performMonthlyMaintenance();
        assertEquals(45.0, account.getBalance(), 0.00);

        account.deposit(100.0);
        account.performMonthlyMaintenance();
        assertEquals(145.0, account.getBalance(), 0.00);
    }

    @Test
    public void testToString() {
        CheckingAccount account = new CheckingAccount(100.0);
        assertEquals("$100.00", account.toString());
    }
}
