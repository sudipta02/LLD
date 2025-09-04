public class EvenOdd {
    private int count = 10;

    public synchronized void printEvenNumbers() throws Exception {
        for (int i = 1; i <= count; i++) {
            if (i % 2 == 0) {
                notify();
                System.out.println("even: " + i);
                wait();
            }
        }
    }

    public synchronized void printOddNumbers() throws Exception {
        for (int i = 1; i <= count; i++) {
            if (i % 2 != 0) {
                notify();
                System.out.println("odd: " + i);
                wait();
            }
        }
    }
}
