package Arrays_and_Strings;

public class MaxSumSubarray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] array = { 5, -3, 2, 8};
		System.out.println(maxContigiousSum(array));
		System.out.println(Kadane(array));
		
	}
	
	public static int maxContigiousSum(int[] array){
		int current_max = 0;
		int max_sum = 0;
		
		for (int ii = 0; ii < array.length; ii++){
			if (current_max < 0){ // Reset to 0 if it goes negative
				current_max = 0;
			}
			current_max += array[ii];
			if (current_max > max_sum){
				max_sum = current_max;
			}
		}
		
		return max_sum;
	}
	
	public static int Kadane(int[] array){
		int current = 0;
		int max_sum = 0;
		
		for (int ii = 0; ii < array.length; ii++){
			current = Math.max(array[ii], current + array[ii]);
			max_sum = Math.max(current, max_sum);
		}
		
		return max_sum;
	}

}
