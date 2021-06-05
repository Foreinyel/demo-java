import java.util.HashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {

    private ReentrantLock bankLock = new ReentrantLock();

    private HashMap<String, Integer> accounts = new HashMap();

    private Condition sufficient = bankLock.newCondition();;

    public Bank() {
        accounts.put("a", 200);
        accounts.put("b", 300);
        accounts.put("c", 240);
    }

    public void transfer(String from, String to, int amount) {
        bankLock.lock();
        try {
            Integer fromBalance = accounts.get(from);
            while (fromBalance < amount) {
                System.out.println("waiting " + from + " " + to);
                sufficient.await();
                fromBalance = accounts.get(from);
            }
            System.out.println("start to transfer: " + from + ", " + to + " " + amount);
            accounts.put(from, fromBalance - amount);
            accounts.put(to, accounts.get(to) + amount);
            sufficient.signalAll();
        } catch (InterruptedException e) {
           e.printStackTrace();
        } finally {
            bankLock.unlock();
        }
    }

    public void print() {
        accounts.keySet().forEach((String acc) -> {
            System.out.println("balance of " + acc + " is " + accounts.get(acc));
        });
    }

}
