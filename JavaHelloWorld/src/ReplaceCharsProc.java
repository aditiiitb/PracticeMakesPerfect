import java.util.ArrayList;


public class ReplaceCharsProc implements Procedure {

	public ArrayList<String> Process(String word, String[] options) 
	{
		ArrayList<String> result = new ArrayList<String>();
		Combinations getSubsets = new Combinations();
		
		int NumberOfQuestionMarks = Utils.GetCount(word, "?");
		ArrayList<String> expandedOptions = ExpandOptions(options, NumberOfQuestionMarks);
		ArrayList<ArrayList<String>> replaceStrings = getSubsets.GetAllStringSubsetsOfLength(expandedOptions, NumberOfQuestionMarks);
		for(int i = 0 ; i < replaceStrings.size(); i++)
		{
			result.add(ReplaceString(word, "?", replaceStrings.get(i)));
		}
		return result;		
	}

	public String ReplaceString(String original, String tobeReplaced, ArrayList<String> replacement)
	{
		String result = original;int index = 0;
		for (int i = 0; i < original.length(); i++)
		{
			if (original.charAt(i) == tobeReplaced.charAt(0))
			{
				result = result.substring(0, i) + replacement.get(index) + result.substring(i+1);
				index++;
			}			
		}
		return result;
	}
	public ArrayList<String> ExpandOptions(String[] options, int length)
	{
		ArrayList<String> result = new ArrayList<String>();
		
		for(int i =0 ; i < options.length; i++)
		{
			for (int k = 0 ; k <length; k++)
				result.add(options[i]);
		}
		return result;
		
	}
	public ArrayList<ArrayList<Integer>> Process(ArrayList<Integer> numbers) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<String> Process(String word) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
