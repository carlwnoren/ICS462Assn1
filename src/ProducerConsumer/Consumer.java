package ProducerConsumer;

import java.lang.Thread;
import java.util.Random;

public class Consumer extends Thread {
    private int sum = 0;

    private void randomPause(Random rand) {
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
        Random rand = new Random();
        for(int i = 0; i < 5; i++) {
            randomPause(rand);
            sum += Coordinator.getSharedNumber();
        }
    }
}