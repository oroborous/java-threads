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

    public void depositSyncBlock(int amount) {
        synchronized (this) {
            int newBalance = balance + amount;
            balance = newBalance;
        }
        // other code that doesn't require synchronization
    }

    public synchronized void depositSyncMethod(int amount) {
        int newBalance = balance + amount;
        balance = newBalance;
    }

    public int getBalance() {
        return balance;
    }
}
