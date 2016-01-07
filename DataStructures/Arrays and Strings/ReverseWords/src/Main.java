
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String input = "I am anisha";
		char[] in = input.toCharArray();
		
		reverse(in, 0 , input.length()-1);
		

		int s=0,curr = 0;
		while(curr < input.length()){
			if(in[curr] == ' ' || curr == input.length()-1){
				reverse(in,s,curr-1);
				s = curr+1;
			}
			curr++;
		}

		System.out.println(new String(in));
	}
	
	public static void reverse(char[] str, int start, int end){
	

		while(end>start){
			char temp= str[start];
			str[start] = str[end];
			str[end] = temp;
			start++;
			end--;
		}

	}
	
}
