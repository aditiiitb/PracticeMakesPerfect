package Models;

public class Tree {
	public Node Head;
	
	public Tree()
	{		
		Head = CreateTree(5);
		PrintTreeInOrder(Head);
	}
	
	public void InsertNode(Node node)
	{
		
	}
	
	public void RemoveNode(Node node)
	{
		
	}
	
	
	private Node CreateTree(int val)
	{
		if (val <=0 || val >=10)
		{
			return null;
		}
		Node root = new Node();
		root.Value = val;
		root.Left = CreateTree(val -1);
		root.Right = CreateTree(val +1);		
		return root;
	}
	
	private void PrintTreeInOrder(Node x)
	{
		if (x!= null)
		{
			PrintTreeInOrder(x.Left);
			System.out.print(x.Value + " ");
			PrintTreeInOrder(x.Right);
		}
	}
}
