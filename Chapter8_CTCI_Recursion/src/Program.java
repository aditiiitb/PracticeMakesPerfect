
import java.util.*;


public class Program {
	public static void main(String[] args)
	{
		System.out.println("paths");
		System.out.println(PossiblePaths(2,4));
		Set<Integer> mySet = new HashSet<Integer>();
		mySet.add(1);
		mySet.add(2);
		mySet.add(3);
		List<Set<Integer>> subsets = GetAllSubsets(mySet);
		System.out.println(subsets);
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
