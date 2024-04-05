package org.example;

public class BankAccount {
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(int accountNumber, String accountHolderName, double balance) {
        if (accountNumber <= 0) {
            throw new IllegalArgumentException("Account number must be positive.");
        }
        if (accountHolderName == null || accountHolderName.isEmpty()) {
            throw new IllegalArgumentException("Account holder name cannot be empty.");
        }
        if (balance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }
    public synchronized void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Deposit amount must be non-negative.");
        }
        balance += amount;
    }
    public synchronized void withdraw(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Withdrawal amount must be non-negative.");
        }
        if (balance >= amount) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("Insufficient funds.");
        }
    }
    public synchronized double checkBalance() {
        return balance;
    }
    public Integer getAccountNumber() {
        return this.accountNumber;
    }
    public String getAccountHolderName() {
        return this.accountHolderName;
    }
}