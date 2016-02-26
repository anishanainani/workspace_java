import java.util.ArrayList;


//Space (R+1)N
public class RwayTrie {
	private Node root;
	private int R;
	
	private class Node{
		private Object value;
		private Node[] next;
		
		public Node(){
			next = new Node[R];
		}
	}
	
	public RwayTrie(int R){
		this.R = R;
	}
	
	//O(L)
	public void insert(String key, int i){
		root = insert(root, key, 0, i);
	}
	
	public Node insert(Node x, String key, int d, int i){
		if(x == null) x = new Node();
		if(d == key.length()) {
			x.value = (Integer)i;
			return x;
		}
		
		char c = key.charAt(d);
		x.next[c] = insert(x.next[c], key, d+1, i);
		
		return x;
	}
	
	// Search hit O(L) Search miss = O(logN base R) 
	public int search(String key){
		if(key == null) throw new NullPointerException("argument to search() is null");
		
		Node x = search(root, key, 0);
		return x!=null ? (Integer)x.value : -1;
	}
	
	public Node search(Node x, String key, int d){
		if(x == null) return null;
		if(d == key.length()) {
			return x;
		}
		
		int c = key.charAt(d);
		return search(x.next[c], key, d+1);
	}
	
	public void delete(String key){
		root = delete(root, key, 0);
	}
	
	public Node delete(Node x, String key, int d){
		if(x == null) return null;
		if(d == key.length()){
			x.value = null;
		} else {
			int c = key.charAt(d);
			x.next[c] = delete(x.next[c], key, d+1);
		}
		
		for(int i = 0; i < R; ++i){
			if(x.next[i] != null){
				return x;
			}
		}
		
		return null;
	}
	
	public boolean isEmpty(){
		return root == null;
	}
	
	public Iterable<String> words(){
		ArrayList<String> words = new ArrayList<String>();
		collect(root, "", words);
		return words;
	}
	
	public void collect(Node x, String prefix, ArrayList<String> words){
		if(x == null) return;
		
		if(x.value != null) words.add(prefix);
		
		for(int i = 0; i < R; ++i){
			if(x.next[i] != null){
				collect(x.next[i], prefix+(char)i, words);
			}
			
		}
	}
	
	public Iterable<String> keysWithPrefix(String prefix){
		ArrayList<String> words = new ArrayList<String>();
		Node x = search(root, prefix, 0);
		collect(x, prefix, words);
		return words;
	}
	
	public String longestPrefix(String query){
		int length = get(root, query, 0, 0);
		return query.substring(0,length);
	}
	
	public int get(Node x, String query, int d, int length){
		if(x == null) return length;
		if(x.value != null) length = d;
		if(d == query.length()) return length;
		int c = query.charAt(d);
		
		return get(x.next[c], query, d+1, length);
	}
}
