package org.example;

public class Client extends Thread {
    private Bank bank;
    private int accountNumber;
    private double amount;
    private String transaction;

    public Client(Bank bank, int accountNumber, double amount, String transaction) {
        this.bank = bank;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.transaction = transaction;
    }
    @Override
    public void run() {
        if (bank == null) {
            System.out.println("Error: Bank instance is null.");
            return;
        }

        if (accountNumber < 0) {
            System.out.println("Error: Invalid account number.");
            return;
        }

        BankAccount account = bank.getAccount(accountNumber);
        if (account != null) {
            switch (transaction) {
                case "deposit":
                    account.deposit(amount);
                    break;
                case "withdrawal":
                    if (amount > account.checkBalance()) {
                        System.out.println("Error: Insufficient balance for withdrawal.");
                        return;
                    }
                    account.withdraw(amount);
                    break;
                default:
                    System.out.println("Error: Invalid transaction type.");
                    return;
            }
            double balance = account.checkBalance();
            System.out.println("Balance for account " + accountNumber + ": " + balance);
        } else {
            System.out.println("Account not found.");
        }
    }
}