import java.util.List;

public class NodeList {
	public List<Node> Nodes;
	
	private Node _head;
	
	public Node getHead() { 
		return _head;
	}
	
	public void setHead(Node x)
	{
		_head = x;
	}
	
	private Node _tail;
	
	public Node getTail() { 
		return _tail;
	}
	
	public void setTail(Node x)
	{
		_tail = x;
	}
	
	public void Add(Node x) throws Exception
	{
		if (_head == null)
		{
			_head = x;
			_tail = x;
		}
		else if (_tail != null)
		{
			_tail.Next = x;
		}
		else 
			throw new Exception();
	}
}
