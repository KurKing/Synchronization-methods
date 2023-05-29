package producerconsumer;

import java.util.Optional;
import java.util.Random;

public class Producer implements Runnable {

    private Drop drop;
    private int arraySize = 100;

    public Producer(Drop drop) {
        this.drop = drop;
    }

    public void run() {

        Random random = new Random();

        double[] messages = instantiateArray(arraySize);

        for (int i = 0; i < arraySize; i++) {

            drop.put(Optional.of(messages[i]));

            try {
                Thread.sleep(random.nextInt(200));
            } catch (InterruptedException e) {}
        }

        drop.put(Optional.empty());
    }

    private double[] instantiateArray(int size) {

        Random random = new Random();
        double[] result = new double[size];

        for (int i = 0; i < size; i++) {

            result[i] = random.nextDouble()*10;
        }

        return result;
    }
}
