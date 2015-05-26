package Trees_and_Graphs;

import java.util.LinkedList;

import CareerCupLibrary.AssortedMethods;
import CareerCupLibrary.TreeNode;

public class ContainsSubtree {

	/**
	 * Problem 4.8
	 * @param args
	 */
	public static void main(String[] args) {
		// t2 is a subtree of t1
		int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
		int[] array2 = {2, 4, 5, 8, 9, 10, 11};
		
		TreeNode t1 = AssortedMethods.createTreeFromArray(array1);
		TreeNode t2 = AssortedMethods.createTreeFromArray(array2);

		//if (containsTree(t1, t2))
		if (isSubTree(t1, t2))
			System.out.println("t2 is a subtree of t1");
		else
			System.out.println("t2 is not a subtree of t1");

		// t4 is not a subtree of t3
		int[] array3 = {1, 2, 3};
		TreeNode t3 = AssortedMethods.createTreeFromArray(array1);
		TreeNode t4 = AssortedMethods.createTreeFromArray(array3);

		//if (containsTree(t3, t4))
		if (isSubTree(t3, t4))
			System.out.println("t4 is a subtree of t3");
		else
			System.out.println("t4 is not a subtree of t3");
	}
	
	public static boolean isSubTree(TreeNode T1, TreeNode T2){
		if (T1 == null || T2 == null) return false;
		
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(T1);
		
		while (!queue.isEmpty()){
			TreeNode current = queue.remove();
			
			if (current == T2){
				if (current.left == T2.left && current.right == T2.right)
					return true;
			}
			
			if (current != null)
				queue.add(current.left);
			if (current != null)
				queue.add(current.right);
		}
		
		return false;
	}

	// Book's solution
	
	
	
	
}
