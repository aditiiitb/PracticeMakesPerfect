import java.util.ArrayList;


public class Combinations implements Procedure {
	public ArrayList<ArrayList<Integer>> Process(ArrayList<Integer> numbers)
	{
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(); 
		// pick all subsets from the list
		// some are of length 1, 2, ... Length.
		// subset of length 2 are first letter + all subsets of length 1, and so over whole array.
		// 
		if (numbers.size() <=1)
			result.add(numbers);
		else
		{
			for(int i = 1 ; i <= numbers.size();i++)
			{
				result.addAll(GetAllSubsetsOfLength(numbers,i));
			}
		}
		return result;
	}

	public ArrayList<ArrayList<Integer>> GetAllSubsetsOfLength(ArrayList<Integer> numbers, int l)
	{
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(); 
		if (numbers.size() <= l)
		{
			result.add(numbers);
		}
		else if (l<=1)
		{
			
				for (int i = 0; i <numbers.size(); i++)
				{
					ArrayList<Integer> individual = new ArrayList<Integer>();
					individual.add(numbers.get(i));
					result.add(individual);
				}
			
			
		}
		else
		{
			ArrayList<ArrayList<Integer>> resultIntermediate1 = GetAllSubsetsOfLength(Utils.RemoveI(numbers, 0), l-1);
			for(int i = 0 ;  i <resultIntermediate1.size(); i++)
			{				
				ArrayList<Integer> subset = new ArrayList<Integer>();
				subset.add(numbers.get(0));
				subset.addAll(resultIntermediate1.get(i));
				result.add(subset);
			}
			ArrayList<ArrayList<Integer>> resultIntermediate2 = GetAllSubsetsOfLength(Utils.RemoveI(numbers, 0), l);
			result.addAll(resultIntermediate2);
		}
		
		return result;
	}
	public ArrayList<String> Process(String word) {
		// TODO Auto-generated method stub
		return null;
	}
}
