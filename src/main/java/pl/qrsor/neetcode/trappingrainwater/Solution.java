package pl.qrsor.neetcode.trappingrainwater;

class Solution
{
	public int trap(int[] height)
	{

		var leftPointer = 0;
		var rightPointer = height.length - 1;
		var result = 0;
		var maxClosedHeight = 0;
		var movedLeft = true;

		while (leftPointer <= rightPointer)
		{
			var leftHeight = height[leftPointer];
			var rightHeight = height[rightPointer];

			maxClosedHeight = Math.max(maxClosedHeight, Math.min(leftHeight, rightHeight));

			result += Math.max(maxClosedHeight - (movedLeft ? leftHeight : rightHeight), 0);

//			System.out.printf(
//					"leftPointer: %d; rightPointer: %d; leftHeight: %d; rightHeight: %d; maxClosedHeight: %d; result: %d;\n",
//					leftPointer, rightPointer, leftHeight, rightHeight, maxClosedHeight, result);

			if (leftHeight <= rightHeight)
			{
				leftPointer++;
				movedLeft = true;
			}
			else
			{
				rightPointer--;
				movedLeft = false;
			}
		}

		return result;
	}
}
