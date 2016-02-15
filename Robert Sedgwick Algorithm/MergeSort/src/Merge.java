/*
 * Merge Sort : All cases O(NlogN)
 * 
 *  T(n) = 2T(n/2) + n
 *  	 = O(nlogn)
 *  
 *  Stable and not inplace
 */

public class Merge {
	public static boolean less(Comparable a, Comparable b){
		return (a.compareTo(b) < 0);
	}
	
	public static void exch(Comparable[] a, int i, int j){
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	
	public static boolean isSorted(Comparable[] a){
		return isSorted(a, 0, a.length-1);
	}
	
	public static boolean isSorted(Comparable[] a, int lo, int hi){
		for(int i = lo; i <= hi; ++i){
			if(less(a[i], a[i-1])) return false;
		}
		return true;
	}
	
	public static void show(Comparable[] a){
		for(int i = 0; i < a.length; ++i){
			System.out.println(a[i]);
		}
	}
	
	public static void sort(Comparable[] a){
		Comparable[] aux = new Comparable[a.length];
		sort(a, aux, 0, a.length-1, 10);
	}
	
	public static void sort(Comparable[] a, Comparable[] aux, int lo, int hi, int CUTOFF){
		
		//If size of the array is equal to CUTOFF
		if(hi <= lo + CUTOFF - 1){
			Insertion.sort(a, lo, hi);
			return;
		}
		
		int mid = (hi+lo)/2;
		sort(a, aux, lo, mid, CUTOFF);
		sort(a, aux, mid+1, hi, CUTOFF);
		
		//If the array is already sorted
		if(less(a[mid], a[mid+1])) return;
		
		merge(a, aux, lo, mid, hi);
	}
	
	public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
		assert isSorted(a, lo, mid);
		assert isSorted(a, mid+1, hi);
		
		for(int i = lo; i <= hi; ++i){
			aux[i] = a[i];
		}
		
		int i = lo, j = mid+1;
		for(int k = lo; k <= hi; ++k){
			if(i > mid) a[k] = aux[j++];
			else if(j > hi) a[k] = aux[i++];
			else if(less(aux[j], aux[i])) a[k] = aux[j++];
			else a[k] = aux[i++];
		}
		
		assert isSorted(a, lo, hi);
	}
}
