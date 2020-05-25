package other;

public class AccountOperator02 implements Runnable {
    private Account account;
    private byte[] lock = new byte[0]; // 特殊的instance变量

    public AccountOperator02(Account account) {
        this.account = account;
    }



    @Override
    public void run() {
        synchronized (lock) {
            account.deposit(500);
            account.withdraw(300);
            System.out.println(Thread.currentThread().getName() + ":" + account.getBalance());
        }

    }
}
