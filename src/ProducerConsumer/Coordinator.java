package ProducerConsumer;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.InterruptedException;

public class Coordinator {
    private static int sharedNumber = 100;

    public static void setSharedNumber(int num) {
        sharedNumber = num;
    }

    public static int getSharedNumber() {
        return sharedNumber;
    }

    private static void writeToFile(int sum) {
        try {
            FileWriter writer = new FileWriter("results2");
            writer.write("Carl Noren\n" + 
                "Computer Operating Systems Assignment #2\n\n" + 
                "The sum is " + sum);
            writer.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void main(String argsv[]) {
        Producer producer = new Producer();
        Consumer consumer = new Consumer();
        producer.start();
        consumer.start();
        try{
            producer.join();
            consumer.join();
        } catch(InterruptedException ie) {
            ie.printStackTrace();
        }
        
        writeToFile(consumer.getSum());
    }
}