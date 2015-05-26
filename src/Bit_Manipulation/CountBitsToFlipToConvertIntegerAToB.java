package Bit_Manipulation;

public class CountBitsToFlipToConvertIntegerAToB {

	/**
	 * Question 5.5
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(numBitsFlip(29, 15));
		System.out.println(bitSwapRequired(29, 15));
		System.out.println(bitSwapRequired_LessIterations(29, 15));
		
		System.out.println(numBitsFlip(101, 22));
		System.out.println(bitSwapRequired(101, 22));
		System.out.println(bitSwapRequired_LessIterations(101, 22));
	}
	
	public static int numBitsFlip(int a, int b){
		int c = a ^ b;
		int count = 0;
		
		while (c > 0){
			if ((c & 1) > 0){
				count++;
			}
			
			c = c >> 1;
		}
		return count;
	}
	
	// Book's solution: iterate using shift
	public static int bitSwapRequired(int a, int b){
		int count = 0; 
		for (int c = a ^ b; c != 0; c = c >> 1){
			count += c & 1;
		}
		return count;
	}
	
	// Book's solution: 
	// iterate using clearing at and after the least significant 1 (reduces number of shifts needed if there are 0's in between)
	public static int bitSwapRequired_LessIterations(int a, int b){
		int count = 0;
		for (int c = a ^ b; c != 0; c &= c & (c - 1)){
			count++;
		}
		return count;
	}
}
