package bank;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicArrayBank extends Bank {

    private AtomicIntegerArray atomicAccounts;

    public AtomicArrayBank(int n, int initialBalance) {

        super(n, initialBalance);

        this.atomicAccounts = new AtomicIntegerArray(this.accounts);
    }

    @Override
    public void transfer(int from, int to, int amount) {

        synchronized (accounts) {

            atomicAccounts.getAndAdd(from, -amount);
            atomicAccounts.getAndAdd(to, amount);
        }

        ntransacts++;

        if (ntransacts % NTEST == 0) {

            synchronized (accounts) {

                int summ = 0;
                for (int i = 0; i < size(); i++) {

                    summ += atomicAccounts.get(i);
                }

                test(ntransacts, summ);
            }
        }
    }
}
