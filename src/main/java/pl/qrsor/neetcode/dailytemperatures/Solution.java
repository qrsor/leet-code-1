package pl.qrsor.neetcode.dailytemperatures;

import java.util.ArrayList;
import java.util.Stack;


class Solution
{
	record Entry(int position, int value)
	{
	}

	public int[] dailyTemperatures(int[] temperatures)
	{

		var stack = new Stack<Entry>();
		var result = new int[temperatures.length];

		stack.add(new Entry(0, temperatures[0]));

		for (int i = 1; i <= temperatures.length - 1; i++)
		{
			var currentElement = temperatures[i];
			if (currentElement > stack.peek().value)
			{
				Entry lastPopped = null;
				while (!stack.isEmpty() && currentElement > stack.peek().value)
				{
					lastPopped = stack.pop();

					var dayCount = i - lastPopped.position;
					result[lastPopped.position] = dayCount;
				}
			}

			stack.push(new Entry(i, currentElement));
		}

		return result;
	}
}
