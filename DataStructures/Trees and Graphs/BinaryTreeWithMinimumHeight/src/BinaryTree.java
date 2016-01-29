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
	
	public void createMinBST(int[] array, int l, int r){
		if(l <= r){
			int mid = (l+r)/2;
			
			insert(array[mid]);
			createMinBST(array, l, mid-1);
			createMinBST(array, mid+1, r);
		}
	}
	

}
