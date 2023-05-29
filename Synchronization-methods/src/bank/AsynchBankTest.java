package bank;

public class AsynchBankTest {

    private static final int NACCOUNTS = 10;
    private static final int INITIAL_BALANCE = 10000;

    public static void main(String[] args) {

//        Bank b = new AtomicArrayBank(NACCOUNTS, INITIAL_BALANCE);
//        Bank b = new SynchronizedMethodBank(NACCOUNTS, INITIAL_BALANCE);
//        Bank b = new SynchronizedBlockBank(NACCOUNTS, INITIAL_BALANCE);
//        Bank b = new BlockBank(NACCOUNTS, INITIAL_BALANCE);
        Bank b = new SemaphoreBank(NACCOUNTS, INITIAL_BALANCE);

        for (int i = 0; i < NACCOUNTS; i++) {

            TransferThread t = new TransferThread(b, i, INITIAL_BALANCE);

            t.setPriority(Thread.NORM_PRIORITY + i % 2);
            t.start();
        }
    }
}
