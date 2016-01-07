
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String in = "annnnnniiiiisha";
		char[] inp = in.toCharArray();
		
		System.out.println(removeDuplicates(inp));
	}

	public static String removeDuplicates(char[] input){
		if(input == null) return null;
		if(input.length <2) return null;
		
		boolean[] hit = new boolean[256];
		for(int i =0; i < 256; ++i){
			hit[i] = false;
		}

		hit[input[0]] = true;
		int tail = 1;
		for(int i = 1; i < input.length; ++i){
			if(!hit[input[i]]){
				hit[input[i]] = true;
				input[tail] = input[i];
				++tail;
			
			}
		}

		return new String(input,0, tail);
	}
}
