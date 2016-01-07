/*
 * Not stable
 * In Place
 * worst case O(n^2) when unbalanced partition occurs
 * best case and average case O(n) - balanced partition
 * 
 * If the data is already sorted and we take last element as pivot its O(n^2) but if we take middle element as pivot it is O(nlogn)
 */

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		int[] n = {3,1,7,4,6};
		optimized_quick_sort(n,0,n.length-1);
		for(int i = 0; i < n.length; ++i){
			System.out.println(n[i]);
		}
	}
	
	public static void quick_sort(int[] n, int p, int r){
		if(p<r){
			int q= Partition(n,p,r);
			quick_sort(n,p,q-1);
			quick_sort(n,q+1,r);
		}
	}

	public static int Partition(int[] n, int p, int r){
		int pivot = n[r];
		int i = p-1;
		for(int j = p; j <r; ++j){
			if(n[j] <= pivot){
				++i;
				int temp = n[i];
				n[i] = n[j];
				n[j] = temp;
			}
		}
		int temp = n[i+1];
		n[i+1] = n[r];
		n[r] = temp;
		return i+1;
	}
	
	public static void optimized_quick_sort(int[] n, int p, int r){
		
		int piv = (p+r)/2;
		int pivot = n[piv];
		int i = p, j = r;
		
		while(i <= j){
			while(n[i] < pivot) ++i;
			while(n[j] > pivot) --j;
			
			if(i <= j){
				int temp = n[i];
				n[i] = n[j];
				n[j] = temp;
				++i;
				--j;
			}
		}
		
		
		if(p < j){
			optimized_quick_sort(n, p, j);
		} 
		if(i < r){
			optimized_quick_sort(n, i,r);
		}
	}

}
