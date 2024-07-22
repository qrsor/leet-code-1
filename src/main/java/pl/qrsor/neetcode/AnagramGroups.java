package pl.qrsor.neetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class AnagramGroups
{
	public List<List<String>> groupAnagrams(String[] strs) {
		var result = new HashMap<Integer, List<String>>();

		for (String str : strs)
		{
			var charArr = str.toCharArray();
			Arrays.sort(charArr);
			result.computeIfAbsent(Arrays.hashCode(charArr), k -> new ArrayList<>()).add(str);
		}

		return new ArrayList<>(result.values());

	}
}
