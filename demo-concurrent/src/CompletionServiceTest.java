import java.util.concurrent.*;

public class CompletionServiceTest {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        CompletionService<Integer> cs = new ExecutorCompletionService<>(executor);

        cs.submit(() -> {
            Thread.sleep(1000);
            return 100;
        });

        cs.submit(() -> {
            Thread.sleep(2000);
            return 200;
        });

        cs.submit(() -> {
            Thread.sleep(3000);
            return 300;
        });

        for (int i =0 ;i < 3; i++) {
            try {
                Integer r = cs.take().get();
                System.out.println(r);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
    }
}
