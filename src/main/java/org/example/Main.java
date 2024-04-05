package org.example;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Random random = new Random();

        BankAccount[] accounts = new BankAccount[10];

        accounts[0] = new BankAccount(1111, "James", 70);
        accounts[1] = new BankAccount(1112, "Mike", 1200);
        accounts[2] = new BankAccount(1113, "Elen", 3700);
        accounts[3] = new BankAccount(1114, "Jessie", 5400);
        accounts[4] = new BankAccount(1115, "Stacy", 540);
        accounts[5] = new BankAccount(1116, "Cathryn", 530);
        accounts[6] = new BankAccount(1117, "Adela", 7560);
        accounts[7] = new BankAccount(1118, "Cody", 5450);
        accounts[8] = new BankAccount(1119, "Mellie", 65560);
        accounts[9] = new BankAccount(1110, "Gail", 106);

        for (BankAccount account : accounts) {
            bank.addAccount(account);
        }

        ThreadGroup regularClientsGroup = new ThreadGroup("Regular Clients");
        ThreadGroup vipClientsGroup = new ThreadGroup("VIP Clients");

        for (int i = 0; i < 10; i++) {
            boolean isDeposit = random.nextBoolean();
            int amount = random.nextInt(100);
            ThreadGroup clientGroup = i < 5 ? regularClientsGroup : vipClientsGroup;
            try {
                new Thread(clientGroup, new Client(bank, accounts[i].getAccountNumber(), amount, isDeposit ? "deposit" : "withdrawal"), "Client " + i).start();
            } catch (IllegalArgumentException e) {
                System.out.println("Error creating client thread: " + e.getMessage());
            }
        }
    }
}