
public class LinkedList {

	private Node first;
	
	
	private class Node{
		
		public int value;
		public Node next;
		
		public Node(int value) {
			this.value=value;
		}
		
		@Override
		public String toString() {
			return value+"";
		}
	}
	
	public void addTail(int value)
	{
		Node nextNode=first;
		if(nextNode==null) 
		{
			first=new Node(value);
			return;
		}
		while(nextNode.next!=null)
		{
			nextNode=nextNode.next;
		}
		nextNode.next=new Node(value);
		
	}
	
	public void addHead(int value)
	{
		Node nextNode=first;
		if(nextNode==null) 
		{
			first=new Node(value);
			return;
		}

		Node temp=new Node(value);
		temp.next=first;
		first=temp;
		
	}
	
	public void add(int index,int value)
	{
		Node nextNode=first;
		int pos=1;
		if(nextNode==null && index==1) 
		{
			first=new Node(value);
			return;
		}
		while(nextNode.next!=null)
		{
			if(index==pos) break;
			pos++;
			nextNode=nextNode.next;
		}
		if(pos==index)
		{
			Node node= new Node(value);
			node.next=nextNode.next;
			nextNode.next=node;
		}
		else 
			throw new ArrayIndexOutOfBoundsException();
		
	}
	
	
	public boolean deleteTail() 
	{
		if(first==null) return false;
		
		Node nextNode=first;
		Node previous=null;
		while(nextNode.next!=null)
		{
			
			previous=nextNode;
			nextNode=nextNode.next;
			
		}
		if(previous!=null)		previous.next=null;
		else this.first=null;
		
		return true;
		
	}
	
	public void printContent()
	{
		Node nextNode=first;
		String value=null;
		while(nextNode!=null)
		{
			if(value==null) value=nextNode.value+"";
			else value=value+","+nextNode.value;
			nextNode=nextNode.next;
		}
		System.out.println(value);
	}
	public static void main(String[] args) {
		LinkedList list=new LinkedList();
		list.addTail(1);


		list.deleteTail();
		list.printContent();
	}
}
