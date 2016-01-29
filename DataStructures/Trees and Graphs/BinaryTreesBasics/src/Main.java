
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTree t = new BinaryTree();
		t.insert(3);
		t.insert(2);
		t.insert(4);
		t.insert(1);
		t.insert(6);
		t.insert(5);
		t.insert(7);
		
		
		//t.display(t.root);
		
		//Node n = t.search(3);
		//Node is = t.inorderSuccessor(n);
		//if(is!=null)
		//System.out.println(is.value);
		
		//System.out.println(t.height()); //O(logn)
		//System.out.println(t.lowestCommonAncesstorBST( 5, 2)); //O(logn)
		t.preorderTraversalIterative();
		
		
	}

}
