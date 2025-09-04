public class App {
    public static void main(String[] args) throws Exception {
        EvenOdd evenOdd = new EvenOdd();
        Thread evenThread = new Thread(() -> {
            try {
                evenOdd.printEvenNumbers();
            } catch (Exception e) {

            }
        });
        Thread oddThread = new Thread(() -> {
            try {
                evenOdd.printOddNumbers();
            } catch (Exception e) {

            }
        });

        oddThread.start();
        evenThread.start();
    }
}
