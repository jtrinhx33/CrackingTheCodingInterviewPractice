package Trees_and_Graphs;

import CareerCupLibrary.TreeNode;

public class CreateMinimalBST {

	/**
	 * Problem 4.3
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		// We needed this code for other files, so check out the code in the library
		//TreeNode root = TreeNode.createMinimalBST(array);
		TreeNode root = createBST(array);
		System.out.println("Root? " + root.data);
		System.out.println("Created BST? " + root.isBST());
		System.out.println("Height: " + root.height());
	}

	// O(nlog(n))
	public static TreeNode createBST(int array[]){
		int index = 0;
		if (array.length == 0) return null;
		
		int[] arrayLeft;
		int[] arrayRight;
		
		index = array.length / 2;
		TreeNode n = new TreeNode(array[index]);
		
		// Only one node
		if (index == 0) return n;
		
		arrayLeft = new int[index];
		for (int ii = 0; ii < index; ii++){
			arrayLeft[ii] = array[ii];
		}
		n.left = createBST(arrayLeft);
		
		if (array.length - (index + 1) <= 0){
			n.right = null;
		}
		else {
			arrayRight = new int[array.length - (index + 1)];
			int jj = 0;
			for (int ii = index + 1; ii < array.length; ii++){
				arrayRight[jj] = array[ii];
				jj++;
			}
			n.right = createBST(arrayRight);
		}
		
		return n;
	}
	
}
