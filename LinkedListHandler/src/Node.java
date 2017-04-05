
public class Node {
	
	private int value;
	private Node next;
	
	public Node(int value)
	{
		this.value = value;
	}
	
	public void SetValue(int value)
	{
		this.value = value;
	}
	
	public int GetValue()
	{
		return this.value;
	}
	
	public void SetNext(Node next)
	{
		this.next = next;
	}
	
	public Node GetNext()
	{
		return this.next;
	}
	
	public static Node mergeLinkedList(Node a, Node b)
	{
		Node head;
		Node current;
		if(a == null && b == null)
		{
			return null;
		}
		else if(a == null && b != null)
		{
			return b;
		}
		else if(a != null & b == null)
		{
			return a;
		}
		
		if(a.GetValue() > b.GetValue())
		{
			head = a;
			a = a.GetNext();
		}
		else
		{
			head = b;
			b = b.GetNext();
		}
		
		current = head;
		
		while(a != null && b != null)
		{
			if(a.GetValue() > b.GetValue())
			{
				current.SetNext(a);
				a = a.GetNext();
			}
			else
			{
				current.SetNext(b);
				b = b.GetNext();
			}
			
			current = current.GetNext();
		}
		
		if(a != null)
		{
			current.SetNext(a);
		}
		else if(b != null)
		{
			current.SetNext(b);
		}
		
		return head;
	}
			
	
	public static Node recursiveReverse(Node head)
	{
		if(head == null || head.GetNext() == null)
		{
			return head;
		}
		
		Node reverseHead = recursiveReverse(head.GetNext());
		head.GetNext().SetNext(head);
		head.SetNext(null);
		
		return reverseHead;
	}
	
	public static Node Reverse(Node head)
	{
		//need to consider head is null.
		if(head == null)
		{
			return head;
		}
		
		Node current = head;
		Node before = null;
		Node after = current.GetNext();
		
		for(;after != null;)
		{
			current.SetNext(before);
			before = current;
			current = after;
			after = after.GetNext();
		}
		
		current.SetNext(before);
		
		head = current;
		
		return head;
	}
}
