
/*
 * In Place
 * Stable
 * O(n) in best case (already sorted) O(n^2) otherwise
 * Best when data is to be added in pre-sorted array or list
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] n = {3,1,7,4,6};
		insertion_sort1(n);
		for(int i = 0; i < n.length; ++i){
			System.out.println(n[i]);
		}
	}
	
	public static void insertion_sort(int[] n){
		for(int which=1; which < n.length;++which){
			int val = n[which];
			for(int j = 0; j < which; ++j){
				if(n[j] > val){
					System.arraycopy(n, j, n, j+1, which-j);
					n[j] = val;
					break;
				}
			}
		}
	}

	public static void insertion_sort1(int[] n){
		for(int which=1; which < n.length;++which){
			int val = n[which];
			int i = which-1;
			while(i>=0 && n[i]>val){
				n[i+1] = n[i];
				--i;
			}
			n[i+1] = val;
		}
	}

}
