import java.util.HashMap;
import java.util.Map;


public class LinkedListFuncs {

	public static void RemoveDupes(Node head)
	{
		Map<Integer, Boolean> Values = new HashMap<Integer, Boolean>();
		Node curr = head; Node prev = head;		
		while (curr!= null)
		{
			if (!Values.containsKey(curr.Value))
			{
				Values.put(curr.Value,true);
				prev = curr;
			}
			else
			{
				prev.Next = curr.Next;
			}
			curr = curr.Next;
		}
	}
	
	public static void UpdateData(Node head, int value, int index)
	{
		Node curr = head;
		int count = 0;
		while (curr != null && count < index)
		{
			curr = curr.Next;
			count++;
		}
		if (curr != null)
		{
			curr.Value = value;
		}
	}
	
	public static void DeleteVal(Node head, int val)
	{
		Node prev = null;
		Node curr = head;
		while (curr!= null)
		{
			
		}
	}
}
