package treads.time;

public class FiveSecondsNotifier implements Runnable {
    private TimeCounter timeCounter;

    public FiveSecondsNotifier(TimeCounter timeCounter) {
        this.timeCounter = timeCounter;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                timeCounter.printFivesSecondsMessage();
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
