package thread;

public class Multithreading {

    public static void main(String[] args) {
        ThreadExample thread1 = new ThreadExample();
        thread1.setName("First thread");
        thread1.start();
        ThreadExample thread2 = new ThreadExample();
        thread2.setName("Second thread");
        thread2.start();
    }
}
