package edu.wctc;

import javax.swing.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            raceCondition();
        }
    }

    public static void raceCondition() {
        BankAccount bankAccount = new BankAccount();

        ExecutorService threadPool = Executors.newCachedThreadPool();

        for (int i = 0; i < 100; i++) {
            threadPool.execute(new DepositPennyTask(bankAccount));
        }

        threadPool.shutdown();

        while (!threadPool.isTerminated()) {
            // do nothing, just wait
        }

        System.out.println(bankAccount.getBalance());
    }

    public static void cachedThreadPool() {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        threadPool.execute(new CountdownTask(5));
        threadPool.execute(new CountdownTask(10));
        threadPool.execute(new CountdownTask(15));
        threadPool.shutdown();
    }

    public static void fixedThreadPool() {
        ExecutorService threadPool = Executors.newFixedThreadPool(1);
        threadPool.execute(new CountdownTask(5));
        threadPool.execute(new CountdownTask(10));
        threadPool.execute(new CountdownTask(15));
        threadPool.shutdown();
    }


    public static void joiningThreads() {
        Thread thread1 = new Thread(new CountdownTask(10));
        Thread thread2 = new Thread(new CountdownTask(15));
//        thread2.setPriority(Thread.MAX_PRIORITY);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Oops!");
        }

        System.out.println("Both countdowns are done!");
    }

    public static void interruptTask() {
        Runnable task = new InfiniteTask();
        Thread thread = new Thread(task);
        thread.start();

        JOptionPane.showMessageDialog(null, "Close dialog to stop loading");
        thread.interrupt();
    }

    public static void countdownTask() {
        String secondsText = JOptionPane.showInputDialog("How many seconds to count down?");
        int seconds = Integer.parseInt(secondsText);
        Runnable task = new CountdownTask(seconds);
        Thread thread = new Thread(task);
        thread.start();
    }

    public static void sleepSpammerTask() {
        String spam = JOptionPane.showInputDialog("What would you like to spam?");
        Runnable task = new SpammerTask(spam);
        Thread thread = new Thread(task);
        thread.start();

        String millisText;
        do {
            millisText = JOptionPane.showInputDialog("How many milliseconds to sleep for?");
            long millis = Long.parseLong(millisText);
            try {
                thread.sleep(millis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!spam.equalsIgnoreCase("q"));
    }

    public static void runSpammer() {
        String spam;
        do {
            spam = JOptionPane.showInputDialog("What would you like to spam?");
            new Spammer().spam(spam);
        } while (!spam.equalsIgnoreCase("q"));
    }

    public static void runSpammerTask() {
        String spam;
        do {
            spam = JOptionPane.showInputDialog("What would you like to spam?");
            Runnable task = new SpammerTask(spam);
            Thread thread = new Thread(task);
            thread.start();
        } while (!spam.equalsIgnoreCase("q"));
    }
}
