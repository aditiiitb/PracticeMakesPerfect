
public class Sort {

	public static void MergeSort(int[] numbers)
	{
		MergeSortHelper(numbers, 0, numbers.length - 1);
	}
	
	private static void MergeSortHelper(int[] numbers, int start, int end)
	{
		if (start >= end)
			return;
		else
		{
			int midPointIndex = (start+end)/2;
			int[] L = new int[midPointIndex - start + 1 + 1];
			int[] R = new int[end - midPointIndex + 1 + 1];
			int index = 0;
			for (int i = start ; i <= (start+end)/2 ; i++ )
			{
				L[index] = numbers[i];
				index++;
			}
			index = 0;
			for (int i = (start+end)/2 + 1; i <= end ; i++ )
			{
				R[index] = numbers[i];
				index++;
			}
			L[L.length -1 ] = Integer.MAX_VALUE;
			R[R.length - 1] = Integer.MAX_VALUE;
		}
	}
}
