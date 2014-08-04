import Models.Tree;


public class Program {
	public static void main(String args[])
	{
		System.out.println("Dzsdd");
		Integer[] arr = {1,2,3,4,5,6,7,8,9,10};
		Tree z = new Tree(arr);
		z.PrintTreeInOrder(z.Head);
		System.out.println();
		System.out.println( "11 " + z.DFS(11));
		System.out.println( "9 " + z.DFS(9));
		
		System.out.println( "11 " + z.BFS(11));
		System.out.println( "9 " + z.BFS(9));
		
		z.PrintPretty();
	}
}
