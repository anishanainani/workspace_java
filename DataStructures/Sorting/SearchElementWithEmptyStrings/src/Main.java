
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] input = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
		
		System.out.println(search(input, "ball"));
		System.out.println(search(input, "ballcar"));

	}
	
	public static int search(String[] input, String elem){
		if(input == null || elem == null) return -1;
		
		if(elem.equals("")){
			for(int i = 0 ; i < input.length; ++i){
				if(elem.equals(input[i])) return i;
			}
			
			return -1;
		}
		
		return search(input, elem, 0, input.length-1);
		
	}
	
	public static int search(String[] input, String elem, int l, int r){
		
		
		
		while(l <= r){
			
			while(input[l].equals("")) ++l;
			
			while(input[r].equals("")) --r;
			
			if(r < l){
				return -1;
			}
			
			int mid = (l+r)/2;
			
			while(input[mid].equals("")) ++mid;
			
			
			if(mid <= r){
				
				if(elem.compareTo(input[mid]) == 0){
					return mid;
				}
				
				if(elem.compareTo(input[mid]) < 0){
					r = mid-1;
				} else {
					l = mid+1;
				}
			}
			
			
		}
		
		return -1;
	}

}
