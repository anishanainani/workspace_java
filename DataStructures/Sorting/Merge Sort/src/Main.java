
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] n = {3,1,1,7,1,4,6,7};
		merge_sort(n,0,n.length-1);
		for(int i = 0; i < n.length; ++i){
			System.out.println(n[i]);
		}

	}
	
	public static void merge_sort(int[] n, int p, int r){
		if(p<r){
			int mid = (p+r)/2;
			merge_sort(n, p, mid);
			merge_sort(n, mid+1, r);
			merge(n, p, mid, r);
		}
	}

	public static void merge(int[] n, int p, int q, int r){
		int leftn = q-p+1;
		int rightn = r-q;
		int[] left = new int[leftn];
		int[] right = new int[rightn];
		int k = 0;
		for(int i = p; i <= q; ++i){
			left[k++] = n[i];
		}
		k=0;
		for(int i = q+1; i <= r; ++i){
			right[k++] = n[i];
		}
		
		int i = 0, j = 0;
		k = p;
		while(i < leftn && j < rightn){
			if(left[i] < right[j]){
				n[k++] = left[i++];
			} else {
				n[k++] = right[j++];
			}
		}
		while(i < leftn){
			n[k++] = left[i++];
		}
		while(j <rightn){
			n[k++] = right[j++];
		}

	}

}
