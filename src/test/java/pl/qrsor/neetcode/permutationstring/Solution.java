package pl.qrsor.neetcode.permutationstring;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


class Solution
{
	char[] s1CharCount;

	public boolean checkInclusion(String s1, String s2)
	{
		if (s1.length() > s2.length())
		{
			return false;
		}

		s1CharCount = countChars(s1);

		var leftPointer = 0;
		var rightPointer = 0;
		var matchedQueue = new LinkedList<Character>();

		while (leftPointer < s2.length() && rightPointer < s2.length())
		{
			var currentChar = s2.charAt(rightPointer);
			if (windowIsValid(currentChar))
			{
				// potential start of match found
				rightPointer++;

				s1CharCount[currentChar]--;
				matchedQueue.add(currentChar);

				if (matchedQueue.size() == s1.length())
				{
					// matched same number of characters as s1 length
					return true;
				}
			}
			else
			{
				if (!matchedQueue.isEmpty())
				{
					var removedChar = matchedQueue.removeFirst();
					s1CharCount[removedChar]++;
				}

				leftPointer++;
				rightPointer = Math.max(rightPointer, leftPointer);
			}
		}

		return false;
	}

	private boolean windowIsValid(char currentChar)
	{
		return s1CharCount[currentChar] > 0;
	}

	private char[] countChars(String s1)
	{
		var result = new char[123];
		for (int i = 0; i < s1.length(); i++)
		{
			var currentChar = s1.charAt(i);
			result[currentChar]++;
		}
		return result;
	}
}
