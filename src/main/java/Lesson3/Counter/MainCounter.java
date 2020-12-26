package Lesson3.Counter;

public class MainCounter {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            int num = i;
            threads[i] = new Thread(()->{
                System.out.println("Запустился "+num+" поток");
                for (int j = 0; j < 100; j++) {
                    counter.next();
                }
                System.out.println("Отработал "+num+" поток");
            });
            threads[i].start();
        }

        for (int i = 0; i < 10; i++) {
            threads[i].join();
        }
        System.out.println();
        System.out.println(counter.getCount());
    }
}
