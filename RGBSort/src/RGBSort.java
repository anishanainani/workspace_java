import java.util.Scanner;


public class RGBSort {

	public static void main(String[] args){

		char[] input = {'B','R','B','G', 'G','R'};

		RGBSort sort = new RGBSort();

		sort.sortRGB(input);

		sort.printArray(input);

	}


	public void printArray(char input[]) {

		for(char c : input){

			System.out.print(c);

		}

		System.out.println();

	}

	public void swap(char input[], int i, int j) {

		if(i==j || input[i] == input[j]) return;

		char temp = input[i];

		input[i] = input[j];

		input[j] = temp;

		//System.out.print(" i:" + i + " j:" +j +" ");

		//printArray(input);

	}


	public void sortRGB(char[] input){

		if(input.length == 0 || input.length == 1){
			return;
		}

		int i = 0, k = input.length-1;

		while(i<input.length && input[i] == 'R'){
			++i;
		}
		
		while(k >=0 && input[k] == 'B'){
			--k;
		}
			
		int j = i;
		
		while(i <= k && j <= k ){
			
			if(i > j || input[j] == 'G'){
				++j;
			} else if(input[j] == 'R'){
				swap(input, i, j);
				++i;
			} else if(input[j] == 'B'){
				swap(input, j, k);
				--k;
			}
		}
	}
}