
public class TreeFuncs {

	public static boolean IsBalanced(TreeNode head)
	{
		if (head == null)
			return true;
		else
			return (Math.abs(Length(head.Left) - Length(head.Right)) <= 1);
				
	}
	
	public static int Length(TreeNode head)
	{
		if(head== null)
			return 0;
		else
			return 1+ Math.max(Length(head.Left), Length(head.Right));
	}
	
	public static TreeNode CreateTree(int i)
	{
		if (i<=0 || i >=7)
			return null;
		TreeNode head = new TreeNode();
		head.Value = i;
		head.Left = CreateTree(i-1);
		head.Right = CreateTree(i+1);
		
		return head;
	}
	
}
