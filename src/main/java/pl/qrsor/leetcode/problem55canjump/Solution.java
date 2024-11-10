package pl.qrsor.leetcode.problem55canjump;

class Solution
{
	public boolean canJump(int[] nums)
	{
		var targetJumpIndex = nums.length - 1;
		var currentElementIndex = nums.length - 1;
		while (currentElementIndex >= 0)
		{
			// check if target is reachable
			var currentElementValue = nums[currentElementIndex];
			var isReachable = targetJumpIndex <= currentElementIndex + currentElementValue;
			if (isReachable)
			{
				targetJumpIndex = currentElementIndex;
			}
			currentElementIndex--;
		}

		return targetJumpIndex == 0;
	}
}