import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner cin =  new Scanner(System.in);
		System.out.println("Enter number of rod lengths : ");
		int n = cin.nextInt();
		
		int[] l = new int[n];
		int[] v = new int[n];
		
		for(int i = 0; i < n; ++i){
			System.out.println("Enter length "+(i+1));
			l[i] = cin.nextInt();
			System.out.println("Enter value for rod of length "+(i+1));
			v[i] = cin.nextInt();
		}
		
		int total_length;
		System.out.println("Enter total length for rod : ");
		total_length = cin.nextInt();
		
		Main m = new Main();
		m.maxProfitCuttingRod(n,l,v,total_length);

	}
	
	public void maxProfitCuttingRod(int n, int[] l, int[] v, int total_length){
		int[][] Profit = new int[n+1][total_length+1];
		for(int i = 1; i<=n; ++i){
			for(int j = 1; j<=total_length; ++j){
				if(j-l[i-1] < 0){
					Profit[i][j] = Profit[i-1][j];
				} else {
					Profit[i][j] = Math.max(v[i-1]+Profit[i][j-l[i-1]], Profit[i-1][j]);
				}
			}
		}
		
		System.out.println("Maximum possible profit = "+Profit[n-1][total_length]);
		
		findCuts(Profit,l,v);
	}

	public void findCuts(int[][] Profit, int[] l, int[] v){
		int i = Profit.length-1, j = Profit[0].length-1;
		
		while(Profit[i][j] !=0){
			if(Profit[i][j] == Profit[i-1][j]){
				
				i = i-1;
			} else {
				System.out.println("Cut"+i+j+" Value = "+v[i-1]);
				j = j-l[i-1];
			}
		}
		
		
	}
}
