
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] input = {{1,2,3,4},{3,0,9,8},{1,4,8,0}, {3,7,1,9}};
		
		for(int i = 0; i < 4; ++i){
			for(int j = 0; j < 4; ++j){
				System.out.print(input[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		setZeroes(input);
		
		for(int i = 0; i < 4; ++i){
			for(int j = 0; j < 4; ++j){
				System.out.print(input[i][j]);
			}
			System.out.println();
		}

	}
	
	public static void setZeroes(int[][] input){
		int[] rows = new int[input.length];
		int[] columns = new int[input[0].length];

		for(int i = 0; i < input.length; ++i){
			for(int j = 0; j < input[0].length; ++j){
				if(input[i][j] == 0){
					rows[i]++;
					columns[j]++;
				}
			}
		}


		for(int i = 0; i < input.length; ++i){
			for(int j = 0; j < input[0].length; ++j){
				if(rows[i] >0 || columns[j] > 0){
					input[i][j] = 0;
				}
			}
		}
	}


}
