package Lesson3.PingPong;

public class PingPong2 {
    private static boolean isPing;
    private static final Object mon = new Object();

    public static void main(String[] args) {
        new Thread(()->{
            try {
                while (true) {
                    synchronized (mon) {
                        while (!isPing) {
                            mon.wait();
                        }
                        System.out.println("PING");
                        isPing = false;
                        mon.notify();
                        Thread.sleep(800);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                while (true) {
                    synchronized (mon) {
                        while (isPing) {
                            mon.wait();
                        }
                        System.out.println("PONG");
                        isPing = true;
                        mon.notify();
                        Thread.sleep(800);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
