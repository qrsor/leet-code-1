package pl.qrsor.neetcode.twointegersumII;

class Solution
{
	public int[] twoSum(int[] numbers, int target)
	{
		return twoPointerSolution(numbers, target);
//		return naiveSolution(numbers, target);
	}

	private int[] twoPointerSolution(int[] numbers, int target)
	{
		var leftPointer = 0;
		var rightPointer = numbers.length-1;

		while (true) {
			var leftNumber = numbers[leftPointer];
			var rightNumber = numbers[rightPointer];

			var sum = leftNumber + rightNumber;
			if(sum > target) {
				//decrease sum
				rightPointer--;
			} else if(sum < target) {
				//increaseSum
				leftPointer++;
			} else {
				return new int[] { leftPointer + 1, rightPointer + 1 };
			}
		}
	}

	private int[] naiveSolution(int[] numbers, int target)
	{
		var i = 0;
		var j = 1;

		while (i < numbers.length)
		{
			var searchedNumber = target - numbers[i];

			var currentNumber = Integer.MIN_VALUE;

			do
			{
				currentNumber = numbers[j];
				if (currentNumber == searchedNumber)
				{
					return new int[] { i + 1, j + 1 };
				}

				j++;
			} while (currentNumber < searchedNumber && j < numbers.length);

			i++;
			j = i + 1;
		}

		return new int[] {};
	}
}
