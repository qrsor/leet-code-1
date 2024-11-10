package pl.qrsor.neetcode.longestsubstringwithoutduplicates;

import java.util.Arrays;
import java.util.HashSet;


class Solution
{
	public int lengthOfLongestSubstring(String s)
	{
		if (s.isEmpty())
		{
			return 0;
		}

		var characterCache = new HashSet<Character>();

		var leftIndex = 0;
		var max = 1;
		characterCache.add(s.charAt(leftIndex));

		var rightIndex = 1;
		while (rightIndex < s.length())
		{
			var currentChar = s.charAt(rightIndex);
			System.out.printf("lI: %d; rI: %d; cC: %s; cache: %s\n", leftIndex, rightIndex, currentChar, characterCache);
			if (characterCache.contains(currentChar))
			{
				characterCache.remove(s.charAt(leftIndex));
				leftIndex++;
			}
			else
			{
				characterCache.add(currentChar);
				rightIndex++;
			}
			max = Math.max(max, rightIndex - leftIndex);
		}

		return max;
	}
}
