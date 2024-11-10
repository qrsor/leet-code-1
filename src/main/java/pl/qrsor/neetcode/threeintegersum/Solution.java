package pl.qrsor.neetcode.threeintegersum;

import java.util.*;


class Solution
{
	public List<List<Integer>> threeSum(int[] nums)
	{
		List<List<Integer>> results = new ArrayList<>();

		Arrays.sort(nums);
		var dedupSet = new HashSet<Integer>();

		for (var i = 0; i < nums.length && nums[i] < 1; i++)
		{
			int currentNumber = nums[i];
			if (!dedupSet.contains(currentNumber))
			{
				var partialSolution = twoPointerSolution(nums, i);
				if (!partialSolution.isEmpty())
				{
					partialSolution.forEach(l -> {
						l.add(currentNumber);
						results.add(l);
						dedupSet.add(currentNumber);
					});
				}
			}
		}

		return results;
	}

	private List<List<Integer>> twoPointerSolution(int[] numbers, int leftPointer)
	{
		List<List<Integer>> results = new ArrayList<>();
		Set<Integer> dedupSet = new HashSet<>();

		var target = -1 * numbers[leftPointer];
		leftPointer++;
		var rightPointer = numbers.length - 1;

		while (leftPointer < rightPointer)
		{
			var leftNumber = numbers[leftPointer];
			var rightNumber = numbers[rightPointer];

			var sum = leftNumber + rightNumber;
			if (sum > target)
			{
				//decrease sum
				rightPointer--;
			}
			else if (sum < target)
			{
				//increaseSum
				leftPointer++;
			}
			else
			{
				if(dedupSet.contains(leftNumber)) {
					leftPointer++;
				}
				else
				{
					List<Integer> result = new ArrayList<>(3);
					result.add(leftNumber);
					result.add(rightNumber);
					results.add(result);
					dedupSet.add(leftNumber);
					rightPointer--;
					leftPointer++;
				}
			}
		}

		return results;
	}
}
