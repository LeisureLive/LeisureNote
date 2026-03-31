package com.leisure.note.java.base.concurrency;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 显式锁
 *
 * @author jie.he
 * @version 1.0.0
 * @since 2026/03/18 17:36
 */
public class Lock {

  public static void main(String[] args) {
    LockSupport.park();
    ReentrantLock lock = new ReentrantLock();
  }
}
