
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTree t = new BinaryTree();
		t.insert(6);
		t.insert(7);
		t.insert(4);
		t.insert(2);
		t.insert(5);
		t.insert(1);
		t.insert(3);
		t.display(t.root);
		System.out.println("--");
		t.rotateRight(t.search(6));
		t.display(t.root);
		//Node n = t.search(3);
		
		
		
	}

}
