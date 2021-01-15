package edu.wctc;

public class SpammerTask implements Runnable {
    private String text;

    public SpammerTask(String text) {
        this.text = text;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        System.out.println("Start spamming!");
        for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {
            for (int j = Integer.MIN_VALUE; j < Integer.MAX_VALUE; j++) {
                System.out.println(text);
            }
        }
        System.out.println("End spamming!");
        long end = System.currentTimeMillis();
        System.out.println(String.format("I spammed %s for %d seconds", text, (end - start / 1000)));
    }
}
