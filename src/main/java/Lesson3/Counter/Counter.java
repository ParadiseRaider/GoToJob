package Lesson3.Counter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private Lock lock;
    private int count;

    public Counter() {
        count = 0;
        lock = new ReentrantLock();
    }

    public void next() {
        lock.lock();
        try {
            count++;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public int getCount() {
        return count;
    }
}
