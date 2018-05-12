
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
			node=new Node(value);
			return node;
		}

		if(value<node.value)
			
			node.left=insertRec(node.left, value);
				
		else
			node.right=insertRec(node.right, value);
		
		return node;
		
	}
	
	public boolean searchRec(Node node,int value)
	{
		if(node==null)
		{
			return false;
		}
		
		if(node.value==value)
			return true;
		else if(value<node.value)
			
			return searchRec(node.left, value);
				
		else
			return searchRec(node.right, value);
		
	}
	
	
	public Node deleteRec(Node node,int value)
	{
		if(node==null) return node;

		else if(value<node.value)
			node.left = deleteRec(node.left, value);
		else if(value>node.value)
			node.right=deleteRec(node.right, value);
		else
		{
			if(node.left==null) return node.right;
			else if(node.right==null) return node.left;
		
			Node temp=getNodeSuccesor(node.right);
			node.value=temp.value;
			node.right= deleteRec(node.right, value);
				
		}
		return node;
	}
	
	private Node getNodeSuccesor(Node node)
	{
		if(node.left==null) return node;
		
		return getNodeSuccesor(node.left);
	}
	public void inorder(Node node)
	{
		if(node==null) return;
		
		inorder(node.left);
		System.out.println(node.value);
		inorder(node.right);
		
	}
	public void preOrder(Node node)
	{
		if(node==null) return;
		System.out.println(node.value);
		preOrder(node.left);
		preOrder(node.right);
	}
	
	public void postOrder(Node node)
	{
		if(node==null) return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.value);
	}
	
	public static void main(String[] args) {
		
		BinarySearchTree bst=new BinarySearchTree();
		bst.root=bst.insertRec(bst.root,1);
		bst.insertRec(bst.root,2);
		bst.insertRec(bst.root,3);
		bst.insertRec(bst.root,4);
		bst.insertRec(bst.root,5);
		bst.inorder(bst.root);
		System.out.println(bst.searchRec(bst.root, 6));
		bst.preOrder(bst.root);
		System.out.println(bst.searchRec(bst.root, 1));
		bst.postOrder(bst.root);
		System.out.println(bst.searchRec(bst.root, 9));
	}
}
