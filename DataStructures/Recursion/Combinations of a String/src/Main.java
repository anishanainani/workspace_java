
public class Main {

	/**
	 * @param args
	 */
	
	String in = "";
	StringBuilder out;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m = new Main();
		m.combinationsString("abcd");
	}
	
	public void combinationsString(String in){
		out = new StringBuilder();
		this.in = in;
		combine(0);
	}
	public void combine(int start){
		for(int i = start; i < in.length()-1; ++i){
			out.append(in.charAt(i));
			System.out.println(out);
			combine(i+1);
			out.setLength(out.length()-1);

		}
		
		out.append(in.charAt(in.length()-1));
		System.out.println(out);
		out.setLength(out.length()-1);
	}

}
