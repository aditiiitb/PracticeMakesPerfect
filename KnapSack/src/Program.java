
public class Program {
	public static void main(String[] args)
	{
		System.out.println("sdfsd");
		int[] weights = {10,20,30};
		int[] volumes = {1,2,1};
		int MaxVolume = 2; 
		int[] heights = {2,3,2,4};
		//System.out.println(KnapSack(weights, volumes, weights.length, MaxVolume));
		//System.out.println(KnapSackDP(weights, volumes, weights.length, MaxVolume));
		Area done = Histogram(heights, heights.length);
		System.out.println(done.startX + " " + done.endX + " " + done.height + " " + done.getArea());
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
	
	private static Area Histogram(int[] heights, int numItems)
	{
		if (numItems == 0)
			return new Area(0,0,0);
		else
		{
			Area nminus1 = Histogram(heights, numItems - 1);
			if (nminus1.endX == numItems - 1)
			{
				Area withN = new Area(0,0,0);
				withN.startX = nminus1.startX;
				withN.endX = nminus1.endX + 1;
				if (nminus1.height == 0)
					withN.height = heights[numItems -1];
				else
				{
					withN.height = Math.min(nminus1.height, heights[numItems -1]);
				}
				if (withN.getArea() > nminus1.getArea())
					return withN;
				else return nminus1;
			}
			else
			{
				// compare nminus1 with only n
				Area onlyN = new Area(numItems - 1, numItems, heights[numItems - 1]);
				if (onlyN.getArea() > nminus1.getArea())
					return onlyN;
				else
					return nminus1;
			}
		}
	}
}
