package com.example.demo.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁实现
  */
public class SpinLockDemo {

    AtomicReference<Thread> reference = new AtomicReference<Thread>();

    // 加锁
    public void lock() {

        Thread thread = Thread.currentThread();
        while (!reference.compareAndSet(null, thread)) {

        }
    }

    // 解锁
    public void unLock () {
        Thread thread = Thread.currentThread();
        reference.compareAndSet(thread,null);
    }

}
