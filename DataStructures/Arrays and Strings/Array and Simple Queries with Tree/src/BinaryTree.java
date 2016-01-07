
public class BinaryTree {
	Node root;
	Node[] INodes;
	int l;
	
	BinaryTree(int N){
		root = null;
		INodes = new Node[N];
		l = 0;
	}
	
	public Node buildTree(long[] array, int i, int j){
		
		Node node =  null;
		if(i<=j){
			int mid = (i+j)/2;
			node = new Node();
			
			node.value = array[mid];
			if(root == null){
				root = node;
			}
			
			node.left = buildTree(array,i,mid-1);
			node.right = buildTree(array, mid+1,j);
		}
		
		return node;
		
	}
	
	public void inorderTraversal(Node node){
		if(node==null){
			return;
		}
		inorderTraversal(node.left);
		//System.out.println(node.value);
		INodes[l] = node;
		l++;
		inorderTraversal(node.right);
		
	}
	
	public void inorder(Node node){
		if(node==null){
			return;
		}
		inorder(node.left);
		System.out.println(node.value);
	
		inorder(node.right);
		
	}
}
