import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SumOfDiagonals {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[][] matrix = new int[n][n];
        
        for(int i = 0; i < n; ++i){
        	for(int j =0; j<n; ++j){
        		matrix[i][j] = cin.nextInt();
        	}
        }
        
        int result = 0;
        for(int i =0; i<n; ++i){
        	if(i==n/2){}
        	result+=matrix[i][i]-matrix[i][n-1-i];
        }
        
        System.out.println(Math.abs(result));
        
    }
}
