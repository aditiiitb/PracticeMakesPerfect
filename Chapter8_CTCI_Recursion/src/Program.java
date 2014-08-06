
import java.util.*;

public class Program {
	public static void main(String[] args)
	{
		System.out.println("paths");
		/*
		System.out.println(PossiblePaths(2,4));
		Set<Integer> mySet = new HashSet<Integer>();
		mySet.add(1);
		mySet.add(2);
		mySet.add(3);
		List<Set<Integer>> subsets = GetAllSubsets(mySet);
		System.out.println(subsets);
		*/
		
		//System.out.println(AllPerms("abcde").size());
		Set<Integer> numbers = new HashSet<Integer>(Arrays.asList(1,2,3,4));
		System.out.println(PickXOutOfN(numbers, 2));
	}
	
	private static List<Set<Integer>> PickXOutOfN(Set<Integer> numbers, int x)
	{
		if (numbers.size() < x)
			return null;
		if (numbers.size() == x)
			return new ArrayList<Set<Integer>>(Arrays.asList(numbers));
		else
		{
			Iterator<Integer> iter = numbers.iterator();
			if (!iter.hasNext())
				return null;
			
			Integer num = (Integer) iter.next();
			Set<Integer> copynums = new HashSet<Integer>();
			copynums.addAll(numbers);
			
			copynums.remove(num);
			List<Set<Integer>> result = new ArrayList<Set<Integer>>();				
			
			List<Set<Integer>> otherSets = PickXOutOfN(copynums, x - 1);
			if (otherSets != null)
			{
				for(Set<Integer> otherSet : otherSets)
				{
					Set<Integer> copy = new HashSet<Integer>();
					copy.addAll(otherSet);
					copy.add(num);
					result.add(copy);
				}			
			}
			List<Set<Integer>> otherCompleteSets = PickXOutOfN(copynums, x);
			if (otherCompleteSets != null)
			{
				result.addAll(otherCompleteSets);
			}
			
			return result;
		}
	}
	
	private static List<String> AllPerms(String word)
	{
		List<String> result = new ArrayList<String>();
		if (word.length() == 0)
			return null;
		else if (word.length() == 1)
		{
			return new ArrayList<String>(Arrays.asList(word));
		}
		else
		{
			for(int i = 0 ; i <= word.length() -1; i++)
			{
				String restOfString = word.substring(0,i) + word.substring(i+1); 
				List<String> otherCharPerms = AllPerms(restOfString);
				for(String perm : otherCharPerms)
				{
					result.add(word.charAt(i) + perm);
				}
			}
		}
		return result;
	}
	
	
	private static List<Set<Integer>> GetAllSubsets(Set<Integer> myset)
	{
		List<Set<Integer>> subsets = new ArrayList<Set<Integer>>();
		if (myset.size() == 0)
		{
			return null;
		}
		else if (myset.size() >= 1)
		{
			// pick one element
			Iterator<Integer> iter = myset.iterator();
			Integer x = (Integer)iter.next();
			subsets.add(new HashSet<Integer>(Arrays.asList(x)));
			myset.remove(x);
			
			List<Set<Integer>> otherSubsets = GetAllSubsets(myset);
			if (otherSubsets != null)
			{					
				for (Set<Integer> otherSet : otherSubsets)
				{
					subsets.add(otherSet);
					Set<Integer> save = new HashSet<Integer>();
					for (Integer z : otherSet)
					{
						save.add(z);
					}
					save.add(x);
					subsets.add(save);
				}
			}
		}
		return subsets;
	}
	
	private static int PossiblePaths(int n, int m)
	{
		if (n==1 || m==1)
			return 2;		
		else if (n<1 || m<1)
			return 0;
		else
		{
			return PossiblePaths(n-1, m) + PossiblePaths(n,m-1);
		}
	}
}
