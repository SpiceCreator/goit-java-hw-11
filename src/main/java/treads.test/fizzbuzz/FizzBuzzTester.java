package treads.test.fizzbuzz;

public class FizzBuzzTester {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        System.out.println(new Iterator().goFizzBuzzFor(15));

        long end = System.currentTimeMillis();

        System.out.println((double) (end - start));
    }
}
