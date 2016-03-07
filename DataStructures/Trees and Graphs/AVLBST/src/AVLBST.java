import java.util.ArrayList;


public class AVLBST<Key extends Comparable<Key> > {
	private Node root; // root of the AVL tree
	
	// BST helper node data type
	private class Node{
		private Key key;
		private Node left, right, parent;
		int height;
		
		public Node(Key key, int height, Node parent){
			this.key = key;
			this.height = height;
		}
	}
	
	public void insert(Key key){
		if(key == null) throw new NullPointerException("argument to insert() is null");
		
		root = insertBST(root, key);
		balance(search(root, key));
	}
	
	public Node insertBST(Node x, Key key){
		if(x == null) return new Node(key, 0, null);

		int cmp = key.compareTo(x.key);
		if(cmp < 0) {
			x.left = insertBST(x.left, key);
			x.left.parent = x;
		}
		else if(cmp > 0) {
			x.right = insertBST(x.right, key);
			x.right.parent = x;
		}
		
		x.height = height(x);
		return x;
	}
	
	// Returns the height of the subtree rooted at x
	public int height(Node x){
		if(x == null) return -1;
		
		return Math.max(height(x.left), height(x.right)) + 1; 
	}
	
	public Node search(Node x, Key key){
		while(x != null){
			int cmp = key.compareTo(x.key);
			
			if(cmp == 0) return x;
			else if(cmp < 0) x = x.left;
			else x = x.right;
		}
		
		return null;
	}
	
	public Node rotateRight(Node x){
		Node h = x.left;
		x.left = h.right;
		h.right = x;
		
		x.height = height(x);
		h.height = height(h);
		
		return h;
	}
	
	public Node rotateLeft(Node x){
		Node h = x.right;
		x.right = h.left;
		h.left = x;
		
		x.height = height(x);
		h.height = height(h);
		
		return h;
	}
	
	public void balance(Node x){
		while(x!=null){
			if(height(x.left) >= 2 + height(x.right)){
				if(height(x.left.left) > height(x.left.right)){
					rotateRight(x);
				} else {
					rotateLeft(x.left);
					rotateRight(x);
				}
			} else if(height(x.right) >= 2 + height(x.left)){
				if(height(x.right.right) > height(x.right.left)){
					rotateLeft(x);
				} else {
					rotateRight(x.right);
					rotateLeft(x);
				}
			}
			
			x = x.parent;
		}
	}
	
	public void print(){
		print(root);
	}
	
	public void print(Node x){
		ArrayList<Node> queue = new ArrayList<Node>();
		
		queue.add(x);
		
		while(!queue.isEmpty()){
			ArrayList<Node> child = new ArrayList<Node>();
			while(!queue.isEmpty()){
				Node n = queue.remove(0);
				System.out.print(n.key+" ");
				
				if(n.left!=null)
					child.add(n.left);
				
				if(n.right!=null)
					child.add(n.right);
			}
			System.out.println();
			queue = new ArrayList<Node>(child);
		}
		
	}
}
