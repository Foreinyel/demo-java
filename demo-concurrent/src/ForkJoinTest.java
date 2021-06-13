import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * 求斐波那契第30个数字
 * */
public class ForkJoinTest {

    static class Fibonacci extends RecursiveTask<Integer> {

        private final int n;
        private ConcurrentHashMap<Integer, Integer> cache;

        public Fibonacci(int n, ConcurrentHashMap<Integer, Integer> cache) {
            this.n = n;
            this.cache = cache;
        }

        @Override
        protected Integer compute() {
            System.out.println("computing: " + this.n);
            if (this.n <= 1) {
                return this.n;
            }

            Integer cachedValue = this.cache.get(this.n);

            if (cachedValue != null) {
                return cachedValue;
            }

            Fibonacci f1 = new Fibonacci(this.n - 1, this.cache);
            f1.fork();

            Fibonacci f2 = new Fibonacci(this.n - 2, this.cache);

            Integer value = f2.compute() + f1.join();

            this.cache.put(this.n, value);

            return value;
        }
    }

    public static void main(String[] args) {

        ConcurrentHashMap<Integer, Integer> cache = new ConcurrentHashMap<>();

        ForkJoinPool pool = new ForkJoinPool(4);
        Fibonacci f = new Fibonacci(30, cache);
        Integer res = pool.invoke(f);

        System.out.println(res);

    }

}
