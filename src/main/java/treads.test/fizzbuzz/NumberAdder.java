package treads.test.fizzbuzz;

public class NumberAdder implements Runnable {
    private final Iterator iterator;

    public NumberAdder(Iterator iterator) {
        this.iterator = iterator;
    }

    @Override
    public void run() {
        iterator.numberIsReady = true;
        while (!Thread.currentThread().isInterrupted()) {
            int currentIndex = iterator.getIndex();
            if (currentIndex % 3 != 0 && currentIndex % 5 != 0) {
                try {
                    iterator.concatElement(Integer.toString(iterator.getIndex()));
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }
}
