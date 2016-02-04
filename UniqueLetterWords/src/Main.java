import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] input = {"ABCDX", "BAR","FOO", "FNTY","POL"};
		
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < input.length; ++i){
			for(int j = i+1; j < input.length;++j){
				if((hasChars(input[i]) & hasChars(input[j])) == 0){
					int prod = input[i].length()*input[j].length();
					
					if(prod > max){
						max = prod;
					}
				}
			}
		}
		
		System.out.println(max);
	}

	public static int hasChars(String s){
		int ret = 0;
		for(int i = 0; i < s.length(); ++i){
			char c = s.charAt(i);
			ret |= (1<<(c-'a'));
		}
		
		return ret;
	}
}
