import java.util.Arrays;
import java.util.Collections;
import java.util.Random;


public class Quick3Way {
	public static boolean less(Comparable a, Comparable b){
		return (a.compareTo(b) < 0);
	}
	
	public static void exch(Comparable[] a, int i, int j){
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	
	public static void sort(Comparable[] a){
		Collections.shuffle(Arrays.asList(a));
		sort(a, 0, a.length-1);
		assert isSorted(a);
	}
	
	public static void sort(Comparable[] a, int lo, int hi){
		if(hi <= lo) return;
		
		int lt = lo, i = lo+1, gt = hi;
		Comparable v = a[lt];
		
		while(i <= gt){
			int cmp = a[i].compareTo(v);
			if(cmp < 0) exch(a, lt++, i++);
			else if(cmp > 0) exch(a, i, gt--);
			else if(cmp == 0) i++;
		}
		
		sort(a, lo, lt-1);
		sort(a, gt+1, hi);
		assert isSorted(a, lo, hi);
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
