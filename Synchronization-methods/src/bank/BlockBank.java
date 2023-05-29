package bank;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockBank extends Bank {

    private final Lock block = new ReentrantLock();

    public BlockBank(int n, int initialBalance) {

        super(n, initialBalance);
    }

    @Override
    public void transfer(int from, int to, int amount) {

        block.lock();

        accounts[from] -= amount;
        accounts[to] += amount;

        ntransacts++;

        if (ntransacts % NTEST == 0)
            test(ntransacts, accounts);

        block.unlock();
    }
}
