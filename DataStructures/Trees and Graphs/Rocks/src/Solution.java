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
        
        HashMap<Character,Integer> letters = new HashMap<Character,Integer>();
        for(int i = 0; i < input[0].length(); ++i){
            if(!letters.containsKey(input[0].charAt(i))){
                letters.put(input[0].charAt(i),1);
            }
        }
        
         for(int i = 1; i < T; ++i){
            for(int j = 0; j < input[i].length(); ++j){
                if(letters.containsKey(input[i].charAt(j)) && letters.get(input[i].charAt(j)) == i){  
                    letters.put(input[i].charAt(j),letters.get(input[i].charAt(j))+1);
                }
            }
        }
        
       
        int result = 0;
        Set<Character> keyset = letters.keySet();
        for(Character key : keyset){
            if(letters.get(key) == T){
                result+=1;
            }
        }
        
        System.out.print(result);
    }
}