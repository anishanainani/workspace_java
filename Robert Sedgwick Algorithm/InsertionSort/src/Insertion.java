/*
 * Insertion Sort : Worst and average case = O(N^2)
 * 					Best Case (number of inversions <= cN(linear)) = O(N)
 * 
 * 					Stable and inplace
 */

public class Insertion {
	public static void sort(Comparable[] a, int lo, int hi){
		for(int i = lo+1; i <= hi; ++i){
			for(int j = i; j > lo; --j){
				if(less(a[j], a[j-1])){
					exch(a, j, j-1);
				} else break;
			}
		}
	}
	public static void sort(Comparable[] a){		
		sort(a, 0, a.length-1);
	}
	
	
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
}