import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        
        int T = cin.nextInt();
        long[] result = new long[T];
        
        for(int i = 0; i < T; ++i){
            int N  = cin.nextInt();
            int[] input = new int[N];
            for(int j = 0; j < N; ++j){
                input[j] = cin.nextInt();
            }
            
            result[i] = findAllIndices(input);
        }
        
        for(int i = 0; i < T; ++i){
            System.out.println(result[i]);
        }
    }
    
    public static long findAllIndices(int[] input){
        long result = 0;
        HashMap<Integer, Long> map = new HashMap<Integer, Long>();
        
        for(int i = 0; i < input.length; ++i){
            if(map.containsKey(input[i])){
                map.put(input[i], map.get(input[i])+1);
            } else {
                map.put(input[i], (long) 1);
            }
        }
        
        Iterator<Integer> i = map.keySet().iterator();
        
        while(i.hasNext()){
            int elem = i.next();
            long count = map.get(elem);
            if(count > 1){
                result+=((count)*(count-1));
            }
        }
        
        return result;
    }

   
}