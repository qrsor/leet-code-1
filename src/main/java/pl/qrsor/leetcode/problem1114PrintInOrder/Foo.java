package pl.qrsor.leetcode.problem1114PrintInOrder;

import java.util.concurrent.CountDownLatch;


public class Foo
{
	private final CountDownLatch firstDone = new CountDownLatch(1);
	private final CountDownLatch secondDone = new CountDownLatch(1);

	public Foo()
	{

	}

	public void first(Runnable printFirst) throws InterruptedException
	{
		// printFirst.run() outputs "first". Do not change or remove this line.
		printFirst.run();

		firstDone.countDown();
	}

	public void second(Runnable printSecond) throws InterruptedException
	{
		try
		{
			firstDone.await();
			// printSecond.run() outputs "second". Do not change or remove this line.
			printSecond.run();
			secondDone.countDown();
		}
		catch (InterruptedException e)
		{
			Thread.currentThread().interrupt();
		}

	}

	public void third(Runnable printThird) throws InterruptedException
	{
		try
		{
			secondDone.await();
			// printThird.run() outputs "third". Do not change or remove this line.
			printThird.run();
		}
		catch (InterruptedException e)
		{
			Thread.currentThread().interrupt();
		}

	}
}