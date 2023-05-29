package bank;

public class SynchronizedMethodBank extends Bank {

    public SynchronizedMethodBank(int n, int initialBalance) {

        super(n, initialBalance);
    }

    @Override
    synchronized public void transfer(int from, int to, int amount) {

        accounts[from] -= amount;
        accounts[to] += amount;

        ntransacts++;

        if (ntransacts % NTEST == 0)
            test(ntransacts, accounts);
    }
}
