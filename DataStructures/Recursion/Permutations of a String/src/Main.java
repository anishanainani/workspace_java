
public class Main {

	/**
	 * @param args
	 */
	
	StringBuilder out;
	String in;
	boolean[] used;
	
	public static void main(String[] args) {
		Main m = new Main();
		m.permuteString("abcd");

	}
	
	public void permuteString(String in){
		used = new boolean[in.length()];
		for(int i = 0; i < in.length(); ++i){
			used[i] = false;
		}
		out = new StringBuilder();
		this.in = in;
		permute();
	}
	
	public void permute(){
		if(out.length()==in.length()){
			System.out.println(out);
			return;
		}
		
		for(int i = 0; i < in.length(); ++i){
			if(used[i]){
				continue;
			}
			
			out.append(in.charAt(i));
			used[i] = true;
			
			permute();
			
			used[i] = false;
			out.setLength(out.length()-1);
			
		}
	}

}
