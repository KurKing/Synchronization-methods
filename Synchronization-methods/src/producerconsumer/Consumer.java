package producerconsumer;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

public class Consumer implements Runnable {

    private Drop drop;
    private final ArrayList<Double> data = new ArrayList<>();

    private int counter = 0;

    public Consumer(Drop drop) {

        this.drop = drop;
    }

    public void run() {

        Random random = new Random();

        for (Optional<Double> message = drop.take(); !message.isEmpty(); message = drop.take()) {

            System.out.println("MESSAGE #" + counter + " RECEIVED: " + message.get());
            counter += 1;

            try {
                Thread.sleep(random.nextInt(200));
            } catch (InterruptedException e) {}
        }
    }
}
