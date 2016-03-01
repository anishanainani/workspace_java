import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] A = new int[n];
        for(int i = 0; i < n; i++){
            A[i] = cin.nextInt();
        }
        
        int m = cin.nextInt();
        int[] B = new int[m];
        for(int i = 0; i < m; i++){
            B[i] = cin.nextInt();
        }
        
        Iterable<Integer> missingNumbers = getMissingNumbers(A, B);
        for(int i : missingNumbers){
            System.out.print(i+" ");
        }
    }
    
    public static Iterable<Integer> getMissingNumbers(int[] A, int[] B){
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        Arrays.sort(A);
        Arrays.sort(B);
        int i = 0, j = 0;
       
        while(i < A.length && j < B.length){
            if(A[i] == B[j]){
                i++;
                j++;
            } else {
            	if(!result.contains(B[j]))
            		result.add(B[j]);
                j++;      
            }
        }
        
        while(j < B.length){
        	if(!result.contains(B[j]))
        		result.add(B[j]);
            j++;
        }
        
        return result;
    }
}