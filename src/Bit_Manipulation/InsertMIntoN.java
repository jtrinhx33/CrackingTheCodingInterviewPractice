package Bit_Manipulation;

public class InsertMIntoN {

	/**
	 * Problem 5.1
	 * @param args
	 */
	public static void main(String[] args) {
		
		//int n = 1024;
		//int m = 19;
		
		int n = Integer.parseInt("10000000000", 2);
		int m = Integer.parseInt("10011", 2);
		int i = 2;
		int j = 6;
		// Output should be 1100 (decimal)
		
		int result1 = insert(n, m, i, j);
		int result2 = updateBits(n, m, i, j);
		System.out.println("My solution: " + Integer.toBinaryString(result1) + ", Decimal: " + result1);
		System.out.println("Book's solution: " + Integer.toBinaryString(result2) + ", Decimal: " + result2);
	}
	
	// My solution
	public static int insert(int n, int m, int i, int j){
		int size_m = (j - i) + 1;
		int mask = (1 << size_m) - 1;
		mask = ~(mask << i);
		
		int cleared_n = n & mask; // Clear bits from i to j
		int shifted_m = m << i; // Move M into place for insert
		
		return cleared_n | shifted_m;
	}
	
	// Book's solution
	public static int updateBits(int n, int m, int i, int j){
		// Create a mask to clear bits i through j in n
		// Example: i = 2, j = 4, Result should be 11100011
		// For simplicity, we'll just use 8 bits for the example
		
		int allOnes = ~0; // Will equal all sequence of ones
		
		// 1s before position j, then 0s. left = 11100000
		int left = allOnes << (j + 1);
		
		// 1's after position i. right = 00000011
		int right = ((1 << i) - 1);
		
		// All 1's except for 0s between i and j. mask = 11100011
		int mask = left | right;
		
		// Clear bits j through i then put m in there
		int n_cleared = n & mask; // Clear bits j through i
		int m_shifted = m << i; // Move m into correct position
		
		return n_cleared | m_shifted; // OR them
	}

}
