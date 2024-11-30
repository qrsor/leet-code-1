package pl.qrsor.neetcode.slidingwindowmaximum;

import java.util.*;
import java.util.stream.Collectors;


public class Solution
{
	record IndexedElement(int value, int index)
	{
	}

	private PriorityQueue<IndexedElement> maxHeap = new PriorityQueue<>(Comparator.comparing(IndexedElement::value).reversed());

	public int[] maxSlidingWindow(int[] nums, int k)
	{
//		return solution1(nums, k);

		demonstrateStep(nums, k);

		return solution2(nums, k);
	}

	public void demonstrateStep(int[] nums, int k) {
		Deque<Integer> deque = new ArrayDeque<>();
		System.out.println("Input array: " + Arrays.toString(nums));
		System.out.println("Window size: " + k);

		// Process first window with detailed steps
		for (int i = 0; i < k; i++) {
			System.out.println("\nProcessing index " + i + " (value: " + nums[i] + ")");

			while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
				int removed = deque.removeLast();
				System.out.println("Removed " + nums[removed] + " as it's smaller than " + nums[i]);
			}

			deque.addLast(i);
			System.out.println("Current deque indices: " + deque);
			System.out.println("Current deque values: " +
					deque.stream()
							.map(idx -> nums[idx])
							.collect(Collectors.toList()));
		}
	}

	private int[] solution1(int[] nums, int k)
	{
		var leftPointer = 0;
		var rightPointer = leftPointer + k - 1;

		var i = 0;
		while (i < rightPointer)
		{
			maxHeap.add(new IndexedElement(nums[i], i));
			i++;
		}

		var result = new int[nums.length - k + 1];

		while (rightPointer < nums.length)
		{
			maxHeap.add(new IndexedElement(nums[rightPointer], rightPointer));

			var maxElement = maxHeap.peek();
			while (maxElement.index < leftPointer || maxElement.index > rightPointer)
			{
				maxHeap.remove();
				maxElement = maxHeap.peek();
			}

			result[leftPointer] = maxElement.value;

			leftPointer++;
			rightPointer++;
		}

		return result;
	}

	public int[] solution2(int[] nums, int windowSize) {
		// Edge cases handling
		if (nums == null || nums.length == 0 || windowSize <= 0) {
			return new int[0];
		}

		int[] result = new int[nums.length - windowSize + 1];
		// Using ArrayDeque for better performance
		Deque<Integer> deque = new ArrayDeque<>();

		// Phase 1: Process first window
		for (int i = 0; i < windowSize; i++) {
			// Remove elements smaller than current element from back
			// This maintains decreasing order in deque
			while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
				deque.removeLast();
			}
			deque.addLast(i);
		}

		// Store max of first window
		result[0] = nums[deque.peekFirst()];

		// Phase 2: Process rest of the elements
		for (int i = windowSize; i < nums.length; i++) {
			// Step 1: Remove indices outside current window
			while (!deque.isEmpty() && deque.peekFirst() <= i - windowSize) {
				deque.removeFirst();
			}

			// Step 2: Remove elements smaller than current element
			while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
				deque.removeLast();
			}

			// Step 3: Add current element
			deque.addLast(i);

			// Step 4: Store current window's maximum
			result[i - windowSize + 1] = nums[deque.peekFirst()];
		}

		return result;
	}
}
