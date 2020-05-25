package other;

public class SynchronizeDemo03 {

    public static void main(String[] args) {
        Account account = new Account("shihongjie", 1000);
        AccountOperator02 accountOperator = new AccountOperator02(account);

        final int THREAD_NUM = 5;
        Thread threads[] = new Thread[THREAD_NUM];
        for (int i = 0; i < THREAD_NUM; i++) {
            threads[i] = new Thread(accountOperator, "Thread" + i);
            threads[i].start();
        }
    }

}
