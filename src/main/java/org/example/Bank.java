package org.example;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Bank {
    private static final Logger LOGGER = Logger.getLogger(Bank.class.getName());
    private ConcurrentHashMap<Integer, BankAccount> accounts;

    public Bank() {
        this.accounts = new ConcurrentHashMap<>();
    }
    public void addAccount(BankAccount account) {
        if (account == null) {
            LOGGER.log(Level.WARNING, "Trying to add a null account.");
            throw new IllegalArgumentException("Cannot add a null account.");
        }
        accounts.putIfAbsent(account.getAccountNumber(), account);
    }
    public BankAccount getAccount(int accountNumber) {
        if (accountNumber < 0) {
            LOGGER.log(Level.WARNING, "Invalid account number: " + accountNumber);
            return null;
        }
        return accounts.get(accountNumber);
    }
}