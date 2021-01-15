package edu.wctc;

public class DepositPennyTask implements Runnable {
    private BankAccount bankAccount;

    public DepositPennyTask(BankAccount bankAccount){
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        bankAccount.deposit(1);
    }
}
