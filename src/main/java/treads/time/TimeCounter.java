package treads.time;

public class TimeCounter {
    private int secondsElapsed;
    private final Thread fiveSecondsThread = new Thread(new FiveSecondsNotifier(this));
    private final Thread oneSecondThread = new Thread(new OneSecondNotifier(this));

    public void startCounting() throws InterruptedException {

        oneSecondThread.start();

        Thread.sleep(20000);

        oneSecondThread.interrupt();
        fiveSecondsThread.interrupt();
    }

    public synchronized void printFivesSecondsMessage() throws InterruptedException {
        System.out.println("Five second elapsed");
        wait();
    }

    public synchronized void printOneSecondMessage() {
        ++secondsElapsed;
        System.out.println("Seconds elapsed from start: " + secondsElapsed);
        if (secondsElapsed % 5 == 0) {
            if (!fiveSecondsThread.isAlive()) {
                fiveSecondsThread.start();
            } else {
                notify();
            }
        }
    }
}
