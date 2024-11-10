package pl.qrsor.neetcode.ispalindrome;

class Solution
{
	public boolean isPalindrome(String input)
	{

		var i = 0;
		var j = input.length() - 1;

		while (i < j)
		{
			var leftChar = Character.toLowerCase(input.charAt(i));
			System.out.printf("i: %d; leftChar: %c;\n", i, leftChar);
			if (!Character.isLetterOrDigit(leftChar))
			{
				i++;
				continue;
			}

			var rightChar = Character.toLowerCase(input.charAt(j));
			System.out.printf("i: %d; rightChar: %c;\n", j, rightChar);
			if (!Character.isLetterOrDigit(rightChar))
			{
				j--;
				continue;
			}

			if (leftChar != rightChar)
			{
				System.out.println("Not equal");
				return false;
			}

			i++;
			j--;
		}

		return true;
	}
}
