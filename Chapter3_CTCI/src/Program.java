import Models.*;


public class Program {
	public static void main(String args[])
	{
		System.out.println("Dzsdd");
		Integer[] arr = {2,3,4,5,6,7,8,9,10};
		Tree z = new Tree(arr);
		
		//z.PrintPretty();
		
		//Node x = new Node();
		//x.Value = 2;
		//z.Insert(x);
		
		z.PrintPretty();
		
		System.out.println(z.Size(z.Head));
		
		System.out.println(z.maxDepth(z.Head));
		
		System.out.println(z.MinValue(z.Head));
	}
}
