import java.util.ArrayList;
import java.util.Scanner;


public class MinimumCubeSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int number = cin.nextInt();
		
		ArrayList<Integer> minCubeSum = getMinCubeSum(number);
		for(int i = 0; i < minCubeSum.size(); ++i){
			System.out.print(minCubeSum.get(i)+" ");
		}
	}
	
	public static ArrayList<Integer> getMinCubeSum(int number){
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		int i = (int) Math.cbrt(number);
		int temp = number;
		while(i > 0 && temp >= 0){
			while((temp-i*i*i) >= 0){
				result.add(i);
				temp-=i*i*i;
			}
			
			--i;
		}
		
		return result;
	}

}
