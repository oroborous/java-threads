package edu.wctc;

public class CountdownTask implements Runnable {
    private int secondsRemaining;

    public CountdownTask(int secondsRemaining) {
        this.secondsRemaining = secondsRemaining;
    }


    @Override
    public void run() {
        while (secondsRemaining > 0) {
            System.out.println(secondsRemaining--);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
