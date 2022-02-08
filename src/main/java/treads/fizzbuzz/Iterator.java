package treads.fizzbuzz;

import java.util.concurrent.atomic.AtomicInteger;

public class Iterator {
    private final AtomicInteger index = new AtomicInteger(1);
    private final StringBuffer stringBuffer = new StringBuffer();

    public Thread fizz = new Thread(new FizzAdder(this));
    public Thread buzz = new Thread(new BuzzAdder(this));
    public Thread fizzbuzz = new Thread(new FizzBuzzAdder(this));
    public Thread number = new Thread(new NumberAdder(this));

    public volatile boolean fizzIsReady;
    public volatile boolean buzzIsReady;
    public volatile boolean fizzbuzzIsReady;
    public volatile boolean numberIsReady;

    public volatile boolean keyWasLocked;
    public volatile boolean keyWasUnlocked;


    public synchronized void concatElement(String element) throws InterruptedException {
        keyWasLocked = true;
        stringBuffer.append(element);
        stringBuffer.append(", ");
        keyWasUnlocked = true;
        wait();
    }

    private synchronized void increaseIndex() {
        index.getAndIncrement();
        notify();
    }

    public int getIndex() {
        return index.get();
    }

    private void threadStarter() {
        number.start();
        fizz.start();
        buzz.start();
        fizzbuzz.start();
    }

    private void iterate(int count) {
        for (int i = 1; i < count; ) {
            if (fizzIsReady && buzzIsReady && fizzbuzzIsReady && numberIsReady) {
                synchronized (this) {
                    if (keyWasLocked && keyWasUnlocked) {
                        increaseIndex();
                        i++;
                        keyWasLocked = false;
                        keyWasUnlocked = false;
                    }
                }
            }
        }
    }

    private void threadsInterrupter() {
        fizz.interrupt();
        buzz.interrupt();
        fizzbuzz.interrupt();
        number.interrupt();
    }

    public String goFizzBuzzFor(int count) {
        threadStarter();

        iterate(count);

        while (true) {
            if (keyWasLocked && keyWasUnlocked) {
                threadsInterrupter();
                break;
            }
        }

        return stringBuffer.toString().substring(0, stringBuffer.length() - 2);
    }
}
