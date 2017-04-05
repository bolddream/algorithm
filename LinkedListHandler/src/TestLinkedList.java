

public class TestLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Node head = new Node(11);
//		head = CreateLinkdListA(10);
//		PrintLinkedList(head);
//		head = Node.Reverse(head);
//		PrintLinkedList(head);
//		head = Node.recursiveReverse(head);
//		PrintLinkedList(head);
		
		//TEST merge linked list
		Node headA = CreateLinkdListA(10);
		PrintLinkedList(headA);
		Node headB = CreateLinkdListB(10);
		PrintLinkedList(headB);
		Node headC = Node.mergeLinkedList(headA, headB);
		PrintLinkedList(headC);
		
//		Node test1 = new Node(123);
//		TestParam(test1);
//		System.out.println(test1.GetValue());
	}
	
	public static Node CreateLinkdListA(int count)
	{
		Node head = null;
		for(int i = 0; i < count; i++)
		{
			Node node = new Node(i*i);
			node.SetNext(head);
			head = node;
		}
		
		return head;
	}

	public static Node CreateLinkdListB(int count)
	{
		Node head = null;
		for(int i = 0; i < count; i++)
		{
			Node node = new Node(i*5);
			node.SetNext(head);
			head = node;
		}
		
		return head;
	}

	
	public static void PrintLinkedList(Node head)
	{
		while(head != null)
		{
			System.out.print(head.GetValue());
			System.out.print("    ");
			head = head.GetNext();
		}
		System.out.println();
	}

	public static void TestParam(Node node)
	{
		node.SetValue(111);
	}
}
