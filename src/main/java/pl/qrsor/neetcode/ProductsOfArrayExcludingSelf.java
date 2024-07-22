package pl.qrsor.neetcode;

public class ProductsOfArrayExcludingSelf
{
	public int[] productExceptSelf(int[] nums) {
		var result = new int[nums.length];

		// prefix pass
		for (int i = 0, prefix = 1; i < nums.length; i++) {
			result[i] = prefix;
			prefix *= nums[i];
		}

		// suffix pass
		for (int i = nums.length - 1, suffix = 1; i >= 0; i--) {
			result[i] *= suffix;
			suffix *= nums[i];
		}


		return result;
	}
}
