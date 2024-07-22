package pl.qrsor.neetcode;

import java.util.Stack;


public class ValidParentheses
{
	public boolean isValid(String s) {

		var charStack = new Stack<Character>();
		for (char c : s.toCharArray())
		{
			if(isOpening(c)) {
				charStack.push(c);
			} else {
				if(charStack.isEmpty()) return false;

				var openingChar = charStack.pop();
				if (!matchesClosing(openingChar, c))
				{
					return false;
				}
			}
		}

		return charStack.isEmpty();
	}

	private boolean matchesClosing(Character openingChar, Character c)
	{
		return switch (openingChar)
		{
			case '(' -> c == ')';
			case '[' -> c == ']';
			default -> c == '}';
		};
	}

	private boolean isOpening(Character c)
	{
		return c=='(' || c=='[' || c=='{';
	}
}
