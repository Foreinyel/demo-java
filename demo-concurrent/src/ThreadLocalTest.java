public class ThreadLocalTest {

    private static ThreadLocal<String> userName = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(() -> {
            setUserContext("Jimmy");
            printUserName();
            printUserNameAgain();
            userName.remove();
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            setUserContext("Lucy");
            printUserName();
            printUserNameAgain();
            userName.remove();
        }).start();
    }

    public static void setUserContext(String name) {
        userName.set(name);
    }

    public static void printUserName() {
        System.out.println(userName.get());
    }

    public static void printUserNameAgain() {
        System.out.println(userName.get());
    }

}
