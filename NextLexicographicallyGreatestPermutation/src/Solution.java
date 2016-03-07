import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int T = cin.nextInt();
        String[] result = new String[T];
        
        for(int i = 0; i < T; ++i){
        	result[i] = nextLexicographicallyGreaterPermutation(cin.next());
        }
        
        for(int i = 0; i < T; ++i){
        	System.out.println(result[i]);
        }
        
    }
    
    public static String nextLexicographicallyGreaterPermutation(String input){
        if(input == null || input.length() < 2) return "no answer";
        
        char[] inputArray = input.toCharArray();
        int N = inputArray.length;
        int nextj = 0;
        
        for(int i = N-2; i >=0; --i){
            char elem = inputArray[i];
            char nextGreater = Character.MAX_VALUE;
            int j;
            for(j = i+1; j < N; ++j){
            	if(inputArray[j] > elem && inputArray[j] < nextGreater){
            		nextGreater = inputArray[j];
            		nextj = j;
            	} 
            }
            
            if(nextGreater != Character.MAX_VALUE){
            	swap(inputArray, i, nextj);
            	Arrays.sort(inputArray, i+1, N);
            	return new String(inputArray);
            }
            
        }
        
        return "no answer";
    }
    
    public static void swap(char[] a, int i, int j){
    	if(i == j) return;
    	char swap = a[i];
    	a[i] = a[j];
    	a[j] = swap;
    }
}