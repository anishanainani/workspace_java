import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner cin =  new Scanner(System.in);
		System.out.println("Enter number of items : ");
		int n = cin.nextInt();
		
		int[] w = new int[n];
		int[] v = new int[n];
		
		for(int i = 0; i < n; ++i){
			System.out.println("Enter weight for item "+(i+1));
			w[i] = cin.nextInt();
			System.out.println("Enter value for item "+(i+1));
			v[i] = cin.nextInt();
		}
		
		int total_weight;
		System.out.println("Enter total weight for knapsack : ");
		total_weight = cin.nextInt();
		
		Main m = new Main();
		m.knapsack(n,w,v,total_weight);

	}
	
	public void knapsack(int n, int[] w, int[] v, int total_weight){
		int[][] Cost = new int[n+1][total_weight+1];
		for(int i = 1; i<=n; ++i){
			for(int j = 1; j<=total_weight; ++j){
				if(j-w[i-1] < 0){
					Cost[i][j] = Cost[i-1][j];
				} else {
					Cost[i][j] = Math.max(v[i-1]+Cost[i-1][j-w[i-1]], Cost[i-1][j]);
				}
			}
		}
		
		System.out.println("Maximum possible value = "+Cost[n-1][total_weight]);
		
		findItems(Cost,w,v);
	}

	public void findItems(int[][] Cost, int[] w, int[] v){
		int i = Cost.length-1, j = Cost[0].length-1;
		
		while(Cost[i][j] !=0){
			if(Cost[i][j] == Cost[i-1][j]){
				
				i = i-1;
			} else {
				System.out.println("item"+i+" Value = "+v[i-1]);
				j = j-w[i-1];
				i = i-1;
			}
		}
		
		
	}
}
