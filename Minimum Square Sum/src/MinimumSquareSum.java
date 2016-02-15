import java.util.ArrayList;
import java.util.Scanner;


public class MinimumSquareSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int number = cin.nextInt();
		
		ArrayList<Integer> minSquareSum = getMinSquareSum(number);
		for(int i = 0; i < minSquareSum.size(); ++i){
			System.out.print(minSquareSum.get(i)+" ");
		}
	}

	public static ArrayList<Integer> getMinSquareSum(int number){
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		int i = (int) Math.sqrt(number);
		int temp = number;
		while(i > 0 && temp >= 0){
			while((temp-i*i) >= 0){
				result.add(i);
				temp-=i*i;
			}
			
			--i;
		}
		
		return result;
	}
}
