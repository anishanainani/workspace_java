
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Queue<Integer> s = new Queue<Integer>();
		s.enqueue(3);
		s.enqueue(4);
		s.enqueue(5);
		
		
		s.displayAll();
		System.out.println();
		System.out.println(s.dequeue());
		
		s.enqueue(6);
		
		s.displayAll();
		System.out.println();
		System.out.println(s.dequeue());
		
		s.displayAll();
		

	}

}
