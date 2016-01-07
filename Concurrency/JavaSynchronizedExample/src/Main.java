
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Counter counter = new Counter();
	     Thread  threadA = new CountThread(counter);
	     Thread  threadB = new CountThread(counter);

	     threadA.start();
	     threadB.start(); 

	}

}
