import java.util.HashMap;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(firstNonrepeatedChar("teeter"));
	}
	
	public static Character firstNonrepeatedChar(String str){
		HashMap<Character,Integer> charCount = new HashMap<Character,Integer>();
		for(int i = 0; i < str.length(); ++i){
			if(charCount.containsKey(str.charAt(i))){
				charCount.put(str.charAt(i), charCount.get(str.charAt(i))+1);
			} else {
				charCount.put(str.charAt(i),1);
			}
		}

		for(int i = 0; i < str.length(); ++i){
			if(charCount.get(str.charAt(i)) == 1){
				return str.charAt(i);
			}
		}

		return null;
	}

}
