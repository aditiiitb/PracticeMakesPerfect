
public class Program {
	public static void main(String args[])
	{
		System.out.println("helllooo");
		
		
		/*
		Node head = CreateList();
		
		PrintList(head);
		
		LinkedListFuncs.UpdateData(head,1,2);
		LinkedListFuncs.UpdateData(head,1,3);
		
		PrintList(head);
		LinkedListFuncs.RemoveDupes(head);
		
		PrintList(head);
		
		*/
		
		TreeNode head = TreeFuncs.CreateTree(9);
		System.out.print(TreeFuncs.IsBalanced(head));
	}
	
	private static Node CreateList()
	{
		Node head = new Node();
		Node save = head;
		for (int i =0; i < 10; i++)
		{
			head.Value = i;
			head.Next = new Node();
			head = head.Next;
		}		
		return save;
	}
	
	private static void PrintList(Node head)
	{
		Node curr= head;
		System.out.println("\n");
		while (curr != null)
		{
			System.out.print(curr.Value + " ");
			curr = curr.Next;
		}
	}
}
