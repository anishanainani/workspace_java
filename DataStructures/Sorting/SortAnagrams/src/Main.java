import java.util.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] input = {"anisha", "shaani","niasha", "komal", "malko"};
		Arrays.sort(input, new AnagramComparator());
		
		for(int i = 0; i < input.length; ++i){
			System.out.println(input[i]);
		}
	}
	
	public static class AnagramComparator implements Comparator<String>{
		
		public String sortChars(String s){
			char[] str = s.toCharArray();
			Arrays.sort(str);
			return new String(str);
		}
		
		public int compare(String s1, String s2){
			return sortChars(s1).compareTo(sortChars(s2));
		}
		
	}

}
