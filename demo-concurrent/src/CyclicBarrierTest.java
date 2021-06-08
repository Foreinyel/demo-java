import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CyclicBarrierTest {

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> {
            System.out.println("cyclic barrier callback.");
        });

        Executor executor = Executors.newFixedThreadPool(2);

        executor.execute(() -> {
            int loopCount = 10;

            while (loopCount >= 0) {
                System.out.println("current loopCount of t1 is " + loopCount);
                loopCount--;
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }

        });

        executor.execute(() -> {
            int loopCount = 10;

            while (loopCount >= 0) {
                System.out.println("current loopCount of t2 is " + loopCount);
                loopCount--;
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }

        });
    }
}