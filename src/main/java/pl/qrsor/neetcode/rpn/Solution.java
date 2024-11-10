package pl.qrsor.neetcode.rpn;

import java.util.Stack;


class Solution {

	private final Stack<Integer> internalStack = new Stack<>();

	public int evalRPN(String[] tokens) {

		for (int i = 0; i < tokens.length; i++)
		{
			var token = tokens[i];
			var result = nextToken(token);
			internalStack.push(result);
		}
		
		return internalStack.pop();
	}

	private Integer nextToken(String token)
	{
		return switch (token) {
		case "+" -> add();
		case "-" -> substract();
		case "*" -> multiply();
		case "/" -> divide();
		default -> Integer.parseInt(token);
	};
	}

	private int add() {
		var r = internalStack.pop();
		var l = internalStack.pop();
		return l+r;
	}

	private int substract() {
		var r = internalStack.pop();
		var l = internalStack.pop();
		return l-r;
	}

	private int multiply() {
		var r = internalStack.pop();
		var l = internalStack.pop();
		return l*r;
	}

	private int divide() {
		var r = internalStack.pop();
		var l = internalStack.pop();
		return l/r;
	}
}
