package bank;

import java.util.concurrent.Semaphore;

public class SemaphoreBank extends Bank {

    Semaphore semaphore = new Semaphore(1);

    public SemaphoreBank(int n, int initialBalance) {
        super(n, initialBalance);
    }

    @Override
    public void transfer(int from, int to, int amount) {

        try {

            semaphore.acquire();

            accounts[from] -= amount;
            accounts[to] += amount;

            ntransacts++;

            if (ntransacts % NTEST == 0)
                test(ntransacts, accounts);

            semaphore.release();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
