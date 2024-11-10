package pl.qrsor.neetcode.generateparentheses;

import java.util.ArrayList;
import java.util.List;


class Solution
{
	public List<String> generateParenthesis(int n)
	{
		List<String> results = new ArrayList<>();
		StringBuilder buffer = new StringBuilder(n + 1);
		buffer.append('(');
		generateParenthesis(results, 1, 0, n, buffer);
		return results;
	}

	void generateParenthesis(List<String> results, int openCount, int closeCount, int n, StringBuilder buffer)
	{
		if (buffer.length() == 2 * n)
		{
			results.add(buffer.toString());
			return;
		}

		if (openCount > closeCount)
		{
			// add closing bracket
			generateParenthesis(results, openCount, closeCount + 1, n, buffer.append(')'));
			buffer.deleteCharAt(buffer.length() - 1);
		}


		if (openCount < n)
		// add opening
		{
			generateParenthesis(results, openCount + 1, closeCount, n, buffer.append('('));
			buffer.deleteCharAt(buffer.length() - 1);
		}
	}
}
