import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String input1 = cin.next();
        String input2 = cin.next();
        
        if(input2.length() == 0){
            System.out.print(input1.length());
        }
        else{
            HashMap<Character,Integer> lettersInInput1 = new HashMap<Character,Integer>();
        
            for(int i = 0; i < input1.length(); ++i){
                if(lettersInInput1.containsKey(input1.charAt(i))){
                    int count = lettersInInput1.get(input1.charAt(i));
                    lettersInInput1.put(input1.charAt(i),count+1);
                } else {
                    lettersInInput1.put(input1.charAt(i),1);
                }
            }
        
            int result2 = 0;
            for(int i = 0; i < input2.length(); ++i){
                if(lettersInInput1.containsKey(input2.charAt(i))){
                    int count = lettersInInput1.get(input2.charAt(i));
                    if(count == 0){
                    	result2 += 1;
                    } else {
                    	lettersInInput1.put(input2.charAt(i),count-1);
                    }
                    
                } else {
                	result2 += 1;
                }
            }
        
            Set<Character> keys = lettersInInput1.keySet();
            int result1 = 0;
            for(char c : keys){
                if(lettersInInput1.get(c) > 0){
                    result1 += lettersInInput1.get(c);
                }
            }
        
            System.out.print((result1 + result2));
        }
        
    }
}