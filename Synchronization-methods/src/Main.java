import classroom.Group;
import classroom.Journal;
import producerconsumer.Consumer;
import producerconsumer.Drop;
import producerconsumer.Producer;

public class Main {
    public static void main(String[] args) {

        Drop drop = new Drop();
        (new Thread(new Producer(drop))).start();
        (new Thread(new Consumer(drop))).start();
    }
}