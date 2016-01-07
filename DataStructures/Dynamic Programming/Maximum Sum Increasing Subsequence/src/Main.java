import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner cin =  new Scanner(System.in);
		System.out.println("Enter length of input array : ");
		int n = cin.nextInt();
		
		int[] input = new int[n];
		
		for(int i = 0; i < n; ++i){
			input[i] = cin.nextInt();
		}
		
		
		Main m = new Main();
		m.findLongestSubsequenceSum(input,n);

	}
	
	public void findLongestSubsequenceSum(int[] input, int n){
		int[] subsequence = new int[n];
		int[] index = new int[n];
		int max = 0,maxi = 0;
		for(int i = 0; i<n; ++i){
			subsequence[i] = input[i];
			index[i] = i;
		}

		for(int i = 1; i<n; ++i){
			for(int j = 0; j < i; ++j){
				if(input[j] < input[i] && (subsequence[i] < subsequence[j]+input[i])){
					subsequence[i] = subsequence[j]+input[i];
					index[i] = j;
				}
			}
			
			if(subsequence[i] > max){
				max = subsequence[i];
				maxi = i;
			}
		}
		
		System.out.println("Result = "+max);
		
		int k = maxi;
		while(true){
			
			System.out.print(input[k]+" ");

			if(index[k] == k){
				break;
			}
			k = index[k];
			
		}
		
	}

}
