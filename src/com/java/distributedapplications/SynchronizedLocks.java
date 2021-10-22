package com.java.exercises;

import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedLocks {
    public static int counter = 0;
    public static Object counterLock = new Object();

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        Thread firstThread = new Thread(new RunnableClass());
        Thread secondThread = new Thread(new RunnableClass());
        reentrantLock.lock();
        try {
            firstThread.start();
            secondThread.start();
            Thread.sleep(1000);
            System.out.println("Value of field: " + counter);
        } finally {
            reentrantLock.unlock();
        }
    }
}


