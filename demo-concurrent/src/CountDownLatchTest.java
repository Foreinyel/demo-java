import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CountDownLatchTest {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("I am t1");
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(3000);
                System.out.println("I am t2");
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("t1 and t2 finished!");

        Executor executor = Executors.newFixedThreadPool(2);

        int loopCount = 10;

        while (loopCount-- >= 0) {
            CountDownLatch countDownLatch1 = new CountDownLatch(2);
            executor.execute(() -> {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch1.countDown();
            });
            executor.execute(() -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch1.countDown();
            });
            try {
                countDownLatch1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("current loopCount is " + loopCount);
        }

    }

}
