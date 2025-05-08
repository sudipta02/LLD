package producer_consumer_monitor_lock;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {
    private Queue<Integer> sharedBuffer;
    private int bufferSize;

    public SharedResource(int bufferSize) {
        sharedBuffer = new LinkedList<>();
        this.bufferSize = bufferSize;
    }

    public synchronized void produce(int item) throws Exception {
        // If buffer is full, wait for the consumer to consume items from the buffer
        while (sharedBuffer.size() == bufferSize) {
            System.out.println("Buffer is full, producer is waiting for consumer.");
            wait();
        }
        sharedBuffer.add(item);
        System.out.println("produced: " + item);
        // notify the consumer that there are items to consume now
        notify();
    }

    public synchronized int consume() throws Exception {
        // buffer is empty, wait for the producer to produce items
        while (sharedBuffer.isEmpty()) {
            System.out.println("Buffer is empty, consumer is waiting for producer");
            wait();
        }
        int item = sharedBuffer.poll();
        System.out.println("consumed: " + item);
        // notify the producer that there is space in the buffer now
        notify();
        return item;
    }
}
