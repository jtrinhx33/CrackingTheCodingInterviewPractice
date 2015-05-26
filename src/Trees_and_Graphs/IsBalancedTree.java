package Trees_and_Graphs;

import CareerCupLibrary.AssortedMethods;
import CareerCupLibrary.TreeNode;

public class IsBalancedTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Create balanced tree
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
		System.out.println("Root? " + root.data);
		//System.out.println("Is balanced? " + IsBalancedTree(root));
		System.out.println("Is balanced? " + isBalanced(root));
		
		// Could be balanced, actually, but it's very unlikely...
		TreeNode unbalanced = new TreeNode(10);
		for (int i = 0; i < 10; i++) {
			unbalanced.insertInOrder(AssortedMethods.randomIntInRange(0, 100));
		}
		System.out.println("Root? " + unbalanced.data);
		//System.out.println("Is balanced? " + IsBalancedTree(unbalanced));
		System.out.println("Is balanced? " + isBalanced(unbalanced));
	}

	// O(n log n)
	public static boolean IsBalancedTree(TreeNode root){
		if (root == null) return true;
		if (Math.abs(height(root.left) - height(root.right)) > 1)
			return false;
			
		return true;
	}
	
	public static int height(TreeNode root){
		if (root == null) return 0;
		
		int heightleft = height(root.left);
		int heightright = height(root.right);
		
		if (heightleft > heightright) 
			return Math.abs(1 + heightleft);
		else 
			return Math.abs(1 + heightright);
	}
	
	// Book's solution
	public static int maxDepth(TreeNode root){
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}
			
	public static int minDepth(TreeNode root){
		if (root == null) {
			return 0;
		}
		return 1 + Math.min(minDepth(root.left), minDepth(root.right));
	}
		
	public static boolean isBalanced(TreeNode root){
		return (maxDepth(root) - minDepth(root) <= 1);
	}
}
