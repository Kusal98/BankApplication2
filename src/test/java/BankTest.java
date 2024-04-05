import org.example.Bank;
import org.example.BankAccount;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BankTest {
    private Bank bank;
    @Before
    public void setUp() {
        bank = new Bank();
        bank.addAccount(new BankAccount(12, "Alice", 1000));
    }
    @Test
    public void testAddAccount() {
        BankAccount newAccount = new BankAccount(32, "Bob", 2000);
        bank.addAccount(newAccount);
        Assert.assertNotNull(bank.getAccount(32));
    }
    @Test
    public void testGetAccount() {
        BankAccount account = bank.getAccount(12);
        Assert.assertNotNull(account);
        Assert.assertEquals("Alice", account.getAccountHolderName());
    }
    @Test
    public void testAddNullAccount() {
        try {
            bank.addAccount(null);
            Assert.fail("Adding null account should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            System.out.println("Error Occurred");
            e.printStackTrace();
        }
    }
    @Test
    public void testGetNonExistentAccount() {
        Assert.assertNull(bank.getAccount(999));
    }

}