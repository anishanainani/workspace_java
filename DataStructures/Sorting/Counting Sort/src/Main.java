
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input = {4,2,8,1,0,6,7};
		int[] result = new int[input.length];
		
		countingSort(input, result, 8);
		
		for(int i = 0; i < result.length; ++i){
			System.out.println(result[i]);
		}
	}
	
	public static void countingSort(int[] input, int[] result, int k){
		int[] C = new int[k+1];
		
		for(int i = 0; i < input.length; ++i){
			C[input[i]]++;
		}
		
		for(int i = 1; i <= k; ++i){
			C[i] = C[i] + C[i-1];
		}
		
		for(int i = input.length-1; i >= 0; --i){
			result[C[input[i]]-1] = input[i];
			
			C[input[i]]--;
		}
	}

}
