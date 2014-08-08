import java.util.*;


public class Program {
	public static void main(String[] args)
	{
		System.out.println("dfdsfds");
		int[] numbers = {3, 1,2,100,10,11,12,11,14,11};
		//System.out.println(LargestContiguousSubsequence(numbers));
		System.out.println(LargestIncreasingSequence(numbers));
	}	
	
	//given an array, return the longest sequence of increasing numbers
	private static List<Integer> LargestIncreasingSequence(int[] numbers)
	{
		List<Integer> maxSeqSoFar = new ArrayList<Integer>();
		
		List<Integer> seqSoFar = new ArrayList<Integer>();
	
		for(int i = 0 ; i < numbers.length ; i++)
		{
			if (seqSoFar.size() >= 1 && seqSoFar.get(seqSoFar.size() - 1) < numbers[i])
			{
				seqSoFar.add(numbers[i]);			
			}
			else // start a new seq
			{
				seqSoFar = new ArrayList<Integer>();
				seqSoFar.add(numbers[i]);
			}
			if (maxSeqSoFar.size() <= seqSoFar.size())
			{
				maxSeqSoFar = seqSoFar;
			}
		}
			
		return maxSeqSoFar;
	}
	// given an array of negative/postive nums, return the continuous sequence with largest sum 
	private static int LargestContiguousSubsequence(int[] numbers)
	{		
		if (numbers.length == 1)
		{
			return numbers[0];
		}
		else if (numbers.length <= 0)
		{
			return 0;
		}
		else
		{
			int maxSumSoFar = Integer.MIN_VALUE;
			int maxStart = 0; int start = 0; int end = 0; int sumSoFar = numbers[0];
			int maxEnd = 0;
			for (int i = 0; i < numbers.length; i++)
			{
				if (sumSoFar + numbers[i] <= numbers[i])
				{
					start = i;
					sumSoFar = numbers[i];
				}
				else
				{
					end = i;
					sumSoFar += numbers[i];	
				}
				if (maxSumSoFar < sumSoFar)
				{
					maxSumSoFar = sumSoFar;
					maxStart = start;
					maxEnd = end;
				}
			}
			return maxSumSoFar;
		}		
	}
}
