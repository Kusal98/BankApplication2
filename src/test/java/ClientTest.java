import org.junit.Test;
import static org.junit.Assert.*;
import org.example.Bank;
import org.example.BankAccount;
import org.example.Client;

public class ClientTest {

    @Test
    public void testDepositTransaction() {
        Bank bank = new Bank();
        BankAccount account = new BankAccount(123456, "jack",1000);
        bank.addAccount(account);
        Client client = new Client(bank, 123456, 500, "deposit");
        client.run();
        assertEquals(1500, account.checkBalance(), 0);
    }

    @Test
    public void testWithdrawalTransaction() {

        Bank bank = new Bank();
        BankAccount account = new BankAccount(123456, "jack",1000);
        bank.addAccount(account);
        Client client = new Client(bank, 123456, 500, "withdrawal");
        client.run();
        assertEquals(500, account.checkBalance(), 0);
    }

    @Test
    public void testInvalidAccountNumber() {
        Bank bank = new Bank();
        Client client = new Client(bank, -123456, 500, "deposit");
        client.run();

    }

}