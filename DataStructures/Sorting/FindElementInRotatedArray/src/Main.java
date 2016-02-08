
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14 };
		
		System.out.println(findElement(input, 25, 0, input.length-1));

	}

	public static int findElement(int[] input,int elem, int i, int j){
	
		if(i <= j){
			int mid = (j+i)/2;
			
			if(elem == input[i]){
				return i;
			}
			
			if(elem == input[j]){
				return j;
			}
			
			if(elem == input[mid]){
				return mid;
			}
			
			if((elem > input[mid] && elem > input[j]) || (elem < input[mid] && elem < input[j]) || (elem < input[mid] && elem > input[i])){
				return findElement(input, elem, i, mid-1);
				
			}
			
			if((elem < input[mid] && elem < input[i]) || (elem > input[mid] && elem > input[i]) || (elem > input[mid] && elem < input[j])){
				return findElement(input, elem, mid+1, j);
			}
		}
		
		return -1;
		
		
		
		
	}
}
