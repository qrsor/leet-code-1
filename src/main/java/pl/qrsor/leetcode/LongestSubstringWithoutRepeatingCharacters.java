package pl.qrsor.leetcode;

import java.util.HashMap;
import java.util.regex.Pattern;


public class LongestSubstringWithoutRepeatingCharacters
{
	public static int lengthOfLongestSubstring(String s) {
		var charIndex = new HashMap<Character, Integer>();
		var max = 0;
		for(var i = 0; i < s.length(); i++) {
			var current = s.charAt(i);
			if(!charIndex.containsKey(current)) {
				charIndex.put(current, i);
				max = Math.max(charIndex.size(), max);
			} else {
				i = charIndex.get(current);
				max = Math.max(charIndex.size(), max);
				charIndex.clear();
			}
		}
		return max;
	}

	public static void main(String[] args) {
		var input = "*|*|*|";
		Pattern pattern = Pattern.compile("(?=\\|(\\**)\\|)");
		var matcher = pattern.matcher(input);
		while(matcher.find()) {
			System.out.println(matcher.group(1));
		}
	}
}
