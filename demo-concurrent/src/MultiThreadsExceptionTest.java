import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 多线程，其中一个线程抛出异常，会影响到别的线程执行嘛？
 * java里面不会
 * */
public class MultiThreadsExceptionTest {

    public static void main(String[] args) {

        ExecutorService es = Executors.newFixedThreadPool(20);


        for (int i = 0; i < 20; i++) {
            int finalI = i;
            es.submit(() -> {
                try {
                    System.out.println("finalI: " + finalI + " " + 20 / finalI);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            });
        }

        es.shutdown();

    }

}
