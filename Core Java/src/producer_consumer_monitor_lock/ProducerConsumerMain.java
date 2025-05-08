package producer_consumer_monitor_lock;

/*
 * Two threads, a producer and a consumer share a common fixed-size buffer as a queue.
 * The producer's job is to genrate data and put into the buffer, while the consumer's job is to
 * consume data from the buffer.
 * The problem is to make sure that the producer won't produce data if the buffer is full and
 * the consumer won't consume data is the buffer is empty.
 */
public class ProducerConsumerMain {
    public static void main(String[] args) {
        SharedResource sharedBuffer = new SharedResource(3);
        // creating producer thread using lambda expression
        Thread producerThread = new Thread(() -> {
            try {
                for (int i = 1; i <= 6; i++) {
                    sharedBuffer.produce(i);
                }
            } catch (Exception e) {

            }
        });

        // creating consumer thread using lambda expression
        Thread consumerThread = new Thread(() -> {
            try {
                for (int i = 1; i <= 6; i++) {
                    sharedBuffer.consume();
                }
            } catch (Exception e) {

            }
        });

        producerThread.start();
        consumerThread.start();
    }
}
