package com.java.exercises;

public class RunnableClass implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (SynchronizedLocks.counterLock) {
                SynchronizedLocks.counter++;
            }
        }

    }
}
