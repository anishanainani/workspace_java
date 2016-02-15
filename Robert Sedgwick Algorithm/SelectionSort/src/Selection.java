/*
 * Selection sort all cases = O(N^2)
 * Number of exchanges = N-1
 * 
 * Not stable and inplace
 * Ex: B1, B2, A
 * 1st pass A, B2, B1
 */
public class Selection {
	public static void sort(Comparable[] a){
		int min = 0;
		
		for(int i = 0; i < a.length; ++i){
			min = i;
			for(int j = i+1; j < a.length; ++j){
				if(less(a[j], a[min])){
					min = j;
				}
			}
			exch(a, i, min);
		}
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
