
public class MinPriorityQueue<Key extends Comparable<Key>> {
	private int N;
	private Key[] keys;

	private MinPriorityQueue(int capacity){
		keys = (Key[]) new Comparable[capacity+1];
	}
	public void swim(int k){
		while(k > 1 && greater(k/2, k)){
			exch(k/2, k);
			k = k/2;
		}
	}
	
	//logn
	public void insert(Key k){
		keys[++N] = k;
		swim(N);
	}
	public boolean greater(int i, int j){
		return keys[i].compareTo(keys[j]) > 0;
	}
	
	public void exch(int i, int j){
		Key swap = keys[i];
		keys[i] = keys[j];
		keys[j] = swap;
	}
	
	public void sink(int k){
		while(2*k <= N){
			int j = 2*k;
			if(j < N && greater(j, j+1)) j++;
			if(!greater(k, j)) break;
			exch(k, j);
			k = j;
		}
	}
	
	//logn
	public Key delMin(){
		Key min = keys[1];
		exch(1, N--);
		sink(1);
		keys[N+1] = null;
		return min;
	}
	
	public boolean isEmpty(){
		return N==0;
	}
	
	public Key max(){
		return keys[1];
	}
	
	public static void main(String[] args) {
		MinPriorityQueue<Integer> maxpq = new MinPriorityQueue<Integer>(10);
		maxpq.insert(2);
		maxpq.insert(5);
		maxpq.insert(7);
		maxpq.insert(3);
		maxpq.insert(8);
		
		System.out.println((Integer)maxpq.delMin());
		System.out.println((Integer)maxpq.delMin());
	}

}
