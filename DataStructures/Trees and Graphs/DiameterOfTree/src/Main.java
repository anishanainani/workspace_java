
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTree t = new BinaryTree();
		t.insert(20);
		t.insert(21);
		t.insert(22);
		t.insert(6);
		t.insert(5);
		t.insert(4);
		t.insert(3);
		t.insert(2);
		t.insert(1);
		t.insert(7);
		t.insert(8);
		t.insert(9);
		t.insert(10);
		System.out.println(t.diameter());
		
		
		//Node n = t.search(3);
		
		
		
	}

}
