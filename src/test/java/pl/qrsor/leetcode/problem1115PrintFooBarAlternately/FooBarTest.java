package pl.qrsor.leetcode.problem1115PrintFooBarAlternately;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class FooBarTest
{
	@Test
	void test1() throws InterruptedException
	{
		//given
		var n = 5;
		var fooBar = new FooBar(n);
		var result = new StringBuilder();
		var expected = "foobarfoobarfoobarfoobarfoobar";

		//when
		var fooThread = new Thread(() ->
		{
			try
			{
				fooBar.foo(() -> result.append("foo"));
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		});

		var barThread = new Thread(() ->
		{
			try
			{
				fooBar.bar(() -> result.append("bar"));
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		});

		fooThread.start();
		barThread.start();

		fooThread.join();
		barThread.join();

		//then
		assertEquals(expected, result.toString());
	}
}