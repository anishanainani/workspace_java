import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		
		int[] input = new int[n+1];
		
		for(int i=1; i<=n; ++i){
			input[i] = cin.nextInt();
		}
		
		new Main().heap_sort(input);
		
		for(int i=1; i<=n; ++i){
			System.out.println(input[i]);
		}
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
	public void max_heapify(int[] input,int i,int heapsize){
		int largest = i;
		
		if(left(i) <= heapsize && input[i] < input[left(i)]){
			largest = left(i);
		}
		
		if(right(i) <= heapsize && input[largest] < input[right(i)]){
			largest = right(i);
		}
		
		if(largest!=i){
			int temp = input[i];
			input[i] = input[largest];
			input[largest] = temp;
			
			max_heapify(input,largest,heapsize);
		}
	}
	
	//O(n)
	public void build_max_heap(int[] input,int heapsize){
		for(int i = heapsize/2; i >= 1; --i){
			max_heapify(input,i,heapsize);
		}
	}
	
	//O(nlogn)
	public void heap_sort(int[] input){
		int heapsize = input.length-1;
		build_max_heap(input,heapsize);
		
		for(int i = heapsize; i >= 2; --i){
			int temp = input[1];
			input[1] = input[i];
			input[i] = temp;
			heapsize--;
			
			max_heapify(input,1,heapsize);
		}
	}

}
