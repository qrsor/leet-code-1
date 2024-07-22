package pl.qrsor.leetcode;

import java.util.*;

public class MedianMaximizer {
	public static int maximizeMedianSum(int[] arr, int x) {
		if (x > arr.length) {
			return -1; // Not enough elements to form x sets
		}

		// Sort the array in descending order
		Integer[] boxedArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
		Arrays.sort(boxedArr, Collections.reverseOrder());

		// Initialize x sets with the x largest elements
		List<List<Integer>> sets = new ArrayList<>();
		for (int i = 0; i < x; i++) {
			sets.add(new ArrayList<>(Collections.singletonList(boxedArr[i])));
		}

		// Distribute the remaining elements
		for (int i = x; i < boxedArr.length; i++) {
			// Find the set with the smallest median
			List<Integer> minMedianSet = Collections.min(sets, Comparator.comparingInt(List::getFirst));
			System.out.println("mms"+minMedianSet);

			if (boxedArr[i] > minMedianSet.getFirst()) {
				// If the current element is larger than the smallest median,
				// replace the smallest median
				minMedianSet.set(0, boxedArr[i]);
			} else {
				// Otherwise, add it to the set with the fewest elements
				List<Integer> minSet = Collections.min(sets, Comparator.comparingInt(List::size));
				minSet.add(boxedArr[i]);
			}
		}

		System.out.println("sets"+sets);

		// Calculate the sum of medians
		int medianSum = 0;
		for (List<Integer> set : sets) {
			Integer median = set.get(set.size() / 2);
			System.out.println("median"+median);
			medianSum += median;
		}

		Scanner sc = new Scanner(System.in);

		return medianSum;
	}

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int x = 3;
		int result = maximizeMedianSum(arr, x);
		System.out.println("Maximum sum of medians: " + result);
	}
}
