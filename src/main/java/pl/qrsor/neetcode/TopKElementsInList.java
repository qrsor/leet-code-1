package pl.qrsor.neetcode;

import java.util.*;


public class TopKElementsInList
{
	public int[] topKFrequent(int[] nums, int k) {
		var result = new int[k];
		var freqMap = new HashMap<Integer, Integer>();
		var countMap = new HashMap<Integer, List<Integer>>();
		for (int num : nums) {
			freqMap.computeIfAbsent(num, k1 -> 0);
			freqMap.put(num, freqMap.get(num) + 1);
		}
		freqMap.forEach((num, freq) -> {
			countMap.computeIfAbsent(freq, k1 -> new ArrayList<>()).add(num);
		});
		for(int i = nums.length; i >= 0; i--) {
			if(countMap.containsKey(i)) {
				var list = countMap.get(i);
				for (int num : list) {
					if(k == 0) {
						break;
					}
					result[k - 1] = num;
					k--;
				}
			}
		}


		return result;
	}
}
