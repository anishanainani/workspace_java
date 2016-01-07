import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        
        int N =cin.nextInt();
        
        int[][] input = new int[N][2];
        for(int i = 0; i < N; ++i){
            input[i][0] = cin.nextInt();
            input[i][1] = cin.nextInt();
        }
        
        int T = cin.nextInt();
        int[] swaps = new int[T];
        for(int i = 0; i < T; ++i){
            swaps[i] = cin.nextInt();
        }
        
        BTree bt = new BTree();              
        bt.buildTree(input,null,0);
        //bt.inorder(bt.root);
        
        for(int i = 0; i < T; ++i){
             bt.swapSubtrees(swaps[i]);
             bt.inorder(bt.root);
             if(i!=T-1)
                System.out.println();
            
        }
           
        bt.top_view(bt.root);
        cin.close();
    }
    
    static class Node{
        int data;
        Node left;
        Node right;
    }
    
    static class BTree{
        Node root;
        
        BTree(){
            root = null;
        }
        
        public void buildTree(int[][] input, Node elem, int i){
            
            if(root==null){
                 Node node = new Node();
                 node.data = 1;
                 root = node;
                 buildTree(input,root,0);
            } else {
            
                 if(input[i][0] == -1){
                    elem.left = null;
                 }else {
                    Node node = new Node();
                    node.data = input[i][0];
                    elem.left = node;
                    buildTree(input,elem.left,input[i][0]-1);
                 }
                
                 if(input[i][1] == -1){
                    elem.right = null;
                 }else {
                    Node node = new Node();
                    node.data = input[i][1];
                    elem.right = node;
                    buildTree(input,elem.right,input[i][1]-1);
                 }
            }
        }
        
        public void swapSubtrees(int levels){
            ArrayList<Node> queue = new ArrayList<Node>();
            ArrayList<Node> childQueue = new ArrayList<Node>();
            queue.add(root);
            int l = 1;
            int i = 1;
            while(!queue.isEmpty()){
           
            	if(i==l*levels){
                	 for(int j = 0; j < queue.size(); ++j){
                         Node temp = queue.get(j).left;
                         queue.get(j).left = queue.get(j).right;
                         queue.get(j).right = temp;
                         
                     }
                	 ++l;
                }
                while(!queue.isEmpty()){
                    Node elem = queue.get(0);
                    queue.remove(0);
                    if(elem.left!=null){
                       childQueue.add(elem.left);
                     }
               
                     if(elem.right!=null){
                        childQueue.add(elem.right);
                     }
                }
                queue = (ArrayList<Node>) childQueue.clone();
                childQueue.clear();
                
                
               
                
                ++i;
                
            }
            
         
           
        }
        
        public void inorder(Node n){
            if(n==null){
                return;
            }
            
            inorder(n.left);
            System.out.print(n.data+" ");
            inorder(n.right);
        }
        
        void top_view(Node root)
        {
            Node elem = root;
            ArrayList<Integer> buffer = new ArrayList<Integer>();
            
            while(elem!=null){
                buffer.add(elem.data);
                elem = elem.left;
            }
            
            for(int i= buffer.size()-1; i >=0; --i){
                System.out.println(buffer.get(i)+" ");  
            }
            
            buffer.clear();
         
            elem = root.right;
            
            while(elem!=null){
                buffer.add(elem.data);
                elem = elem.right;
            }
            
            for(int i= 0; i <buffer.size(); ++i){
                System.out.println(buffer.get(i)+" ");
            }
            
            
            
        }
           
    }
}