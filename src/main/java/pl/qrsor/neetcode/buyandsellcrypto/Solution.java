package pl.qrsor.neetcode.buyandsellcrypto;

class Solution
{
	public int maxProfit(int[] prices)
	{
		if (prices.length == 1)
		{
			return 0;
		}

		var maxProfit = 0;
		var buyIndex = 0;
		var buyValue = prices[buyIndex];

		var sellIndex = 1;
		while (sellIndex < prices.length)
		{
			var sellValue = prices[sellIndex];

			if (sellValue < buyValue)
			{
				buyIndex = sellIndex;
				sellIndex = buyIndex + 1;
				buyValue = prices[buyIndex];
			}
			else
			{
				var potentialMax = sellValue - buyValue;
				if (potentialMax > maxProfit)
				{
					maxProfit = potentialMax;
				}
				sellIndex++;
			}


		}

		return maxProfit;
	}
}
