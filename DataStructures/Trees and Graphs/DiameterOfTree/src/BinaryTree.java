import java.util.ArrayList;


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
	
	public int findMaxDepth(Node node){
		if(node == null){
			return 0;
		}
		
		return 1+Math.max(findMaxDepth(node.left), findMaxDepth(node.right));
	}
	
	public int diameter(){
		return findDiameter(root);
	}
	
	public int findDiameter(Node node){
		if(node == null){
			return 0;
		}
		
		int maxDepthLeft = findMaxDepth(node.left);
		int maxDepthRight = findMaxDepth(node.right);
		
		
		return Math.max(maxDepthLeft + maxDepthRight +1, Math.max(findDiameter(node.left), findDiameter(node.right)));
	}
}
