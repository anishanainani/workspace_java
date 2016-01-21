import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		
		printPrimeNumbers(n);

	}
	
	//O(nlog(logn)) - Sieve of Eratosthenes
	static void printPrimeNumbers(int n){
		boolean[] nums = new boolean[n+1];
		
		int i = 2;
		
		while(i*i <= n){
			if(!nums[i]){
				int k = i*i;
				
				while(k <= n){
					nums[k] = true;
					k+=i;
				}
			}
			i+=1;
		}
		
		for(int k = 2; k<=n;++k){
			if(!nums[k]){
				System.out.print(k+" ");
			}
		}
		
	}

}
