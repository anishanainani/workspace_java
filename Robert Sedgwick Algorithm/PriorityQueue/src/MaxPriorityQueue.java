
public class MaxPriorityQueue<Key extends Comparable<Key>> {
	
	private int N;
	private Key[] keys;

	private MaxPriorityQueue(int capacity){
		keys = (Key[]) new Comparable[capacity+1];
	}
	public void swim(int k){
		while(k > 1 && less(k/2, k)){
			exch(k/2, k);
			k = k/2;
		}
	}
	
	//logn
	public void insert(Key k){
		keys[++N] = k;
		swim(N);
	}
	public boolean less(int i, int j){
		return keys[i].compareTo(keys[j]) < 0;
	}
	
	public void exch(int i, int j){
		Key swap = keys[i];
		keys[i] = keys[j];
		keys[j] = swap;
	}
	
	public void sink(int k){
		while(2*k <= N){
			int j = 2*k;
			if(j < N && less(j, j+1)) j++;
			if(!less(k, j)) break;
			exch(k, j);
			k = j;
		}
	}
	
	//logn
	public Key delMax(){
		Key max = keys[1];
		exch(1, N--);
		sink(1);
		keys[N+1] = null;
		return max;
	}
	
	public boolean isEmpty(){
		return N==0;
	}
	
	public Key max(){
		return keys[1];
	}
	
	public static void main(String[] args) {
		MaxPriorityQueue<Integer> maxpq = new MaxPriorityQueue<Integer>(10);
		maxpq.insert(2);
		maxpq.insert(5);
		maxpq.insert(7);
		maxpq.insert(3);
		maxpq.insert(8);
		
		System.out.println((Integer)maxpq.delMax());
		System.out.println((Integer)maxpq.delMax());
	}

}
