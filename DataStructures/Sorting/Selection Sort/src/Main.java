
/*
 * In place Sorting
 * Not Stable
 * O(n^2) in all cases
 * no. of comparisons = n-1 irrespective of the input
 * better when moving data is more expensive than comparing 
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] n = {3,1,8,6,9,10,0,21,11};
		selection_sort(n);
		for(int i = 0; i < n.length;++i){
			System.out.println(n[i]);
		}

	}
	
	public static void selection_sort(int[] n){
		for(int i = 0; i < n.length-1; ++i){
			
			int min = i+1;
			for(int j = i + 1; j < n.length; ++j){
				if(n[j] < n[min]){
					min = j;
				}
			}
			
			if(n[i] > n[min]){
				int temp = n[i];
				n[i] = n[min];
				n[min] = temp;
			}
		
		}
	}

}
