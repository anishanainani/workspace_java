/*
 * Merge Sort : All cases O(NlogN)
 * 
 *  T(n) = 2T(n/2) + n
 *  	 = O(nlogn)
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
		int N = a.length;
		for(int sz = 1; sz < N; sz+=sz){
			for(int lo = 0; lo < N-sz; lo+=sz+sz){
				merge(a, aux, lo, (lo+sz-1), Math.min(lo+sz+sz-1, N-1));
			}
		}
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
