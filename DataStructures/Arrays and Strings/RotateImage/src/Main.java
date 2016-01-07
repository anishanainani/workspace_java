
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] in = new int[3][3];
		for(int i= 0; i<3; ++i){
			in[i][0] = 3;
		}
		
		for(int i= 0; i<3; ++i){
			in[2][i] = 3;
		}
		
		for(int i = 0; i < 3; ++i){
			for(int j = 0; j < 3; ++j){
				System.out.print(in[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		rotateImage(in);
		
		for(int i = 0; i < 3; ++i){
			for(int j = 0; j < 3; ++j){
				System.out.print(in[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void rotateImage(int[][] image){
		int length = image.length;
		
		for(int i = 0; i < image.length/2; ++i){
			int first = i;
			int last =length-i-1;
			for(int j = first; j < last; ++j){
				int temp = image[i][i+j];
				image[i][i+j] = image[i+j][last] ;
				image[i+j][last] = image[last][last-j];
				image[last][last-j] = image[last-j][i];
				 image[last-j][i] = temp;
			}
			
		}
	}
}
