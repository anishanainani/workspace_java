
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Fibonacci(5));
	}
	
	public static int Fibonacci(int n){
		
		if(n == 1) return 0;
		if(n==2) return 1;
		int sum =Fibonacci(n-1)+Fibonacci(n-2);

		return sum;
	}


}
