public class VolatileTest {

    public static void main(String[] args) {
        Example example1 = new Example(1);
        Runnable r1 = () -> {
            example1.write();
            example1.read();
        };
        Runnable r2 = () -> {
//            example1.read();
        };
        new Thread(r1).start();
        new Thread(r2).start();

        Example example2 = new Example(2);
        Runnable r3 = () -> {
            example2.write();
        };
        Runnable r4 = () -> {
            example2.read();
        };
        new Thread(r3).start();
        new Thread(r4).start();

        Example example3 = new Example(3);
        Runnable r5 = () -> {
            example3.write();
        };
        Runnable r6 = () -> {
            example3.read();
        };
        new Thread(r5).start();
        new Thread(r6).start();

        Example example4 = new Example(4);
        Runnable r7 = () -> {
            example4.write();
        };
        Runnable r8 = () -> {
            example4.read();
        };
        new Thread(r7).start();
        new Thread(r8).start();

        Example example5 = new Example(5);
        Runnable r9 = () -> {
            example5.write();
        };
        Runnable r10 = () -> {
            example5.read();
        };
        new Thread(r9).start();
        new Thread(r10).start();

        Example example6 = new Example(6);
        Runnable r11 = () -> {
            example6.write();
        };
        Runnable r12 = () -> {
            example6.read();
        };
        new Thread(r11).start();
        new Thread(r12).start();

        Example example7 = new Example(7);
        Runnable r13 = () -> {
            example7.write();
        };
        Runnable r14 = () -> {
            example7.read();
        };
        new Thread(r13).start();
        new Thread(r14).start();

        Example example8 = new Example(8);
        Runnable r15 = () -> {
            example8.write();
        };
        Runnable r16 = () -> {
            example8.read();
        };
        new Thread(r15).start();
        new Thread(r16).start();

        Example example9 = new Example(9);
        Runnable r17 = () -> {
            example9.write();
        };
        Runnable r18 = () -> {
            example9.read();
        };
        new Thread(r17).start();
        new Thread(r18).start();

        Example example10 = new Example(10);
        Runnable r19 = () -> {
            example10.write();
        };
        Runnable r20 = () -> {
            example10.read();
        };
        new Thread(r19).start();
        new Thread(r20).start();

        Example example11 = new Example(11);
        Runnable r21 = () -> {
            example11.write();
        };
        Runnable r22 = () -> {
            example11.read();
        };
        new Thread(r21).start();
        new Thread(r22).start();

        Example example12 = new Example(12);
        Runnable r23 = () -> {
            example12.write();
        };
        Runnable r24 = () -> {
            example12.read();
        };
        new Thread(r23).start();
        new Thread(r24).start();

        Example example13 = new Example(13);
        Runnable r25 = () -> {
            example13.write();
        };
        Runnable r26 = () -> {
            example13.read();
        };
        new Thread(r25).start();
        new Thread(r26).start();

        Example example14 = new Example(14);
        Runnable r27 = () -> {
            example14.write();
        };
        Runnable r28 = () -> {
            example14.read();
        };
        new Thread(r27).start();
        new Thread(r28).start();

        Example example15 = new Example(15);
        Runnable r29 = () -> {
            example15.write();
        };
        Runnable r30 = () -> {
            example15.read();
        };
        new Thread(r29).start();
        new Thread(r30).start();

        Example example16 = new Example(16);
        Runnable r31 = () -> {
            example16.write();
        };
        Runnable r32 = () -> {
            example16.read();
        };
        new Thread(r31).start();
        new Thread(r32).start();

    }

}
