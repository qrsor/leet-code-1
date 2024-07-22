package pl.qrsor.leetcode.problem1115PrintFooBarAlternately;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class FooBar {
	private int n;

	private final Lock lock = new ReentrantLock();
	private final Condition fooTurn = lock.newCondition();
	private final Condition barTurn = lock.newCondition();
	private boolean fooDone = false;

	public FooBar(int n) {
		this.n = n;
	}


	public void foo(Runnable printFoo) throws InterruptedException {

		for (int i = 0; i < n; i++) {
			try {
				lock.lock();
				while (fooDone) {
					fooTurn.await();
				}
				// printFoo.run() outputs "foo". Do not change or remove this line.
				printFoo.run();
				fooDone = true;
				barTurn.signal();
			} finally {
				lock.unlock();
			}
		}
	}

	public void bar(Runnable printBar) throws InterruptedException {

		for (int i = 0; i < n; i++) {
			try {
				lock.lock();
				while (!fooDone) {
					barTurn.await();
				}
				// printBar.run() outputs "bar". Do not change or remove this line.
				printBar.run();
				fooDone = false;
				fooTurn.signal();
			} finally {
				lock.unlock();

			}
		}
	}
}