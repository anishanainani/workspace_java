
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isRotation("abc", "aab"));
	}
	
	//Finds if s2 is rotaion of s1
	public static boolean isRotation(String s1, String s2){
		if(s1.length()!=s2.length()){
			return false;
		}
		
		StringBuilder temp = new StringBuilder(s2);
		for(int i = 0; i < s2.length(); ++i){
			StringBuilder r = new StringBuilder();
			r.append(temp.charAt(s1.length()-1)+"");
			r.append(temp.substring(0, s1.length()-1));
			if(r.toString().equals(s1)){
				return true;
			}
			temp = r;
		}
		
		return false;
	}

}
