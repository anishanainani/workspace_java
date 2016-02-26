/*
 * Shell Sort :Depends upon the sequence of the hs
 * We start from bigger h which sort the array so as h decrements the array gets almost sorted
 * and it improves the performance
 * 
 * Worst case is O(N^3/2) when increment sequence is (3x+1)
 * 
 */

public class Shell {
	public static void sort(Comparable[] a){		
		int N = a.length;
		
		int h = 1;
		while(h < N/3) h = 3*h+1;
		
		while(h >= 1){
			for(int i = h; i < a.length; ++i){
				for(int j = i; j >=h; j-=h){
					if(less(a[j], a[j-h])){
						exch(a, j, j-h);
					}
				}
			}
			
			h = h/3;
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