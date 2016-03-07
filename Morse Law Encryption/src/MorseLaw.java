import java.util.HashMap;


public class MorseLaw {
	HashMap<String, String> decoding = new HashMap<String, String>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MorseLaw ml = new MorseLaw();
		ml.buildMorseCharacterMapping();
		ml.printAllDecodings("..-.");
	}
	
	public void buildMorseCharacterMapping(){
		decoding.put(".-", "a");
		decoding.put("-...", "b");
		decoding.put("-.-.", "c");
		decoding.put("-..", "d");
		decoding.put(".", "e");
		decoding.put("..-.", "f");
		decoding.put("--.", "g");
		decoding.put("....", "h");
		decoding.put("..", "i");
		decoding.put(".---", "j");
		decoding.put("-.-", "k");
		decoding.put(".-..", "l");
		decoding.put("--", "m");
		decoding.put("-.", "n");
		decoding.put("---", "o");
		decoding.put(".--.", "p");
		decoding.put("--.-", "q");
		decoding.put(".-.", "r");
		decoding.put("...", "s");
		decoding.put("-", "t");
		decoding.put("..-", "u");
		decoding.put("...-", "v");
		decoding.put(".--", "w");
		decoding.put("-..-", "x");
		decoding.put("-.--", "y");
		decoding.put("--..", "z");
	}
	
	public void printAllDecodings(String morse){
		printAllDecodings("", morse, "");
	}

	public void printAllDecodings(String soFar, String rest, String decode){
		if(rest.length() == 0){
			System.out.println(decode);
			return;
		}
		
		for(int i = 1; i <= rest.length(); i++){
			String sub = rest.substring(0, i);
			if(!decoding.containsKey(sub)){
				continue;
			}
			
			//System.out.println(soFar+" "+rest+" "+decode);
			printAllDecodings(soFar+sub, rest.substring(i), decode+decoding.get(sub));
		}
	}
}
