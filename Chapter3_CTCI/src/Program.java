import Models.*;


public class Program {
	public static void main(String args[])
	{
		System.out.println("Dzsdd");
		Integer[] arr = {3,4,5,6,2};
		Tree z = new Tree(arr);
		z.PrintPretty();
		
		
		//Node x = new Node();
		//x.Value = 2;
		//z.Insert(x);
		//System.out.println(z.Size(z.Head));		
		//System.out.println(z.maxDepth(z.Head));		
		//System.out.println(z.MinValue(z.Head));		
		//System.out.println(z.HasLeafPath(z.Head,11));		
		//z.PrintPaths("", z.Head);
		//z.Mirror(z.Head);
		//z.PrintPretty();
		//z.Duplicate(z.Head);
		//z.PrintPretty();
		
		//Integer[] arr2 = {2,3,4,5,6,7,8,9,10};
		//Tree A = new Tree(arr2);
		//A.PrintPretty();
		//System.out.println(z.IsSame(z.Head, A.Head));
		System.out.println( " \n\n" + z.countTrees(z.Size(z.Head)));
		
		System.out.println(" \n\n" +z.IsBST(z.Head, Integer.MIN_VALUE, Integer.MAX_VALUE));

	}	
}
