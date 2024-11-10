package pl.qrsor.neetcode.permutationstring;

class Solution
{
	public boolean checkInclusion(String s1, String s2)
	{
		if (s1.length() > s2.length())
		{
			return false;
		}

		var s1CharCount = countChars(s1);

		return true;
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
