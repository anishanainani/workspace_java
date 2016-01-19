import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
       Scanner cin = new Scanner(System.in);
        int T = cin.nextInt();
        int[] result = new int[T];
        
        for(int i = 0; i < T; ++i){
            String input = cin.next();
            
            int j;
            for(j = 0; j < input.length()/2;++j){
            	
                if(input.charAt(j)!=input.charAt(input.length()-j-1)){
                	int k = 0;
                	if(input.charAt(j+1)==input.charAt(input.length()-j-1))
                    {
                		 result[i] = j;
                		 k = j+2;
                		 while(k<input.length()/2 && input.charAt(k)==input.charAt(input.length()-k)){
                			 k++;
                		 }
                		 
                    }
                	
                	if(k!=input.length()/2 && input.charAt(j)==input.charAt(input.length()-j-2)){
                    	 result[i] = input.length()-j-1;
                    }
                   
                   break;
                }
            }
            
            if(j == input.length()/2 || input.length()==1){
                result[i] = -1;
            }
        }
        
        for(int j = 0; j<T;++j){
           System.out.println(result[j]);
        }
        
        cin.close();
    }
}
