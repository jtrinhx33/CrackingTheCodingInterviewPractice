package Trees_and_Graphs;

import CareerCupLibrary.TreeNode;

public class InOrderSuccessor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
		for (int i = 0; i < array.length; i++) {
			TreeNode node = root.find(array[i]);
			TreeNode next = inorderSucc(node);
			if (next != null) {
				System.out.println(node.data + "->" + next.data);
			} else {
				System.out.println(node.data + "->" + null);
			}
		}
		
		System.out.println("----------------------");
		
		TreeNode root2 = TreeNode.createMinimalBST(array);
		for (int i = 0; i < array.length; i++) {
			TreeNode node = root2.find(array[i]);
			TreeNode next = inOrderSuccessor(node);
			if (next != null) {
				System.out.println(node.data + "->" + next.data);
			} else {
				System.out.println(node.data + "->" + null);
			}
		}
	}

	// So wrong :(
	public static TreeNode inOrderSuccessor(TreeNode n){
		if (n == null) return null;
		if (n.left == null && n.right == null)
			return n.parent;
		if (n.right == null && n.parent != null){
			while (n.parent.data <= n.data){
				n = n.parent;
				if (n.parent == null)
					return null;
				if (n.parent.data > n.data)
					return n.parent;
			}
		}
		
		if (n.right != null){
			n = n.right;
			while (n.left != null){
				n = n.left;
			}
			return n;
		}
		return null;
	}
	
	// Book's solution
	public static TreeNode inorderSucc(TreeNode e) { 
		if (e != null) { 
			TreeNode p; 
			// Found right children -> return 1st inorder node on right
			if (e.parent == null || e.right != null) { 
				p = leftMostChild(e.right); 
			} else { 
				// Go up until we’re on left instead of right (case 2b)
				while ((p = e.parent) != null) { 
					if (p.left == e) {
						break; 
					}
					e = p; 
				} 
			} 
			return p; 
		} 
		return null; 
	} 
		
	public static TreeNode leftMostChild(TreeNode e) {
		if (e == null) return null;
		while (e.left != null) e = e.left; 
		return e; 
	}
}
