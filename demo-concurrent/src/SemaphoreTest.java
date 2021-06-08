import java.util.Arrays;

public class SemaphoreTest {

    public static void main(String[] args) {

        Restrictor<Integer, String> restrictor = new Restrictor<>(10);

        int size = 2000;

        Thread[] ts = new Thread[size];

        for (int k = 0; k < size; k++) {
            ts[k] = new Thread(() -> {
                restrictor.pass((Integer i) -> String.valueOf(i), Integer.valueOf("123"));
            });
            ts[k].start();
        }

        while (true) {
            System.out.println("=====================================");
            for (int i = 0; i<size; i++) {
                String status = ts[i].getState().name();
                if (Arrays.asList("RUNNABLE", "TIMED_WAITING").contains(status)) {
                    System.out.println(ts[i].getState().name());
                }
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

}
