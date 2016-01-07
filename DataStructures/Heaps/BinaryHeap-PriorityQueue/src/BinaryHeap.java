import java.util.ArrayList;


public class BinaryHeap {
	
	ArrayList<Integer> input = new ArrayList<Integer>();
	int heapsize = 0;
	
	public BinaryHeap(){
		input.add(0);
	}
	
	public int parent(int i){
		return i/2;
	}
	
	public int left(int i){
		return 2*i;
	}
	
	public int right(int i){
		return (2*i+1);
	}
	
	//O(logn)
	public void max_heapify(int i){
		int largest = i;
		
		if(left(i) <= heapsize && input.get(i) < input.get(left(i))){
			largest = left(i);
		}
		
		if(right(i) <= heapsize && input.get(largest) < input.get(right(i))){
			largest = right(i);
		}
		
		if(largest!=i){
			int temp = input.get(i);
			input.set(i, input.get(largest));
			input.set(largest, temp);
			
			max_heapify(largest);
		}
	}
	
	//O(logn)
	public void heap_insert(int key){
		heapsize = heapsize+1;
		input.add(heapsize,Integer.MIN_VALUE);
		insert_key(key,heapsize);
	}
	
	public void insert_key(int key, int i){
		if(input.get(i) > key){
			System.out.println("Error: Key cannot be added");
		}
		
		input.set(i, key);
		while(i > 1 && input.get(i) > input.get(parent(i))){
			int temp = input.get(i);
			input.set(i, input.get(parent(i)));
			input.set(parent(i), temp);
			
			i = parent(i);
		}
	}
	
	//O(1)
	public int maximum(){
		return (input.size() > 0 ? input.get(1) : -1);
	}
	
	//O(logn)
	public int extract_maximum(){
		int max = input.get(1);
		
		int temp = input.get(1);
		input.set(1, input.get(heapsize));
		input.set(heapsize, temp);
		
		input.remove(heapsize);
		heapsize--;
		max_heapify(1);
		
		return max;
	}
	
	public void displayAll(){
		for(int i = 1; i < input.size(); ++i){
			System.out.print(input.get(i)+" ");
		}
	}
}
