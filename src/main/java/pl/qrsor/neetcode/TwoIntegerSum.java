package pl.qrsor.neetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;


public class TwoIntegerSum
{
	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		var diffs = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int currentNumber = nums[i];
			var diff = target - currentNumber;

			if(diffs.containsKey(diff)) {
				result[0] = diffs.get(diff);
				result[1] = i;
				break;
			} else {
				diffs.put(currentNumber, i);
			}
		}
		return result;
	}
}
