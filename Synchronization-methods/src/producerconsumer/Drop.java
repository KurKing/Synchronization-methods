package producerconsumer;

import java.util.Optional;

public class Drop {

    private Optional<Double> message;
    private boolean empty = true;

    public synchronized Optional<Double> take() {

        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }

        empty = true;

        notifyAll();
        return message;
    }

    public synchronized void put(Optional<Double> message) {

        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }

        empty = false;
        this.message = message;

        notifyAll();
    }
}
