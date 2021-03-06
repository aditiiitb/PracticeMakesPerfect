import java.util.ArrayList;


public class OrderedPermutation implements Procedure{

	public ArrayList<ArrayList<Integer>> Process(ArrayList<Integer> numbers)
	{
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		// sort the numbers list
		if (numbers.size()  <= 1)
			result.add(numbers);
		else if (numbers.size() == 2)
		{
			// order the 2 possible perms
			int smaller = Math.min(numbers.get(0), numbers.get(1));
			int larger = Math.max(numbers.get(0), numbers.get(1));
			
			ArrayList<Integer> orderedPerm = new ArrayList<Integer>();
			orderedPerm.add(smaller);
			orderedPerm.add(larger);
			result.add(orderedPerm);
			orderedPerm.clear();
			orderedPerm.add(larger);
			orderedPerm.add(smaller);
			result.add(orderedPerm);			
		}
		else
		{
			for(int i = 0; i < numbers.size() ; i++)
			{
				int x = numbers.get(i);
				ArrayList<Integer> listWithoutI = Utils.RemoveI(numbers, i);
				ArrayList<ArrayList<Integer>> restOfListPerms = Process(listWithoutI);			
				for(int j = 0 ; j < restOfListPerms.size(); j++)
				{
					restOfListPerms.get(j).add(0,x);
					result.add(restOfListPerms.get(j)); 
				}				
			}
		}
		return result;
	}

	public ArrayList<String> Process(String word) {
		// TODO Auto-generated method stub
		return null;
	}
}
