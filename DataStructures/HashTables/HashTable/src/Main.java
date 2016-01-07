
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashTable<String, Integer> htc = new HashTableChaining<String,Integer>();
		htc.put("Anisha", 1);
		htc.put("Komal", 2);
		System.out.println(htc.get("Anisha"));
		
		HashTable<String, Integer> hto = new HashTableOpenAddressing<String,Integer>();
		hto.put("Anisha", 1);
		hto.put("Anisha", 2);
		System.out.println(hto.get("Anisha"));

	}

}
