
import java.util.*;

class Solution {
	
	public static void main(String[] args){
		
		//String input = "dir1\n dir11\n dir12\n  dir121\n   picture1.jpeg\n   image1.png\n dir13\n  picture2.jpeg\ndir2\n picture3.jpeg";
		String input = "dir1";
		
		System.out.println("Input : ");
		System.out.println(input);
		
		Solution mySolution = new Solution();
		System.out.println("Output : ");
		
		int maxCharPathLength = mySolution.solution(input);
		if(maxCharPathLength == Integer.MIN_VALUE){
			maxCharPathLength = 0;
		}
		System.out.println("Maximum Character Path Length : "+maxCharPathLength);
	}
	
    public int solution(String X) {
    	String[] dirs = X.split("\n");
    	
    	Tree directoryTree = new Tree();
        return directoryTree.getMaxCharPathLength(dirs);
    }
    
    class Tree{
    	Node root;
    	int maxCharPathLength;
    	ArrayList<String> maxPath;
    	
    	Tree(){
    		Node n = new Node();
    		n.content = "/";
    		root = n;
    		maxCharPathLength = Integer.MIN_VALUE;
    		maxPath = new ArrayList<String>();
    	}
    	
    	public int getMaxCharPathLength(String[] dirs){
    		buildTreeWrapper(dirs);
    		findMaxCharPath(root, 0, new ArrayList<String>());
    	   	printMaxPath();
    		return maxCharPathLength;
    	}
    	
    	public void buildTreeWrapper(String[] dirs){
    		buildTree(root, dirs, 0, 0);
    	}
    	
    	public void buildTree(Node root, String[] dirs,int i, int countSpaces){
    		
    		if(i == dirs.length){
    			return;
    		}
    		
    		String content = dirs[i].trim();
    		int spaces = dirs[i].length() - content.length();
    		
    		if(spaces == countSpaces){
    			Node newNode = new Node();
    			newNode.content = content;
    			newNode.parent = root;
    			root.children.add(newNode);
    			
    			//Moving forward in the array with same node
    			buildTree(root, dirs, i+1, countSpaces);
    		} else if(spaces > countSpaces){
    			//Moving to the last added child to insert the current element
    			buildTree(root.children.get(root.numChildren()-1), dirs, i, countSpaces+1);
    		} else {
    			//Backtracking until node's parent is reached
    			buildTree(root.parent, dirs, i, countSpaces-1);
    		}	
    	}
    	
    	public void findMaxCharPath(Node root, int pathLength, ArrayList<String> path){
    		if(root.numChildren() == 0){
    			if(root.content.contains(".")){
    				pathLength = pathLength+root.content.length() + path.size();
        			if(pathLength > maxCharPathLength){
        				maxCharPathLength = pathLength;
        				maxPath = new ArrayList<String>(path);
        			}
    			}
    			path.remove(path.size()-1);
    			return;
    		}
    		
    		for(int i = 0; i < root.numChildren(); ++i){
    			Node child = root.children.get(i);
    			path.add(child.content);
    			findMaxCharPath(child, pathLength+root.content.length(), path);
    		}
    		
    	}
    	
    	public void printMaxPath(){
    		
    		if(maxPath.size() == 0){
    			System.out.println("No Path Found.");
    			return;
    		}
    		
    		StringBuilder maxP = new StringBuilder();
        	for(int i = 0; i < maxPath.size(); ++i){
        		maxP.append("/");
        		maxP.append(maxPath.get(i));
        	}
        	
        	System.out.println("Maximum Character Path : " +maxP);
    	}
    }
    
    class Node{
    	String content;
    	ArrayList<Node> children;
    	Node parent;
    	
    	Node(){
    		children = new ArrayList<Node>();
    		parent = null;
    	}
    	
    	public int numChildren(){
    		return children.size();
    	}
    }
}