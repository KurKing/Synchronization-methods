package bank;

import java.util.Arrays;

public abstract class Bank {

    protected static final int NTEST = 10000;
    protected long ntransacts;
    protected int[] accounts;

    private final int amountOfAccounts;

    public Bank(int n, int initialBalance) {

        ntransacts = n;
        amountOfAccounts = n;

        int[] accounts = new int[n];
        for (int i = 0; i < n; i++) { accounts[i] = initialBalance; }
        this.accounts = accounts;
    }

    public abstract void transfer(int from, int to, int amount);

    protected void test(long ntransacts, int[]accounts) {

        System.out.println("Transactions:" + ntransacts + " Sum: " + Arrays.stream(accounts).sum());
    }

    protected void test(long ntransacts, int summ) {

        System.out.println("Transactions:" + ntransacts + " Sum: " + summ);
    }

    public int size() {
        return amountOfAccounts;
    }
}
