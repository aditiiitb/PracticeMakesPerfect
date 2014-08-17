
public class Program {
	public static void main(String[] args)
	{
		System.out.println("sdfsd");
		int[] weights = {10,20,30};
		int[] volumes = {1,2,1};
		int MaxVolume = 2; 
		//System.out.println(KnapSack(weights, volumes, weights.length, MaxVolume));
		System.out.println(KnapSackDP(weights, volumes, weights.length, MaxVolume));
	}
	
	private static int KnapSack(int[] weights, int[] volumes, int numItems, int MaxV)
	{
		if (numItems == 0 || MaxV == 0)
			return 0;
		else
		{
			if (volumes[numItems - 1] > MaxV)
				return KnapSack(weights, volumes, numItems -1, MaxV);
			else 
			{
				int nminus1 = KnapSack(weights, volumes, numItems - 1, MaxV - volumes[numItems - 1]);
				int nminus1only = KnapSack(weights, volumes, numItems - 1, MaxV);
				return Math.max(nminus1 + weights[numItems - 1], nminus1only);
			}
		}
	}
	
	private static int KnapSackDP(int[] weights, int[] volumes, int numItems, int MaxV)
	{
		int[][] knapsackvals = new int[numItems+1][MaxV+1];
		
		for (int i = 0 ; i <= numItems; i++)
		{
			for (int v = 0; v <= MaxV; v++)
			{
				if ( v == 0 || i == 0 )
				{
					knapsackvals[i][v] = 0;
				}
				else
				{
					if (volumes[i-1] <= v)
					{
						knapsackvals[i][v] = Math.max(weights[i-1] + knapsackvals[i-1][v-volumes[i-1]],knapsackvals[i-1][v]);
					}
					else
						knapsackvals[i][v] = knapsackvals[i-1][v];
				}
			}
		}
		
		return knapsackvals[numItems][MaxV];
	}
}
