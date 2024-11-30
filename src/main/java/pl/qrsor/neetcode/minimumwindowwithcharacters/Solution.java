package pl.qrsor.neetcode.minimumwindowwithcharacters;

import java.util.Arrays;


public class Solution
{
	public String minWindow(String s, String t)
	{
		var tHash = countChars(t);
		var sWindowHash = new int[58];

		var lMin = -1;
		var rMin = s.length();

		var lPointer = 0;
		var rPointer = 0;
		while (rPointer < s.length())
		{
			int rChar = s.charAt(rPointer) - 65;
			if (tHash[rChar] > 0)
			{
				sWindowHash[rChar]++;
			}

			while (contains(tHash, sWindowHash))
			{
				//update result
				if (rMin - lMin > rPointer - lPointer)
				{
					lMin = lPointer;
					rMin = rPointer;
				}
				var lChar = s.charAt(lPointer) - 65;
				if (tHash[lChar] > 0)
				{
					sWindowHash[lChar]--;
				}
				lPointer++;
				System.out.printf("a: lP %d, rP %d\n", lPointer, rPointer);
				toString(tHash);
			}
			rPointer++;
			System.out.printf("b: lP %d, rP %d\n", lPointer, rPointer);
			toString(sWindowHash);
		}

		System.out.printf("lM %d, rM %d\n", lMin, rMin);

		return lMin == -1 ? "" : s.substring(lMin, rMin + 1);
	}

	private boolean contains(int[] tHash, int[] sWindowHash)
	{
		for (int i = 0; i < tHash.length; i++)
		{
			if (sWindowHash[i] < tHash[i])
			{
				return false;
			}
		}

		return true;
	}
	//
	//	public String minWindow(String s, String t)
	//	{
	//		var tHash = countChars(t);
	//		var sWindowHash = new int[58];
	//
	//		var lMin = 0;
	//		var rMin = s.length();
	//		var hasSolution = false;
	//
	//		var lPointer = 0;
	//		var rPointer = 0;
	//		while (rPointer < s.length())
	//		{
	//			if (Arrays.equals(tHash, sWindowHash))
	//			{
	//				hasSolution = true;
	//				//update result
	//				if (rMin - lMin > rPointer - lPointer)
	//				{
	//					lMin = lPointer;
	//					rMin = rPointer;
	//				}
	//				var lChar = s.charAt(lPointer) - 65;
	//				if (tHash[lChar] > 0)
	//				{
	//					sWindowHash[lChar]--;
	//				}
	//				lPointer++;
	//			}
	//			else
	//			{
	//				int rChar = s.charAt(rPointer) - 65;
	//				if (tHash[rChar] > 0)
	//				{
	//					sWindowHash[rChar]++;
	//				}
	//				rPointer++;
	//			}
	//		}
	//
	//		System.out.printf("lM %d, rM %d", lMin, rMin);
	//		System.out.printf("lP %d, rP %d", lPointer, rPointer);
	//
	//		return hasSolution ? s.substring(lMin, rMin) : "";
	//	}

	private int[] countChars(String t)
	{
		var tHash = new int[58];
		for (int i = 0; i < t.length(); i++)
		{
			int c = t.charAt(i) - 65;
			tHash[c]++;
		}
		return tHash;
	}

	private void toString(int[] hash)
	{
		for (int i = 0; i < hash.length; i++)
		{
			if (hash[i] > 0)
			{
				System.out.printf("%c: %d", i + 65, hash[i]);
			}
		}
		System.out.println();
	}
}
