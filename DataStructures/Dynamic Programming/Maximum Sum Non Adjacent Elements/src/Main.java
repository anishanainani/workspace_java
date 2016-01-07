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
		m.maxSum(input,n);
		cin.close();

	}
	
	public void maxSum(int[] input, int n){
		int inclusive = input[0], exclusive = 0;
		
		for(int i = 1; i < n; ++i){
			int temp = inclusive;
			inclusive = Math.max(exclusive+input[i], inclusive);
			exclusive = temp;
		}
		
		System.out.println(inclusive);
		
	}

	
}
