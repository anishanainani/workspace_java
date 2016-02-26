import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class BST<Key extends Comparable<Key>, Value> {
	private Node root;
	
	private class Node{
		Key key;
		Value value;
		Node left, right;
		int count;
		
		public Node(Key key, Value value){
			this.key = key;
			this.value = value;
			count = 1;
		}
	}
	
	public int size(){
		return size(root);
	}
	
	public int size(Node x){
		if(x == null) return 0;
		
		return x.count;
	}
	
	public boolean isEmpty(){
		return size()==0;
	}
	
	public boolean contains(Key key){
		if(key == null) throw new NullPointerException("argument to contains() is null");
		
		return get(key)!=null;
	}
	
	public void put(Key key, Value value){
		root = put(root, key, value);
	}
	
	public Node put(Node x, Key key, Value value){
		if(x == null) return new Node(key, value);
		
		int cmp = key.compareTo(x.key);
		if(cmp < 0) x.left = put(x.left, key, value);
		else if(cmp > 0) x.right = put(x.right, key, value);
		else x.value = value;
		x.count = 1 + size(x.left) + size(x.right);
		return x;
	}
	
	public Value get(Key key){
		
		Node x = root;
		while(x!=null){
			int cmp = key.compareTo(x.key);
			if(cmp < 0) x = x.left;
			else if(cmp > 0) x = x.right;
			else return x.value;
		}
		
		return null;
	}
	
	public void delete(Key key){
		if(key == null){
			throw new NullPointerException("Argument to delete is null");
		}
		
		root = delete(root, key);
	}
	
	public Node delete(Node x, Key key){
		if(x == null) return null;
		
		int cmp = key.compareTo(x.key);
		if(cmp < 0) x.left = delete(x.left, key);
		else if(cmp > 0) x.right = delete(x.right, key);
		else {
			
			//node to delete has 1 child
			if(x.right == null) return x.left;
			
			Node t = x;
			x = min(x.right);
			x.left = t.left;
			x.right = deleteMin(t.right);
		}
		
		x.count = 1+size(x.left)+size(x.right);
		 return x;
	}
	
	public Iterator<Key> iterate(){
		ArrayList<Key> keys = new ArrayList<Key>();
		inorder(root, keys);
		return keys.iterator();
	}
	
	public void inorder(Node x, ArrayList<Key> keys){
		if(x == null) return;
		inorder(x.left, keys);
		keys.add(x.key);
		inorder(x.right, keys);
	}
	
	public Key floor(Key key){
		Node x = floor(root, key);
		if(x==null) return null;
		
		return x.key;
	}
	
	public Node floor(Node x, Key key){
		if(x == null) return null;
		
		int cmp = key.compareTo(key);
		if(cmp == 0) return x;
		
		if(cmp < 0) return floor(x.left, key);
		
		Node t = floor(x.right, key);
		if(t != null) return t;
		else return x;
	
	}
	
	public Key ceiling(Key key){
		if (key == null) throw new NullPointerException("argument to ceiling() is null");
        if (isEmpty()) throw new NoSuchElementException("called ceiling() with empty symbol table");
        
		Node x = ceiling(root, key);
		if(x==null) return null;
		
		return x.key;
	}
	
	public Node ceiling(Node x, Key key){
		if(x == null) return null;
		
		int cmp = key.compareTo(x.key);
		if(cmp == 0) return x;
		
		if(cmp > 0) return ceiling(x.right, key);
		
		Node t = ceiling(x.left, key);
		if(t != null) return t;
		else return x;
	
	}
	
	public Key select(int k){
		if (k < 0 || k >= size()) throw new IllegalArgumentException();
		
		Node x = select(root, k);
		assert x!=null;
		return x.key;
	}
	
	public Node select(Node x, int k){
		if(x == null) return null;
		
		int t = size(x.left);
		if(t > k) return select(x.left, k);
		else if(t < k) return select(x.right, k-t-1);
		else return x;
	}
	
	//How many keys < k?
	public int rank(Key key){
		return rank(root, key);
	}
	
	public int rank(Node x, Key key){
		
		if(x == null) return 0;
		int cmp = key.compareTo(x.key);
		
		if(cmp == 0) return size(x);
		else if(cmp < 0) return rank(x.left, key);
		else return 1+size(x.left)+rank(x.right, key);
	}
	
	public void deleteMin(){
		root = deleteMin(root);
	}
	
	public Node deleteMin(Node x){
		if(x == null) return x;
		if(x.left == null) return x.right;
		x.left = deleteMin(x.left);
		x.count = 1 + size(x.left)+ size(x.right);
		
		return x;
	}
	
	public void deleteMax(){
		root = deleteMax(root);
	}
	
	public Node deleteMax(Node x){
		if(x == null) return x;
		if(x.right == null) return x.left;
		x.right = deleteMax(x.right);
		x.count = 1 + size(x.left)+ size(x.right);
		
		return x;
	}
	
	public Key min(){
		if (isEmpty()) throw new NoSuchElementException("called max() with empty symbol table");
		return min(root).key;
	}
	
	public Node min(Node x){
		if(x.left == null) return x;
		
		return min(x.left);
	}
	
	public Key max(){
		if (isEmpty()) throw new NoSuchElementException("called max() with empty symbol table");
		return max(root).key;
	}
	
	public Node max(Node x){
		if(x.right == null) return x;
		
		return max(x.right);
	}
}
