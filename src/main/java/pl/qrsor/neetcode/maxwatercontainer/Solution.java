package pl.qrsor.neetcode.maxwatercontainer;

class Solution
{
	public int maxArea(int[] heights)
	{
		var leftPointer = 0;
		var rightPointer = heights.length - 1;
		var max = 0;

		while (leftPointer < rightPointer)
		{

			var leftHeight = heights[leftPointer];
			var rightHeight = heights[rightPointer];

			var currentWidth = rightPointer - leftPointer;
			var currentHeight = Math.min(leftHeight, rightHeight);

			var currentAmount = currentHeight * currentWidth;

			if (currentAmount > max)
			{
				max = currentAmount;
			}

			if (leftHeight >= rightHeight)
			{
				rightPointer--;
			}
			else
			{
				leftPointer++;
			}
		}

		return max;
	}
}
