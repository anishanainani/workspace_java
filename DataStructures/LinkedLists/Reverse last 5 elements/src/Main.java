
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
		sl.insertInFront(9);
		sl.insertInFront(11);
		sl.insertInFront(13);
		//sl.insertInFront(15);
		
		sl.displayAll();
		
		sl.reverse(5);
		
		
		//sl.delete(5);
		
		sl.displayAll();
		
	}

}
