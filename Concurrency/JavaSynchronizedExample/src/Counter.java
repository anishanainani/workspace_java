
public class Counter {

	int count = 0;
	
	public synchronized void add(int a){
		count+=a;
	}
}
