
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
		t.insert(5);
		t.insert(6);
		
		//t.display(t.root);
		
		//Node n = t.search(3);
		//Node is = t.inorderSuccessor(n);
		//if(is!=null)
		//System.out.println(is.value);
		
		t.printAllPaths(t.root, 6);
	}

}
