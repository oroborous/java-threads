package edu.wctc;

public class BankAccount {
    private int balance = 0;

    public void deposit(int amount) {
        int newBalance = balance + amount;

        // Artificial delay
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        balance = newBalance;
    }

    public void deposit2(int amount) {
        synchronized (this) {
            int newBalance = balance + amount;
            balance = newBalance;
        }
        // other code that doesn't require synchronization
    }

    public int getBalance() {
        return balance;
    }
}
