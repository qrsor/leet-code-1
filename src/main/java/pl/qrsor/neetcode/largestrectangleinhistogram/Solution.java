package pl.qrsor.neetcode.largestrectangleinhistogram;

import java.util.Stack;


class Solution
{

	record Entry(int position, int height)
	{
	}

	public int largestRectangleArea(int[] heights)
	{

		var stack = new Stack<Entry>();
		var maxArea = 0;

		stack.push(new Entry(0, heights[0]));

		for (int i = 1; i < heights.length; i++)
		{
			var currentHeight = heights[i];
			Entry previousTopHeight = null;
			while (!stack.isEmpty() && currentHeight <= stack.peek().height)
			{
				previousTopHeight = stack.pop();
				var previousEntryArea = previousTopHeight.height * (i - previousTopHeight.position);
				if (previousEntryArea > maxArea)
				{
					maxArea = previousEntryArea;
				}
			}

			int startPosition = previousTopHeight != null ? previousTopHeight.position : i;
			stack.push(new Entry(startPosition, heights[i]));
		}

		while (!stack.isEmpty()) {
			var entry = stack.pop();
			var previousEntryArea = entry.height * (heights.length - entry.position);
			if (previousEntryArea > maxArea)
			{
				maxArea = previousEntryArea;
			}
		}

		return maxArea;
	}
}
