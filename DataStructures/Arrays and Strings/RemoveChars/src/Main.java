
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeChars("Hii I am anisha nainani", "aeiou"));
	}

	public static String removeChars(String str, String remove){
		char[] s = str.toCharArray();
		int dst = 0;
		boolean letters[] = new boolean[128];
		for(int i = 0; i < 128; ++i){
				letters[i] = false;
		}

		for(int i = 0; i < remove.length(); ++i){
			letters[(int)remove.charAt(i)] = true;
		}

		//StringBuilder result = new StringBuilder();
		for(int i = 0; i < str.length(); ++i){
			if(!letters[(int)str.charAt(i)]){
				//result.append(str.charAt(i));
				s[dst++] = s[i];
			}
		}

		return new String(s, 0, dst);
	}
}
