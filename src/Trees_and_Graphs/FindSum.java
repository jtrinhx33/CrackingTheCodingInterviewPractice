package Trees_and_Graphs;

import CareerCupLibrary.TreeNode;

public class FindSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	// Book's solution
	public static void findSum(TreeNode node, int sum, int[] path, int level){
		if (node == null) return;
		
		// Insert current node into path
		path[level] = node.data;
		
		// Look for paths with a sum that ends at this node
		int t = 0;
		for (int ii = level; ii >= 0; ii--){
			t += path[ii];
			if (t == sum){
				print(path, ii, level);
			}
		}
		
		// Search nodes beneath this one
		findSum(node.left, sum, path, level + 1);
		findSum(node.right, sum, path, level + 1);
		
		// Remove current node from path. Not strictly necessary, since
		// we would ignore this value, but its good practice
		path[level] = Integer.MIN_VALUE;
	}
	
	public static void findSum(TreeNode node, int sum){
		int depth = depth(node);
		int[] path = new int[depth];
		findSum(node, sum, path, 0);
	}
	
	public static void print(int[] path, int start, int end){
		for (int ii = start; ii <= end; ii++){
			System.out.print(path[ii] + " ");
		}
		System.out.println();
	}
	
	public static int depth(TreeNode node){
		if (node == null)
			return 0;
		else
			return 1 + Math.max(depth(node.left), depth(node.right));
	}
}
