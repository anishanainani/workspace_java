import java.util.ArrayList;
import java.util.LinkedList;

public class HashTableChaining<Key,Value> extends HashTable<Key,Value>{
	ArrayList<LinkedList<Node> > hashtable;

	public HashTableChaining(){
		tableSize = 101;
		hashtable = new ArrayList<LinkedList<Node> >();
		for(int i = 0; i < tableSize; ++i){
			hashtable.add(new LinkedList<Node>());
		}
		//System.out.println(hashtable.size());
		
		keySet = new ArrayList<Key>();
	}

	int hash(String key){
		int hashValue = 0;

		for(int i = 0; i < key.length(); ++i){
			hashValue += 37*hashValue+(int)key.charAt(i);
		}
		hashValue%=tableSize;
		if(hashValue<0){
			hashValue+=tableSize;
		}
		return hashValue;
	}

	public void put(Key key, Value value){
		
		int hash = hash(key.toString());
		if(hashtable.get(hash) == null){
			hashtable.add(hash, new LinkedList<Node>());
			
		}
		if(containsKey(key)){
			LinkedList<Node> list = hashtable.get(hash);
			for(int i =0; i<list.size(); ++i){
				if(list.get(i).key.equals(key)){
					list.get(i).value = value;
				}
			}
		} else {
			hashtable.get(hash).add(new Node(key, value));
			keySet.add(key);
		}
	}
	
	public Value get(Key key){

		if(!containsKey(key)){
			return null;
		}
		int hash = hash(key.toString());
		
		LinkedList<Node> list = hashtable.get(hash);
		for(int i =0; i<list.size(); ++i){
			if(list.get(i).key.equals(key)){
				return list.get(i).value;
			}
		}
		
		return null;
	}
}