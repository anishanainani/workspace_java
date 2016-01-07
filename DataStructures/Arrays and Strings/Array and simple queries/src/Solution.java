import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static long[] input;
    
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
        reverse(i, input.length);
        reverse(i,i+input.length-j-1);
        reverse(1,input.length-(j-i+1));
        reverse(1,input.length);
        
    }
    
    public static void type2(int i, int j){
        reverse(i, j);
        reverse(j+1,input.length);
        reverse(i,input.length);
        
    }
    
    public static void reverse(int i, int j){
        int l = j-i+1;
        for(int k = i; k<i+l/2; ++k){
            long temp = input[k-1];
            input[k-1] = input[j-1];
            input[j-1] = temp;
            j--;
        }
    }
}