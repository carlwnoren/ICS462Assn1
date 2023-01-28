package ProducerConsumer;

import java.lang.Thread;
import java.util.Random;

public class Producer extends Thread {
    Random rand = new Random();
    public void run() {
        for(int i = 0; i < 5; i++) {
            try {
                Thread.sleep((rand.nextInt(3) + 1) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Coordinator.setSharedNumber(i);
        }
    }
}