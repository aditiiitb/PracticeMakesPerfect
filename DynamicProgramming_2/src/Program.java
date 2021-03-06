
public class Program {
	public static void main(String[] args)
	{
		System.out.println("szdsf");
		int[] values = {10,20,30,40};
		int[] weights = {1,2,1,3};
		int W = 3;
		System.out.println(CalculateBestKnapSackValue(values, weights, W));
		
	}
	
	private static int CalculateBestKnapSackValue(int[] values, int[] weights, int W)
	{
		if (SumOfArray(weights) <= W)
		{
			return SumOfArray(values);
		}
		else if (W <= 0)
		{
			return 0;
		}
		else 
		{
			// see if including it in the knapsack is better than not
			int knapSackWith0 = values[0] + CalculateBestKnapSackValue(RemoveI(values,0), RemoveI(weights,0), W - weights[0]);
			int knapSackWithOut0 = CalculateBestKnapSackValue(RemoveI(values,0), RemoveI(weights,0), W);
		
			if (weights[0] <= W)
			{
				return (knapSackWith0 > knapSackWithOut0) ? knapSackWith0 : knapSackWithOut0;
			}
			else
				return knapSackWithOut0;
		}
	}
	
	private static int[] RemoveI(int[] nums, int i)
	{
		if (nums.length >= 1)
		{
			int[] copy = new int[nums.length -1];
			int index = 0;
			for (int k = 0; k < nums.length ; k++)
			{
				if (k!= i)
				{
					copy[index] = nums[k];
					index++;
				}			
			}
			return copy;
		}
		else
			return new int[0];
	}
	
	private static int SumOfArray(int[] nums)
	{
		int result = 0;
		for (int i = 0; i < nums.length ; i++)
		{
			result += nums[i];
		}
		return result;
	}
}
