import java.util.ArrayList;
import java.util.Collections;

public class Program
{
	public static void main(String[] args)
	{
		System.out.println("sdsdsad");
		ArrayList<Integer> mylist = new ArrayList<Integer>();		
		mylist.add(1);
		mylist.add(3);
		mylist.add(2);
		System.out.println(mylist);		
		
		Procedure myprocedures = new SimplePermutation();
		Collections.sort(mylist);
		System.out.println(myprocedures.Process(mylist));
	}
	
}

// permutations
// subsets i.e. combinations

