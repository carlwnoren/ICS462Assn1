/**
 * @author Carl Noren 
 * 1/27 for Computer Operating Systems Assignment #2
 * This program runs two threads: one a producer and the other a consumer.
 * The producer sets the shared number to its current loop counter (0 to 4) after a 1-3 second pause,
 * and the consumer adds the current value of the shared number to a running sum after a 1-3 second pause.
 * After both threads have finished, this Coordinator then writes the final sum to a text file.
 */
package ProducerConsumer;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.InterruptedException;

public class Coordinator {
    private static int sharedNumber = 100; //Number shared between producer and consumer

    public static void setSharedNumber(int num) {
        sharedNumber = num;
    }

    public static int getSharedNumber() {
        return sharedNumber;
    }

    /*
     * This helper method takes an int, and writes it into a file, along
     * with the required name, class name, and assignment number.
     * @param sum
     */
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
        //Create the threads
        Producer producer = new Producer();
        Consumer consumer = new Consumer();
        producer.start();
        consumer.start();
        try{ //Wait for both threads to complete.
            producer.join();
            consumer.join();
        } catch(InterruptedException ie) {
            ie.printStackTrace();
        }
        
        writeToFile(consumer.getSum());//Write the results to a file.
    }
}