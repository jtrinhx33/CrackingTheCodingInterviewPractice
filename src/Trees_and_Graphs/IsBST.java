package Trees_and_Graphs;

import CareerCupLibrary.AssortedMethods;
import CareerCupLibrary.TreeNode;

public class IsBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
		int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root2 = AssortedMethods.createTreeFromArray(nodes_flattened);
		
		System.out.println(IsBST(root));
	}

	public static boolean IsBST(TreeNode root){
		if (root == null) return true;
		if (root.left == null && root.right == null) return true;
		
		if (root.left != null)
			if (root.left.data >= root.data) return false;
		
		if (root.right != null)
		if (root.right.data < root.data) return false;
		
		if (IsBST(root.left)== false) return false;
		if (IsBST(root.right)== false) return false;
		
		return true;
	}
	
	// Book solution
	public boolean checkBST(TreeNode n){
		return checkBST(n, null, null);
	}
	
	boolean checkBST(TreeNode n, Integer min, Integer max){
		if (n == null)
			return true;
		
		if ((min != null && n.data <= min) ||
			(max != null && n.data > max)){
			return false;
		}
		
		if (!checkBST(n.left, min, n.data) ||
			!checkBST(n.right, n.data, max))
			return false;
		
		return true;
	}
	
}
