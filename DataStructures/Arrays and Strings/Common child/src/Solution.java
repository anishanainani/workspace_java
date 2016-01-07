import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        
        String i1 = cin.next();
        String i2 = cin.next();
        
        int[][] subsequence = new int[i1.length()+1][i2.length()+1];
        
        for(int i = 1; i < i1.length()+1; ++i){
            for(int j = 1; j < i2.length()+1;++j){
                if(i1.charAt(i-1) == i2.charAt(j-1)){
                    subsequence[i][j] = subsequence[i-1][j-1] + 1;
                } else {
                    subsequence[i][j] = Math.max(subsequence[i][j-1], subsequence[i-1][j]);
                }
            }
        }
        
        System.out.print(subsequence[i1.length()][i2.length()]);
    }
}