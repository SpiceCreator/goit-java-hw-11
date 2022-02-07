package treads.test.fizzbuzz;

public class FizzBuzzAdder implements Runnable {
    private final Iterator iterator;

    public FizzBuzzAdder(Iterator iterator) {
        this.iterator = iterator;
    }

    @Override
    public void run() {
        iterator.fizzbuzzIsReady = true;
        while (!Thread.currentThread().isInterrupted()) {
            int currentIndex = iterator.getIndex();
            if (currentIndex % 3 == 0 && currentIndex % 5 == 0) {
                try {
                    iterator.concatElement("fizzbuzz");
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }
}

