package bank;

public class SynchronizedBlockBank extends Bank {

    public SynchronizedBlockBank(int n, int initialBalance) {
        super(n, initialBalance);
    }

    @Override
    public void transfer(int from, int to, int amount) {

        synchronized (accounts) {

            accounts[from] -= amount;
            accounts[to] += amount;
        }

        ntransacts++;

        if (ntransacts % NTEST == 0) {

            final long ntransactsFinal = ntransacts;
            synchronized (accounts) {

                test(ntransactsFinal, accounts);
            }
        }
    }
}
