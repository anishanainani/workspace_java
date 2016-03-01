
public class LinearProbingST<Key, Value> {

	private int N, M;
	private Key[] keys;
	private Value[] values;
	
	public LinearProbingST(int M){
		keys = (Key[]) new Object[M];
		values = (Value[]) new Object[M];
		N = 0;
		this.M = M;
	}
	
	public int hash(Key key){
		return (key.hashCode() & 0x7fffffff)%M;
	}
	
	public void put(Key key, Value value){
		int hash = hash(key);
		int i;
		for(i = hash; keys[i]!=null; i=(i+1)%M){
			if(keys[i].equals(key)) {
				values[i] = value;
				return;
			}
		}
		
		keys[i] = key;
		values[i] = value;
	}
	
	public Value get(Key key){
		int hash = hash(key);
		for(int i = hash; keys[i]!=null; i=(i+1)%M){
			if(keys[i].equals(key)){
				return values[i];
			}
		}
		
		return null;
	}
	
	public int size(){
		return N;
	}
	
	public boolean isEmpty(){
		return N==0;
	}
	
	public boolean contains(Key key){
		return get(key)!=null;
	}
	public static void main(String[] args) {
		LinearProbingST<String, Integer> scst = new LinearProbingST<String, Integer>(10);
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
