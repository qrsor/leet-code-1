package pl.qrsor.neetcode.longestrepeatingsubstringwithreplacement;

class Solution {
	public int characterReplacement(String s, int k) {
		var leftPointer = 0;
		var rightPointer = 0;
		var maxFrequency = 0;
		var max = 0;
		var letterFrequency = new char[128];

		while (rightPointer < s.length()) {
			var rightChar = s.charAt(rightPointer);

			letterFrequency[rightChar]++;
			maxFrequency = Math.max(maxFrequency, letterFrequency[rightChar]);

			while(!(rightPointer - leftPointer + 1 - maxFrequency <= k)) {
				letterFrequency[s.charAt(leftPointer)]--;
				leftPointer++;
			}

			max = Math.max(max, rightPointer - leftPointer + 1);
			rightPointer++;
		}

		return max;
	}
}
