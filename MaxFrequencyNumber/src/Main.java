
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] sortedInput = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,3,3,3,3,3,4,4,4,4,4,4,4,5};
		int[] nonSortedInput = {2,3,3,4,1,3,4,3,7,4,4,4};
		
		System.out.println(getMaxFreqNumber(sortedInput));
		
		System.out.println(getMaxFreqNumberNonSortedArray(nonSortedInput,8));

	}
	
	public static int getMaxFreqNumber(int[] sortedInput)
	{
		int max_repetitions = 0, maxi = 0; 
		int i = 0;
		while(i < sortedInput.length)
		{
			int j = i+1, repetitions = 0;
			while(j < sortedInput.length && sortedInput[i] == sortedInput[j]){
				++j;
				++i; 
				repetitions++;
			}

			if(repetitions > max_repetitions){
				max_repetitions = repetitions;
				maxi = i;
			}

			i = j;
		}

		return sortedInput[maxi];
		
	}
	
	public static int getMaxFreqNumberNonSortedArray(int[] input, int k)
	{
		for(int i = 0; i < input.length; ++i){
			input[input[i]%k]+=k;
		}
		
		int max = Integer.MIN_VALUE, maxi = 0;
		for(int i = 0; i < input.length; ++i){
			if(input[i] > max){
				maxi = i;
				max = input[i];
			}
		}
		
		return maxi;
		
	}

}
