import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        
        int T = cin.nextInt();
        String[] input = new String[T];
        
        for(int i = 0; i < T; ++i){
            input[i] = cin.next();
        }
        
        for(int i = 0; i < T; ++i){
            if(input[i].length()%2 !=0){
                System.out.println("-1");
                continue;
            }
            
            String S1 = input[i].substring(0,input[i].length()/2);
            String S2 = input[i].substring(input[i].length()/2);
            
            HashMap<Character,Integer> letters = new HashMap<Character,Integer>();
            for(int j = 0; j < S1.length(); ++j){
                if(!letters.containsKey(S1.charAt(j))){
                    letters.put(S1.charAt(j), 1);
                } else {
                    letters.put(S1.charAt(j), letters.get(S1.charAt(j))+1);
                }
            }
            
            for(int j = 0; j < S2.length(); ++j){
                if(!letters.containsKey(S2.charAt(j))){
                  
                } else {
                    letters.put(S2.charAt(j), letters.get(S2.charAt(j))-1);
                }
            }
            
            int result = 0;
            Set<Character> keyset = letters.keySet();
            for(Character key : keyset){
                if(letters.get(key) > 0){
                    result+=letters.get(key);
                }
             }
            
            System.out.println(result);
         
        }
    }
}