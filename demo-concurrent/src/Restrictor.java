import java.util.concurrent.Semaphore;
import java.util.function.Function;

public class Restrictor<T, R> {

    private Semaphore semaphore;

    public Restrictor(int count) {
        semaphore = new Semaphore(count);
    }

    public R pass(Function<T, R> func, T t) {
        try {
            semaphore.acquire();
            Thread.sleep(500);
            return func.apply(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return null;
    }

}
