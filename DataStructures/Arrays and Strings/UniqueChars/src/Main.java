
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if(isUniqueChars("aanish")){
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		

	}
	
	public static boolean isUniqueChars(String input){
		int checker = 0;
		for(int i = 0; i < input.length(); ++i){
			int val = input.charAt(i)-'a';
			if((checker & (1<<val)) > 0) return false;
			checker|= 1<<val;
		}
		return true;
	}


}
