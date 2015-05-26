package Recursion_and_DynamicProgramming;

public class CountWaysNStepsStairs {

	/**
	 * Problem 9.1
	 * @param args
	 */
	public static void main(String[] args) {
		
		int n = 15;
		
		// Recursion
		System.out.print("Staircase of " + n + " steps can be hopped in " + countWays(n) + " different ways.");
		
		// Dynamic Programming
		System.out.println();
		int[] map = new int[n + 1];
		System.out.print("Staircase of " + n + " steps can be hopped in " + countWaysDP(n, map) + " different ways.");
	}

	// Runtime: O(3^N) because each n = 3 recursive calls
	public static int countWays(int n){
		if (n < 0) return 0;
		else if (n == 0) return 1;
		else{
			return countWays(n-1)
					+ countWays(n-2)
					+ countWays(n-3);
		}
	}
	
	// DP version: O(N) since we cache all previous values
	public static int countWaysDP(int n, int[] map){
		if (n < 0) return 0;
		else if (n == 0) return 1;
		else if (map[n] != 0){
			return map[n];
		}
		else {
			map[n] = countWays(n-1) + countWays(n-2) + countWays(n-3);
			return map[n];
		}
	}
}
