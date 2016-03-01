
public class KMaxSubarray {

	public static void printKMax(int[] input, int k){
		int max = Integer.MIN_VALUE;
		int nextMax = Integer.MIN_VALUE;
		
		for(int i = 0; i < k; i++){
			if(input[i] > max){
				max = input[i];
			}
		}
		
		System.out.print(max+" ");
		
		int count = 1;
		
		for(int i = k; i < input.length; ++i){
			if(count > 1){
				if(nextMax < input[i]){
					nextMax = input[i];
				}
			}
			
			if(count == k){
				System.out.print(nextMax+" ");
				max = nextMax;
				nextMax = Integer.MIN_VALUE;
			} else {
				if(input[i] < max){
					count++;
				} else {
					max = input[i];
					count = 1;
					nextMax = Integer.MIN_VALUE;
				}
				System.out.print(max+" ");
			}
		}
	}
	public static void main(String[] args) {
		int[] input =  {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
		printKMax(input, 4);
	}

}
