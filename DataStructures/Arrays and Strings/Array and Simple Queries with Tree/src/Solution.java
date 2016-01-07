import java.util.Scanner;


public class Solution {

	static long[] input;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
        int N = cin.nextInt();
        int M = cin.nextInt();
        
        input = new long[N];
        for(int i = 0; i < N; ++i){
            input[i] = cin.nextLong();
        }
        
        int[][] queries = new int[M][3];
        
        for(int i = 0; i<M; ++i){
            for(int j = 0; j<3; ++j){
                queries[i][j] = cin.nextInt();
            }
            
            if(queries[i][0] == 1){
            	type1(queries[i][1], queries[i][2]);
            } else {
            	type2(queries[i][1], queries[i][2]);
            }
        }
        
       
        System.out.println((input[0]-input[input.length-1]));
        
        for(int i = 0; i < N; ++i){
            System.out.print(input[i]+" ");
        }
      
        cin.close();

	}
	
	public static void type1(int i, int j){
		int k;int ti = i-1;
	       for(k = 0; k < (j-i+1); ++k){   
	                long temp = input[k];
	                input[k] = input[ti];
	                input[ti] = temp;
	                ++ti;
	       }
	     
	        int p = k;
	       while(p < ti-1){
	           int l;
	           int ii = ti;
	           for(l = p; l < p+input.length-ti; ++l){
	                long temp = input[l];
	                input[l] = input[ii-1];
	                input[ii-1] = temp;
	               ++ii;
	           }
	           p = l;
	       }
		
	}
	
	public static void type2(int i, int j){
		int k;int ti = i;
	       for(k = j; k < input.length; ++k){   
	                long temp = input[k];
	                input[k] = input[ti-1];
	                input[ti-1] = temp;
	                ++ti;
	       }
	      
	       int p = ti   ;
	       while(p < j-1){
	           int l;
	           int ii = j;
	           for(l = p; l < p+input.length-j; ++l){
	                long temp = input[l-1];
	                input[l-1] = input[ii];
	                input[ii] = temp;
	               ++ii;
	           }
	           p = l;
	       }
	}

}
