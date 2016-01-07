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
		m.findLongestSubsequence(input,n);

	}
	
	public void findLongestSubsequence(int[] input, int n){
		int[] subsequence = new int[n];
		int max = 0;
		for(int i = 0; i<n; ++i){
			subsequence[i] = 1;
		}

		for(int i = 1; i<n; ++i){
			for(int j = 0; j < i; ++j){
				if(input[j] < input[i] && (subsequence[i] < subsequence[j]+1)){
					subsequence[i] = subsequence[j]+1;
				}
			}
			
			if(subsequence[i] > max){
				max = subsequence[i];			
			}
		}
		
		System.out.println("Result = "+max);
		
		
	}

}
