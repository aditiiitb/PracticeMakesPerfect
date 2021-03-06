import java.util.ArrayList;

public class SimplePermutation implements Procedure {
	public ArrayList<ArrayList<Integer>> Process(ArrayList<Integer> numbers)
	{
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		// pick one element from list and combine it in front and back with all permutations of rest of list
		// 1 element has 1 perm, two elements have 2 perms, 3 elements have 2 + 2 + 2 perms.
		if (numbers.size()  <= 1)
			result.add(numbers);
		else 
		{
			for(int i = 0; i < numbers.size() ; i++)
			{
				ArrayList<ArrayList<Integer>> restOfListPerms = Process(Utils.RemoveI(numbers, i));			
				for(int j = 0 ; j < restOfListPerms.size(); j++)
				{
					restOfListPerms.get(j).add(0,numbers.get(i));
					result.add(restOfListPerms.get(j)); 
				}				
			}
		}
		return result;
	}
	
	public ArrayList<String> Process(String s)
	{
		ArrayList<String> result  = new ArrayList<String>();
		if (s.length() <= 1)
		{
			result.add(s);
		}
		else
		{
			for(int i = 0 ; i <s.length(); i++)
			{
				String a = s.substring(0, i);
				String b = s.substring(i+1);
				String c= a.concat(b);
				ArrayList<String> otherPerms =Process(c);
				for(int j = 0 ; j < otherPerms.size(); j++)
				{
					result.add(otherPerms.get(j)+ s.charAt(i));
				}
			}
		}
		
		return result;
	}
	
}
