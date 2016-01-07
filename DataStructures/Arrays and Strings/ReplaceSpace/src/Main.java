import java.util.ArrayList;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String in = "I am anisha";
		char[] input = in.toCharArray();
		replaceSpaces(input);
		
		System.out.println(input);
	}

	public static void replaceSpaces(ArrayList<Character> input){
		int spaceCount = 0;
		for(int i = 0; i < input.size(); ++i){
			if(input.get(i) == ' ' ){
				++spaceCount;
			}
		}

		int newLength = input.size() + 2*spaceCount;
		
		for(int i = input.size() -1; i >=0 ;--i){
			if(input.get(i) == ' '){
				input.set(newLength-1, '0');
				input.set(newLength-2, '2');
				input.set(newLength-3, '%');
				newLength-=3;
			} else {
				input.set(newLength-1, input.get(i));
				--newLength;
			}
		}
	}

}
