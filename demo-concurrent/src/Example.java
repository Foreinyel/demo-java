public class Example {
    int x = 0;
    boolean v = false;
//    volatile boolean v = false;

    public Example(int i) {
        this.x = i;
    }

    public void write() {
//        x = 52;
        v = true;
    }

    public void read() {
        if (v == true) {
            System.out.println("current x: " + x);
        }
    }
}
