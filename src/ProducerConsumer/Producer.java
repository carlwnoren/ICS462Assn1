/**
 * This class implements a Producer object, a sublclass of Thread.
 * After a 1-3 second pause, it will set the shared number value to
 * the current loop counter (0-4).
 */
package ProducerConsumer;

import java.lang.Thread;
import java.util.Random;

public class Producer extends Thread {
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

    public void run() {
        for(int i = 0; i < 5; i++) {
            randomPause();
            Coordinator.setSharedNumber(i);
        }
    }
}