package Models;


import java.util.*;


public class Tree {
	public Node Head;
	
	public Tree(Integer[] arr)
	{				
		Head = CreateTreeFromArray(arr, 0, arr.length-1);		
	}
	
	public boolean BFS(int val)
	{
		return BFSHelper(Head, val);
	}
	public boolean DFS(int val)
	{
		return DFSHelper(Head, val);
	}
	public void PrintTreeInOrder(Node x)
	{
		if (x!= null)
		{
			PrintTreeInOrder(x.Left);
			System.out.print(x.Value + " ");
			PrintTreeInOrder(x.Right);
		}
	}
	public void PrintPretty()
	{
		Node SpecialNode = new Node();
		SpecialNode.Value = 1000;
		
		if (Head == null)
			return;
		// prints in a tree format
		Queue<Node> q = new LinkedList<Node>();
		q.add(Head);
		q.add(SpecialNode);
		while (!q.isEmpty())
		{
			System.out.println(); // print for next line
			boolean morelines = false;
			while (q.peek() != SpecialNode)
			{
				
				Node s = q.remove();
				if (s.Left != null)
				{
					morelines = true;
					q.add(s.Left);
				}
				if (s.Right != null)
				{	
					morelines = true;
					q.add(s.Right);
				}
				System.out.print(s.Value + " ");
			}
			if (morelines)
			{	
				q.add(SpecialNode);// add the special char to end of queue				
			}
			q.remove();// remove the special node from head of queue				
		}
	}
	public void Insert(Node x)
	{
		if (Head == null)
		{
			Head = x;
			return;
		}
		else
			InsertHelper(x, Head);
	}
	public int Size(Node root)
	{
		if (root==null)
			return 0;
		else
			return 1+ Size(root.Left) + Size(root.Right);
	}
	public int maxDepth(Node root)
	{
		if (root==null)
			return 0;
		else
			return 1+ Math.max(maxDepth(root.Left), maxDepth(root.Right)); 
	}
	public int MinValue(Node root)
	{
		if (root == null)
			return 1000;
		else 
			{
				if (root.Left == null)
					return root.Value;
				else
					return MinValue(root.Left);
			}
			
	}
	public boolean HasLeafPath(Node root, int Sum)
	{
		if (root == null)
		{
			return (Sum == 0);			
		}
		else
		{
			if (root.Value == Sum)
				return true;
			else if (root.Value > Sum)
				return false;
			else
			{
				return HasLeafPath(root.Left, Sum - root.Value) || HasLeafPath(root.Right, Sum - root.Value);
			}
		}			
	}
	public void PrintPaths(String prefix, Node root)
	{
		if (root == null)
			System.out.println(prefix);		
		else if (root.Left == null && root.Right == null)
		{
			System.out.println(prefix + " " + root.Value.toString());
		}			
		else
		{		
			PrintPaths(prefix+ " " +root.Value.toString(),root.Left);
			PrintPaths(prefix+ " "+root.Value.toString(), root.Right);
		}
	}
	public void Mirror(Node root)
	{
		if (root != null)
		{
			// exchange left and right subtrees
			Node saveleft = root.Left;
			root.Left = root.Right;
			root.Right = saveleft;
			Mirror(root.Left);
			Mirror(root.Right);
		}
	}
	public void Duplicate(Node root)
	{
		if (root != null)
		{
			Node saveleft = root.Left;
			Node dupnode = new Node();
			dupnode.Value = root.Value;
			dupnode.Left = saveleft;
			root.Left = dupnode;
			Duplicate(saveleft);
			Duplicate(root.Right);
		}
	}
	public boolean IsSame(Node rootA, Node rootB)
	{
		if ((rootA == null && rootB != null) || (rootA != null && rootB == null))
			return false;
		else if (rootA== null && rootB== null)
			return true;
		else {
			if (rootA.Value == rootB.Value)
				return IsSame(rootA.Left, rootB.Left) && IsSame(rootA.Right, rootB.Right);
			else
				return false;
		}
	}
	public int countTrees(int numKeys)
	{
		 if (numKeys <=1) { 
			    return(1); 
			  } 
			  else { 
			    // there will be one value at the root, with whatever remains 
			    // on the left and right each forming their own subtrees. 
			    // Iterate through all the values that could be the root... 
			    int sum = 0; 
			    int left, right, root;

			    for (root=1; root<=numKeys; root++) { 
			      left = countTrees(root - 1); 
			      right = countTrees(numKeys - root);

			      // number of possible trees with this root == left*right 
			      sum += left*right; 
			    }

			    return(sum); 
			  }
	}
	public boolean IsBST(Node root, int small, int large)
	{
		if (root == null)
			return true;
		else 
		{
			return (root.Value <= large && root.Value >= small && IsBST(root.Left, small, root.Value) && IsBST(root.Right, root.Value, large));
		}
	}
		
	
	private void InsertHelper(Node x, Node root)
	{
		if (root == null)
			return;
		if (root.Value >= x.Value)
		{
			if (root.Left == null)
			{
				root.Left = x;				
			}
			else
				InsertHelper(x, root.Left);
		}
		else
		{
			if (root.Right == null)
			{
				root.Right =x;
			}
			else
				InsertHelper(x, root.Right);
		}
	}
	private boolean DFSHelper(Node head, int val)
	{
		if (head==null)
			return false;
		if (head.Value == val)
			return true;
		else return DFSHelper(head.Left,val) || DFSHelper(head.Right, val);
	}
	private Node CreateTreeFromArray(Integer[] vals, int start, int end)
	{
		if (start > end)
			return null;
		
		Node root = new Node();
		root.Value = vals[(start+end)/2];
		root.Left = CreateTreeFromArray(vals, start, (start+end)/2 - 1);
		root.Right = CreateTreeFromArray(vals, (start+end)/2 +1 , end);
		return root;
	}
	private boolean BFSHelper(Node head, int val)
	{
		if (head == null)
			return false;
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(head);
		while (!q.isEmpty())
		{
			Node root = q.remove();
			System.out.print(root.Value + " ");
			if (root.Value == val)
					return true;
				else 
				{
					if (root.Left != null)
						q.add(root.Left);
					if (root.Right != null)						
						q.add(root.Right);
				}
		}
		
		return false;
	}
	

}
