


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
	
	public Node inorderSuccessor(Node n){
		
		if(n.parent == null && n.right == null){
			return null;
		}
		
		if(n.right != null){
			Node temp = n.right;
			while(temp.left!=null){
				temp = temp.left;
			}
			return temp;
		}
		
		Node p = n.parent;
		while(p!=null && n != p.left ){
			n = n.parent;
			p = p.parent;
		}
		
		
		return p;
	}
	
	public int height(){
		return findHeight(root);
	}
	public int findHeight(Node node){
		if(node == null){
			return 0;
		}
		
		return 1+Math.max(findHeight(node.left), findHeight(node.right));
	}
	
	public void preorderTraversal(Node node){
		if(root==null){
			return;
		}
		
		System.out.println(node.value);
		preorderTraversal(node.left);
		preorderTraversal(node.right);
	}
	
	public void postorderTraversal(Node node){
		if(root==null){
			return;
		}
		
		preorderTraversal(node.left);
		preorderTraversal(node.right);
		System.out.println(node.value);
	}
	
	public void inorderTraversal(Node node){
		if(root==null){
			return;
		}
		
		preorderTraversal(node.left);
		System.out.println(node.value);
		preorderTraversal(node.right);
		
	}
	
	public int lowestCommonAncesstorBST(int in1, int in2){
		return findLowestCommonAncesstorBST(root,in1,in2);
	}
	public int findLowestCommonAncesstorBST(Node node, int in1, int in2){
		if(node == null){
			return -1;
		}
		
		if((in1 < node.value && in2 > node.value) || (in2 < node.value && in1 > node.value)){
			return node.value;
		} else if(in1 < node.value && in2 < node.value){
			return findLowestCommonAncesstorBST(node.left,in1,in2);
		} else {
			return findLowestCommonAncesstorBST(node.right,in1,in2);
		}
	}
	
	public void preorderTraversalIterative(){
		Stack<Node> s = new Stack<Node>();
		
		s.push(root);
		
		while(!s.isEmpty() && root!=null){
			Node current = s.pop();
			System.out.println(current.value);
			if(current.right != null){
				s.push(current.right);
			}
			
			if(current.left != null){
				s.push(current.left);
			}
		}
		
	}
}
