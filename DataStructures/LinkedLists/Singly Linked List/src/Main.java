
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinkedList<Integer> sl = new SinglyLinkedList<Integer>();
		sl.insertInFront(3);
		sl.insertInFront(5);
		sl.insertInFront(7);
		
		sl.displayAll();
		
		sl.delete(5);
		
		sl.displayAll();
		
	}

}
