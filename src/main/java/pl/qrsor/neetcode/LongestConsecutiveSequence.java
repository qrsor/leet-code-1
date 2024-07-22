package pl.qrsor.neetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


public class LongestConsecutiveSequence
{
	public int longestConsecutive(int[] nums)
	{
		var numbers = Arrays.stream(nums).boxed().collect(Collectors.toSet());
		var maxSequenceLength = 0;

		for (int currentNumber : nums)
		{
			var previousNumber = currentNumber - 1;
			if (!numbers.contains(previousNumber)) // is sequence start
			{
				var sequenceLength = 0;

				var nextNumber = currentNumber + 1;
				while (numbers.contains(nextNumber))
				{
					sequenceLength++;
					nextNumber++;
				}

				if (maxSequenceLength < sequenceLength)
				{
					maxSequenceLength = sequenceLength;
				}
			}
		}

		return maxSequenceLength;
	}
}
