package pl.qrsor.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class LongestSubstringWithoutRepeatingCharactersTest
{

	@Test
	void lengthOfLongestSubstring1()
	{
		//given
		var input = "abcabcbb";

		//when
		var result = LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(input);

		//then
		assertEquals(3, result);
	}

	@Test
	void lengthOfLongestSubstring2()
	{
		//given
		var input = "bbbbb";

		//when
		var result = LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(input);

		//then
		assertEquals(1, result);
	}

	@Test
	void lengthOfLongestSubstring3()
	{
		//given
		var input = "pwwkew";

		//when
		var result = LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(input);

		//then
		assertEquals(3, result);
	}

	@Test
	void lengthOfLongestSubstring4()
	{
		//given
		var input = " ";

		//when
		var result = LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(input);

		//then
		assertEquals(1, result);
	}
}