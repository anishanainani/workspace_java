import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int m = cin.nextInt();
        int n = cin.nextInt();
        
        int[][] matrix = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; ++j){
                matrix[i][j] = cin.nextInt();
            }
        }
        
        int result = getLengthOfLargestRegion(matrix);
        System.out.println(result);
    }
    
    public static int getLengthOfLargestRegion(int[][] matrix){
        boolean[][] marked = new boolean[matrix.length][matrix[0].length];
        int[][] id = new int[matrix.length][matrix[0].length];
        int count = 0;
        ArrayList<Integer> size = new ArrayList<Integer>();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(!marked[i][j] && matrix[i][j] == 1){
                    size.add(0);
                    dfs(matrix, marked, id, i, j, count, size);  
                    count++;
                }
            }
        }
        
        return max(size);
    }
    
    public static int max(ArrayList<Integer> size){
        int maxsize = Integer.MIN_VALUE;
        for(int i = 0; i < size.size(); ++i){
            if(size.get(i) > maxsize){
                maxsize = size.get(i);
            }
        }
        return maxsize;
    }
    public static void dfs(int[][] matrix, boolean[][] marked,int[][] id, int i, int j, int count, ArrayList<Integer> size){
        marked[i][j] = true;
        size.set(count, size.get(count)+1);
       
       
        if(i < matrix.length && j < matrix[0].length-1 && !marked[i][j+1] && matrix[i][j+1] == 1){
            dfs(matrix, marked,id, i, j+1, count, size);
            id[i][j+1] = count;
        }
        
        if(i < matrix.length-1 && j < matrix[0].length-1 && !marked[i+1][j+1] && matrix[i+1][j+1] == 1){
            dfs(matrix, marked,id, i+1, j+1,  count, size);
            id[i+1][j+1] = count;
        }
        
        if(i < matrix.length-1 && j < matrix[0].length && !marked[i+1][j] && matrix[i+1][j] == 1){
            dfs(matrix, marked,id, i+1, j,  count, size);
            id[i+1][j] = count;
        }
        
        if(i < matrix.length && j > 0 && !marked[i][j-1] && matrix[i][j-1] == 1){
            dfs(matrix, marked,id, i, j-1, count, size);
            id[i][j-1] = count;
        }
        
        if(i > 0 && j > 0 &&!marked[i-1][j-1] && matrix[i-1][j-1] == 1){
            dfs(matrix, marked,id, i-1, j-1,  count, size);
            id[i-1][j-1] = count;
        }
        
        if(i > 0 && j < matrix[0].length && !marked[i-1][j] && matrix[i-1][j] == 1){
            dfs(matrix, marked,id, i-1, j,  count, size);
            id[i-1][j] = count;
        }
        
        if(i < matrix.length-1 && j > 0 && !marked[i+1][j-1] && matrix[i+1][j-1] == 1){
            dfs(matrix, marked,id, i+1, j-1,  count, size);
            id[i+1][j-1] = count;
        }
        
        if(i > 0 && j < matrix[0].length-1 && !marked[i-1][j+1] && matrix[i-1][j+1] == 1){
            dfs(matrix, marked,id, i-1, j+1,  count, size);
            id[i-1][j+1] = count;
        }
    }
}