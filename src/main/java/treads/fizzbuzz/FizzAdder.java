package treads.fizzbuzz;

public class FizzAdder implements Runnable {
    private final Iterator iterator;

    public FizzAdder(Iterator iterator) {
        this.iterator = iterator;
    }

    @Override
    public void run() {
        iterator.fizzIsReady = true;
        while (!Thread.currentThread().isInterrupted()) {
            int currentIndex = iterator.getIndex();
            if (currentIndex % 3 == 0 && currentIndex % 5 != 0) {
                try {
                    iterator.concatElement("fizz");
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }
}
