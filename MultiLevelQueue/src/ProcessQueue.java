import java.util.LinkedList;
import java.util.Queue;



public class ProcessQueue{
	Queue<Process> queue;
	int size;
	public int number;
	
	ProcessQueue(int n){
		queue = new LinkedList<Process>();
		size = 0;
		number = n;
	}
	
	public void push(Process p){
		queue.add(p);
	}
	
	public Process pop(){
		return queue.remove();
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return queue.isEmpty();
	}
}
