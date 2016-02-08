
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] input = {{1,2,3},{4,5,6}, {7,8,9}};
		
		System.out.println(findElement(input, 5));
		System.out.println(findElement(input, 10));
	}
	
	public static boolean findElement(int[][] input, int elem){
		int i = input.length-1, j = 0;
		
		while(i >=0 && j <input[0].length){
			if(elem == input[i][j]){
				System.out.println(i+","+j);
				return true;
			} else if(elem < input[i][j]){
				--i;
			} else{
				++j;
			}
		}
		
		return false;
	}

}
