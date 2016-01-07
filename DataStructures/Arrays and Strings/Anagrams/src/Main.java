
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isAnagram("anisha", "shaana"));
		System.out.println(isAnagram("anisha", "shiana"));
	}

	public static boolean isAnagram(String s, String t){
		if(s.length() != t.length()) return false;
		int[] hit = new int[256];
		int num_completed = 0, num_unique = 0;
		
		for(int i = 0; i < s.length(); ++i){
			if(hit[s.charAt(i)] == 0) num_unique++;
			++hit[s.charAt(i)];
		}

		for(int i = 0; i < t.length(); ++i){
			
			if(hit[t.charAt(i)] ==0){
				return false;
			}
			--hit[t.charAt(i)];
			if(hit[t.charAt(i)] == 0){
				++num_completed;
				if(num_completed==num_unique && i==t.length()-1){
					return true;
				}
			} 
		}
		
		return false;
	}
}
