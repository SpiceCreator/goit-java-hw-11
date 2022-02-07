package treads.test.fizzbuzz;

public class BuzzAdder implements Runnable {
    private final Iterator iterator;

    public BuzzAdder(Iterator iterator) {
        this.iterator = iterator;
    }

    @Override
    public void run() {
        iterator.buzzIsReady = true;
        while (!Thread.currentThread().isInterrupted()) {
            int currentIndex = iterator.getIndex();
            if (currentIndex % 5 == 0 && currentIndex % 3 != 0) {
                try {
                    iterator.concatElement("buzz");
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }
}
