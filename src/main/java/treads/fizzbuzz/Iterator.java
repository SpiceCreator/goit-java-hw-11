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

    private String threadsInterrupter() {
        fizz.interrupt();
        buzz.interrupt();
        fizzbuzz.interrupt();
        number.interrupt();

        return stringBuffer.toString().substring(0, stringBuffer.length() - 2); //Это хитрое решение помогает concatElement'у успеть дописать последнее значение
    }

    public String goFizzBuzzFor(int count) throws InterruptedException {
        threadStarter();

        iterate(count);

        Thread.sleep(0, 2); //Я пытался, но без этого никак :-(

        return threadsInterrupter();
    }
}
