
public class SeparateChainingST<Key, Value> {
	private int M, N;
	private Node[] st;
	
	public SeparateChainingST(int M){
		this.M = M;
		st = new Node[M];
		N = 0;
	}
	
	private static class Node{
		private Object key;
		private Object value;
		private Node next;
		
		public Node(Object key, Object value, Node next){
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
	
	public int hash(Key key){
		return (key.hashCode() & 0x7fffffff)%M;	// to make it positive
	}
	
	public void put(Key key, Value value){
		int hash = hash(key);
		for(Node x = st[hash]; x!=null; x=x.next){
			if(x.key.equals(key)) {
				x.value = value;
				return;
			}
		}
		N++;
		st[hash] = new Node(key, value, st[hash]);
	}
	
	public Value get(Key key){
		int hash = hash(key);
		for(Node x = st[hash]; x!=null; x=x.next){
			if(x.key.equals(key)) return (Value)x.value;
		}
		
		return null;
	}
	
	public int size(){
		return N;
	}
	
	public boolean isEmpty(){
		return N==0;
	}
	
	public static void main(String[] args) {
		SeparateChainingST<String, Integer> scst = new SeparateChainingST<String, Integer>(10);
		scst.put("A", 5);
		scst.put("B", 9);
		scst.put("C", 7);
		scst.put("L", 10);
		scst.put("V", 0);
		scst.put("Z", 1);
		
		System.out.println((Integer)scst.get("A"));
		
		scst.put("A", 1);
		
		System.out.println((Integer)scst.get("A"));
	}

}
