public class BankTest {

    public static void main(String[] args) {
        Bank bank = new Bank();

        // a => b, 300, a 余额不足，会触发条件对象的await
        Thread a = new Thread(() -> bank.transfer("a", "b", 300));
        a.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // c => a, 100, a条件充足，会通知a可以继续转账
        Thread b = new Thread(() -> bank.transfer("c", "a", 100));
        b.start();

        try {
            a.join();
            b.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        bank.print();

    }

}
