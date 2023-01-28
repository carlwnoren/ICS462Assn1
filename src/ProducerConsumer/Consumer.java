/**
 * This class implements a Consumer object, a subclass of Thread.
 * It loops five times, and each time, it pauses for 1-3 seconds before
 * adding the current value of the shared 
 */
package ProducerConsumer;

import java.lang.Thread;
import java.util.Random;

public class Consumer extends Thread {
    private int sum = 0;
    Random rand = new Random();

    /*
     * This helper method pauses the thread for 1-3 seconds.
     */
    private void randomPause() {
        try {
            Thread.sleep((rand.nextInt(3) + 1) * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getSum() {
        return sum;
    }

    public void run() {
        for(int i = 0; i < 5; i++) {
            randomPause();
            sum += Coordinator.getSharedNumber();
        }
    }
}