import java.util.*;

public class Program {
	public static void main(String[] args)
	{
		int[] A = {1,2,3,4};
		//System.out.println(PowerSet(A,0,3));
		int next = 12345;
		while (true)
		{
			next = GetNextPerm(next);
			System.out.println(next);
		}
	}
	
	private static Integer GetNextPerm(int number)
	{
		Integer result = number;
		
		List<Integer> numArray = GetNumArray(number);
		
		int contentionIndex = GetContentionIndex(numArray);
		
		if ( contentionIndex != -1)
		{
			List<Integer> numsAfterContention = GetSubList(numArray, contentionIndex+1);
			Collections.sort(numsAfterContention);
			
			int key = numArray.get(contentionIndex);
			numArray.set(contentionIndex, numsAfterContention.get(0));
			numsAfterContention.set(0, key);
			
			Collections.sort(numsAfterContention);
			ReplaceSubList(numArray, contentionIndex +1, numsAfterContention);
			result = GetNumberFromList(numArray);
		}
		return result;
	}
	
	private static Integer GetNumberFromList(List<Integer> numArray)
	{
		String res = "";
		for (Integer num : numArray)
		{
			res += num;
		}
		return Integer.parseInt(res);
	}
	private static void ReplaceSubList(List<Integer> arr, int index, List<Integer> replacement)
	{
		if (index < arr.size() && replacement.size() == (arr.size() - index))
		{
			int count = 0;
			for (int i = index; i < arr.size(); i++)
			{
				arr.set(i, replacement.get(count));
				count++;
			}
		}
	}
	private static List<Integer> GetSubList(List<Integer> numArray, int index)
	{
		List<Integer> result  = new ArrayList<Integer>();
		for (int i = index; i <= numArray.size() - 1; i++)
		{
			result.add(numArray.get(i));
		}
		return result;
	}
	private static void Swap(List<Integer> A, int i , int j)
	{
		int temp = A.get(i);
		A.set(i, A.get(j));
		A.set(j, temp);
	}
	private static Integer GetContentionIndex(List<Integer> numArray)
	{
		for (int i = numArray.size() - 1; i > 0; i--)
		{
			if (numArray.get(i-1) < numArray.get(i))
			{
				return i - 1;
			}
		}
		return -1 ;
	}
	private static List<Integer> GetNumArray(int number)
	{

		List<Integer> result = new ArrayList<Integer>();
		String strNum = Integer.toString(number);
		
		for (int i = 0 ; i < strNum.length(); i++)
		{
			result.add(Integer.parseInt(String.valueOf(strNum.charAt(i))));
		}
		return result;
	}
	
	private static Set<Set<Integer>> PowerSet(int[] A, int start, int end)
	{
		if (start > end)
		{
			return null;
		}
		else
		{
			Set<Set<Integer>> resultSet = new HashSet<Set<Integer>>();
			int key = A[start];
			Set<Integer> singleElementSet = new HashSet<Integer>();
			singleElementSet.add(key);
			resultSet.add(singleElementSet);
			
			Set<Set<Integer>> restOfTheSets = PowerSet(A, start+1, end);
			if (restOfTheSets != null)
			{
				for(Set<Integer> withOutKeySet : restOfTheSets)
				{
					resultSet.add(withOutKeySet);
					Set<Integer> keyAddedSet = new HashSet<Integer>();
					for(Integer n : withOutKeySet)
					{
						keyAddedSet.add(n);
					}
					keyAddedSet.add(key);
					resultSet.add(keyAddedSet);
				}
			}
			
			return resultSet;
		}
	}
}

