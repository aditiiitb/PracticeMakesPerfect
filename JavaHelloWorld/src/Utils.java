import java.util.ArrayList;


public class Utils {

	public static ArrayList<Integer> RemoveI(ArrayList<Integer> numbers, int i)
	{
		ArrayList<Integer> copy = new ArrayList<Integer>();
		for (int j = 0 ; j <numbers.size(); j++)
		{
			if (j!=i)
				copy.add(numbers.get(j));
		}
		return copy;
	}
}
