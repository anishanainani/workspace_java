import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int N = cin.nextInt();
        
        int[] heights = new int[N];
        
        for(int i = 0; i < N; ++i){
            heights[i] = cin.nextInt();
        }
        
        int maxarea = -200;
        
        for(int i = 0; i < N; ++i){
            int min = heights[i];
            int k = 1;
            for(int j = i; j < N; ++j){
           
                if(min > heights[j]){
                    min = heights[j];
                }
                
                int area = min*k;
                k++;
                if(area > maxarea){
                    maxarea = area;
                }
            }
        }
        
        System.out.println(maxarea);
    }
}