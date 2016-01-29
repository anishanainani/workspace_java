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
	


	public void pathsSum(Node n, int value, ArrayList<Integer> p){



		   
		   int sum = 0;
		   
		   for(int i = 0; i < p.size(); ++i){
				sum+=p.get(i);
				
			}
		   
		if(sum == value){
			
			for(int i = 0; i < p.size(); ++i){
				System.out.print(p.get(i)+" ");
				
			}
			
			System.out.println();
			
		}


		   if(n==null){
			
				return;
			}

		
		p.add(n.value);
		//System.out.println(n.value);

		pathsSum(n.left, value,p);

		pathsSum(n.right,value,p);
		p.remove(p.size()-1);
	}

	public void printAllPaths(Node node, int value){
		if(node== null)
		return;

		ArrayList<Integer> paths = new ArrayList<Integer>();
		if(root == node)
		pathsSum(node,value,paths);

		pathsSum(node.left,value,paths);
		pathsSum(node.right,value,paths);

		printAllPaths(node.left,value);
	    printAllPaths(node.right,value);
	}
}
