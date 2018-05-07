
public class BinarySearchTree {

	Node root;
	
	class Node
	{
		
		 int value;
		 Node left,right;
		public Node(int value) {
			this.value=value;;
		}

	}
	
	public boolean insert(int value)
	{
		if(this.root==null) 
		{
			this.root=new Node(value);
			return true;
		}
		
		Node node=new Node(value);	
		
		Node current=root;
		Node parent=null;
		while(true)
		{
			parent=current;
			
			if(value< current.value)
			{
				current=current.left;
				if(current==null)
					parent.left=node;
				return true;
				
			}
			else
			{
				current=current.right;
				if(current==null)
					parent.right=node;
				return true;
			}
			
			
			
		}
		
	}
	
	private Node insertRec(Node node,int value)
	{
		if(node==null)
		{
			new Node(value);
		}

		if(value<node.value)
			
			return insertRec(node.left, value);
				
		else
			return insertRec(node.right, value);
		
	}
	
	public static void main(String[] args) {
		
		BinarySearchTree bst=new BinarySearchTree();
		bst.insert(1);
		bst.insert(2);
		bst.insert(3);
		bst.insert(4);
		bst.insert(5);
	}
}
