import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int number = cin.nextInt();
		if(isPrime(number)){
			System.out.println("This is a prime number.");
		} else {
			System.out.println("This is not a prime number.");
		}

	}
	
	//O(sqrt(n))
	static boolean isPrime(int number){
		if(number < 2) return false;
		
		if(number == 2) return true;
		
		if(number % 2 == 0) return false;
		
		for(int i=3; (i*i)<=number; i+=2){
		    if(number % i == 0 ) return false;
		}
		
		return true;
	}

}
