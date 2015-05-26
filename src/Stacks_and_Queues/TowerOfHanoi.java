package Stacks_and_Queues;

import java.util.Stack;

public class TowerOfHanoi {

	/**
	 * Problem 3.4
	 * @param args
	 */
	public static void main(String[] args) {
		TowerOfHanoi game = new TowerOfHanoi(10);

		game.solve();
		System.out.println("Done");
	}

	public int numDisks;
	public Stack[] towers;

	public TowerOfHanoi(int n) {
		towers = new Stack[3];
		numDisks = n;
		
		for (int ii = 0; ii < towers.length; ii++) {
			towers[ii] = new Stack<Integer>();
		}

		for (int ii = numDisks; ii >= 1; ii--) {
			towers[0].push(ii);
		}
	}

	public void solve(){
		int start = 0;
		int dest = start + 1;
		
		while (towers[2].size() != numDisks) {
			
			if (!moveDisk(start, dest)) {
				if (start == 0) dest = 2;
				else if (start == 1) dest = 0;
				else if (start == 2) dest = 1;
				moveDisk(start, dest);
				start++;
				dest = start + 1;
			}
			else {
			}
			
			if (start >= towers.length){
				start = 0;
				dest = 1;
			}
			else if (start == towers.length - 1){
				dest = 0;
			}
			
		}
	}

	public boolean moveDisk(int start, int dest) {
		if (start < 0 || start >= towers.length) return false;
		if (dest < 0 || dest >= towers.length) return false;
		if (start == dest) return false;

		// Error check for start tower empty
		if (towers[start].isEmpty()) return false;
		
		int disk1 = (Integer) towers[start].peek();
		
		// Error check for destination tower empty
		if (towers[dest].isEmpty()){
			
			towers[start].pop();
			towers[dest].push(disk1);
			return true;
		}
		
		int disk2 = (Integer) towers[dest].peek();
		if (disk1 < disk2) { // Condition satisfied
			towers[start].pop();
			towers[dest].push(disk1);
			return true;
		}

			return false;
	}
	
	
	
}
