import java.util.Comparator;

/*
 * Insertion Sort : Worst and average case = O(N^2)
 * 					Best Case (number of inversions <= cN(linear)) = O(N)
 */

public class Insertion {
	public static void sort(Object[] a, int lo, int hi, Comparator c){
		for(int i = lo+1; i <= hi; ++i){
			for(int j = i; j > lo; --j){
				if(less(c,a[j], a[j-1])){
					exch(a, j, j-1);
				} else break;
			}
		}
	}
	public static void sort(Object[] a, Comparator c){		
		sort(a, 0, a.length-1, c);
	}
	
	
	public static boolean less(Comparator c, Object a, Object b){
		return (c.compare(a,b) < 0);
	}
	
	public static void exch(Object[] a, int i, int j){
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	
	public static boolean isSorted(Object[] a, Comparator c){
		return isSorted(a, 0, a.length-1, c);
	}
	
	public static boolean isSorted(Object[] a, int lo, int hi, Comparator c){
		for(int i = lo; i <= hi; ++i){
			if(less(c, a[i], a[i-1])) return false;
		}
		return true;
	}
	
}