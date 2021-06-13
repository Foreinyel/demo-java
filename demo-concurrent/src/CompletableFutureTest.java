import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTest {

    public static void main(String[] args) {

        CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("洗茶壶");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        }).thenApply((Integer pre) -> {
            System.out.println("洗茶杯");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return pre + 1;
        });

        CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("洗水壶");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        }).thenApply((Integer pre) -> {
            System.out.println("烧开水");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return pre + 1;
        });

        CompletableFuture<Integer> f3 = f1.thenCombine(f2, (Integer a1, Integer a2) -> {
            System.out.println("泡茶");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return a1 + a2;
        });

        try {
            Integer res = f3.get();
            System.out.println("茶泡好了～" + res);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}
