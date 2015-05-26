package Bit_Manipulation;

public class SwapBitPairs {

	/**
	 * Question 5.6
	 * Write a program to swap odd and even bits in an integer with as few instructions as possible.
	 * e.g. bit 0 and bit 1 are swapped. Bit 2 and bit 3 are swapped, and so on.
	 * @param args
	 */
	public static void main(String[] args) {
		
		int num = 145;
		System.out.println("Input: " + Integer.toBinaryString(num));
		System.out.println("My solution: " + Integer.toBinaryString(swapEvenOddBits(num)));
		System.out.println("Book's solution: " + Integer.toBinaryString(swapOddEvenBits(num)));
	}
	
	// Takes 5 instructions if we don't include the step to initialize the masks
	public static int swapEvenOddBits(int num){
		//int even_mask = Integer.parseInt("01010101", 2); // This should be 32 bit repeat: Use the one below instead for better readability
		//int even_mask = Integer.parseInt("10101010", 2); // This should be 32 bit repeat: Use the one below instead for better readability
		
		int even_mask = 0x55555555; // 5 = 0101, 4 bits --> 5 x 8 = 32 bits of 1010101010...10 for odd # bits
		int odd_mask = 0xaaaaaaaa; // A = 1010, 4 bits --> A x 8 = 32 bits of 0101010101...01 for even # bits
		
		even_mask &= num;
		odd_mask &= num;
		
		even_mask <<= 1;
		odd_mask >>= 1;
		
		// Combine masks
		return even_mask | odd_mask;
	}
	
	// Book's solution
	public static int swapOddEvenBits(int x){
		return ( ((x & 0xaaaaaaaa) >> 1) | ((x & 0x55555555) << 1) );
	}

}
