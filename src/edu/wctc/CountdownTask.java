package edu.wctc;

public class CountdownTask implements Runnable {
    private int secondsRemaining;

    // Give each task an ID so we can tell them apart
    private int taskId;
    private static int nextTaskId = 1;

    public CountdownTask(int secondsRemaining) {
        this.secondsRemaining = secondsRemaining;
        this.taskId = nextTaskId++;
    }


    @Override
    public void run() {
        while (secondsRemaining > 0) {
            System.out.printf("Task #%d: %d %n", taskId, secondsRemaining--);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
