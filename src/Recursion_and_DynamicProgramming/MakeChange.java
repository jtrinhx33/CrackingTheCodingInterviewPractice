package Recursion_and_DynamicProgramming;

public class MakeChange {

	/**
	 * Problem 9.8
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(dvr_remote(5, "ER"));
	}
	
	public static String dvr_remote(int width, String title){

		StringBuilder out = new StringBuilder();

		int column;
		int row;
		int prevcolumn = 0;
		int prevrow = 0;

		for (int ii = 0; ii < title.length(); ii++){
			char c = title.charAt(ii);

			c = (char) (c - 'A'); // number rep of letter
			column = c % width; // 0
			row = c / width; // 5

			if (column < prevcolumn){ // move to the left

				for (int jj = 0; jj < Math.abs(prevcolumn - column); jj++){
					out.append("L");
				}
			}
			else { // move to the right
				for (int jj = 0; jj < Math.abs(prevcolumn - column); jj++){
					out.append("R");
				}
			}

			if (row < prevrow){ // move up
				
				for (int jj = 0; jj < Math.abs(prevrow - row); jj++){
					out.append("U");
				}
			}
			else { // move down
				for (int jj = 0; jj < Math.abs(prevrow - row); jj++){
					out.append("D");
				}
			}
			out.append("*");

			prevcolumn = column;
			prevrow = row;
		}

		return out.toString();
	}
	
	public static int makeChange(int n){
		int[] coins = {25, 10, 5, 1};
		return makeChange(n, coins, 0);
	}
	
	public static int makeChange(int amount, int[] coins, int index){
		if (index >= coins.length - 1) return 1; // last denom 
		int coinsAmount = coins[index];
		int ways = 0;
		
		for (int ii = 0; ii * coinsAmount <= amount; ii++){
			int amountRemaining = amount - ii * coinsAmount;
			ways += makeChange(amountRemaining, coins, index + 1);
		}
		
		return ways;
	}
	
	public static int makeChangeDP(int n){
		int[] coins = {25, 10, 5, 1};
		int[][] map = new int[n + 1][coins.length];
		
		return makeChange(n, coins, 0, map);
	}
	
	public static int makeChange(int amount, int[] coins, int index, int[][] map){
		if (map[amount][index] > 0) { // retrieve value
			return map[amount][index];
		}
		
		if (index >= coins.length - 1) return 1; // one denom remaining
		
		int coinAmount = coins[index];
		int ways = 0;
		
		for (int ii = 0; ii * coinAmount <= amount; ii++){
			// Go to next denom, assuming ii coins of coinAmount
			int amountRemaining = amount - ii * coinAmount;
			ways += makeChange(amountRemaining, coins, index + 1, map);
		}
		map[amount][index] = ways;
		return ways;
	}

}
