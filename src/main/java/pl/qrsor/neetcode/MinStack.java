package pl.qrsor.neetcode;

import java.util.Stack;


class MinStack {

	private record MinStackItem(int value, int min) {}

	private final Stack<MinStackItem> internalStack = new Stack<>();

	public MinStack() {

	}

	public void push(int val) {
		var currentMin = internalStack.empty() ? val :  internalStack.peek().min;
		internalStack.push(new MinStackItem(val, Math.min(currentMin, val)));
	}

	public void pop() {
		internalStack.pop();
	}

	public int top() {
		return internalStack.peek().value;
	}

	public int getMin() {
		var min = internalStack.peek().min;
		return min;
	}
}
