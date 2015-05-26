package Bit_Manipulation;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class NextSmallestLargestNumber_SameNumberOfBits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		nextLargestSmallestSameBitCount(10);

		System.out.println(getPrev(10));
		System.out.println(getNext(10));
	}
	
	public static void nextLargestSmallestSameBitCount(int num){
		int bit_count = countBits(num);
		
		// Find next smallest number with same number of bits
		int count = 0;
		int n = num - 1;
		
		while (n > 0 && count != bit_count){
			count = countBits(n);
			
			if (count == bit_count){
				System.out.println("Next smallest: " + n);
				break;
			}
			n--;
		}
		if (count != bit_count) System.out.println("No next smallest exists.");
		
		// Find next largest number with same number of bits
		count = 0;
		n = num + 1;
		while (n > 0 && count != bit_count){
			count = countBits(n);
			
			if (count == bit_count){
				System.out.println("Next largest: " + n);
				break;
			}
			n++;
		}
		
		if (count != bit_count) System.out.println("No next largest exists.");
	}
	
	public static int countBits(int num){

		int n = num;
		int bit_count = 0;
		
		while (n > 0){
			if ((n & 1) > 0){
				bit_count++;
			}
			n = n >> 1;
		}
		
		return bit_count;
		
	}
	
	// Book's solution
	// Bit manipulation
	public static int getNext(int n){
		// Compute c0 and c1
		int c = n;
		int c0 = 0;
		int c1 = 0;
		
		while (((c & 1) == 0) && c != 0){
			c0++;
			c = c >> 1;
		}
		
		while ((c & 1) == 1){
			c1++;
			c = c >> 1;
		}
		
		// Error: if n == 11...1100...00, then there is no bigger number
		// with the same number of 1s.
		if (c0 + c1 == 31 || c0 + c1 == 0){
			return -1;
		}
		
		int p = c0 + c1; // Position of rightmost non-trailing zero
		n |= (1 << p); // Flip rightmost non-trailing zero
		n &= ~((1 << p) - 1); // Clear all bits to the right of p
		n |= (1 << (c1 - 1)) - 1; // Insert (c1 - 1) ones on the right
		
		return n;
	}
	
	public static int getPrev(int n){
		
		int temp = n;
		int c0 = 0;
		int c1 = 0;
		while ((temp & 1) == 1){
			c1++;
			temp >>= 1;
		}
		
		if (temp == 0) return -1;
		
		while (((temp & 1) == 0) && (temp != 0)){
			c0++;
			temp >>= 1;
		}
		
		int p = c0 + c1; // Position of rightmost non-trailing one
		n &= ((~0) << (p + 1)); // Clears from bit p onwards
		
		int mask = (1 << (c1 + 1)) - 1; // Sequence of (c1 + 1) ones
		n |= mask << (c0 - 1);
		
		return n;
	}
}
