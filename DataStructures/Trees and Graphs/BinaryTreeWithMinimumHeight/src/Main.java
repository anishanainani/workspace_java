
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTree t = new BinaryTree();
		int[] array = {1,2,3,4,5,6,7,8};
		
		t.createMinBST(array, 0, array.length-1);
		t.display(t.root);
		
	}

}
