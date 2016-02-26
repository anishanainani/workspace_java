
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BST<String, Integer> bst = new BST<String, Integer>();
		bst.put("K", 2);
		bst.put("S", 3);
		bst.put("A", 9);
		bst.put("B", 5);
		bst.put("M", 2);
		bst.put("C", 10);
		
		System.out.println(bst.get("A"));
		
		System.out.println(bst.min());
		
		System.out.println(bst.floor("P"));
		
		System.out.println(bst.ceiling("N"));
		
		System.out.println(bst.rank("K"));
		
		System.out.println(bst.select(0));

	}

}
