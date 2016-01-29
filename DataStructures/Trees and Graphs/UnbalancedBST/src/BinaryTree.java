public class BinaryTree {
	Node root;
	
	
	public void insert(int data){
		Node newN = new Node();
		newN.value = data;
		
		if(root == null){
			root = newN;
			return;
		}
		
		Node elem = root;
		while(true){
			if(elem.value < data){
				if(elem.right != null)
					elem = elem.right;
				else {
					elem.right = newN;
					newN.parent = elem;
					break;
				}
			} else {
				if(elem.left != null)
					elem = elem.left;
				else{	
					elem.left = newN;
					newN.parent = elem;
					break;
				}
			}
		}
	}
	
	public void display(Node elem){
		if(elem != null){
			System.out.println(elem.value);
			display(elem.left);
			display(elem.right);
		} else {
			return;
		}
	}
	
	public Node search(int val){
		Node elem = root;
		while(elem!=null){
			if(elem.value == val){
				return elem;
			} else if(val < elem.value){
				elem = elem.left;
			} else {
				elem = elem.right;
			}
		}
		
		return null;
	}
	
	public void rotateRight(Node node){
		Node newRoot = node.left;
		if(node == root){
			root=newRoot;
		}
		
		node.left = newRoot.right;
		newRoot.right = node;
		
		
	}
	
	public void rotateLeft(Node node){
		Node newRoot = node.right;
		node.right = newRoot.left;
		newRoot.left = node;
	}
	
	public int maxDepth(Node node){
		if(node == null){
			return 0;
		}
		
		return 1+Math.max(maxDepth(node.left), maxDepth(node.right));
	}
	
	public int minDepth(Node node){
		if(node == null){
			return 0;
		}
		
		return 1+Math.min(minDepth(node.left), minDepth(node.right));
	}
	
	public boolean isBalanced(){
		return maxDepth(root)-minDepth(root) < 2;
	}
}
