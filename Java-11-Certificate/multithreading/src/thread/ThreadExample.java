package thread;

public class ThreadExample extends Thread {
    @Override
    public synchronized void run() {
        int i = 1;
        while(i <= 100) {
            System.out.println(i + " " + this.getName());
            i++;
        }
    }
}
