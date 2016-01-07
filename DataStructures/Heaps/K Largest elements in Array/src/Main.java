import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int k = cin.nextInt();
		
		int[] input = new int[n+1];
		
		for(int i=1; i<=n; ++i){
			input[i] = cin.nextInt();
		}
		
		new Main().kLargestElements(input,k);
		
		
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
	
	public void build_max_heap(int[] input,int heapsize){
		for(int i = heapsize/2; i >= 1; --i){
			max_heapify(input,i,heapsize);
		}
	}
	
	public int extract_maximum(int[] input, int heapsize){
		int max = input[1];
		
		int temp = input[1];
		input[1] = input[heapsize];
		input[heapsize] = temp;
		heapsize--;
		
		max_heapify(input,1,heapsize);
		
		return max;
	}
	
	//O(n+klogn)
	public void kLargestElements(int[] input, int k){
		int heapsize = input.length-1;
		build_max_heap(input,heapsize); //O(n)
		
		for(int i = 1; i <= k; ++i){
			System.out.println(extract_maximum(input, heapsize)); //O(logn)
			heapsize--;
		}
	}

}
