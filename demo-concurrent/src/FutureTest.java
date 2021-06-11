import java.util.concurrent.*;

public class FutureTest {

    public static void main(String[] args) {
        ExecutorService executor = new ThreadPoolExecutor(5,
                5,
                1000,
                TimeUnit.MICROSECONDS,
                new LinkedBlockingQueue<Runnable>(5));

        executor.execute(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(4);

        });

        executor.submit(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(99);

        });

        // 使用executor.submit(Runnable)没有返回值
        // executor.submit(Callable)可以使用future.get来获取返回值
        // Callable Runnable的区别：
        // Callable规定的方法是call(),Runnable规定的方法是run()
        // call方法可以抛出异常，run方法不可以
        // Callable的任务执行后可返回值，而Runnable的任务是不能返回值(是void)
        Future<Integer> f1 = executor.submit(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        });

        try {
            Integer res1 = f1.get();
            System.out.println(res1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}
