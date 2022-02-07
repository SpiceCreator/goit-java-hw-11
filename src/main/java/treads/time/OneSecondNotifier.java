package treads.time;

public class OneSecondNotifier implements Runnable {
    private TimeCounter timeCounter;

    public OneSecondNotifier(TimeCounter timeCounter) {
        this.timeCounter = timeCounter;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            timeCounter.printOneSecondMessage();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
