package Trees_and_Graphs;

import CareerCupLibrary.TreeNode;

public class HasCommonAncestor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
		TreeNode n3 = root.find(1);
		TreeNode n7 = root.find(7);
		//TreeNode ancestor = hasCommonAncestor(n3, n7);
		TreeNode ancestor = commonAncestor(root, n3, n7);
		System.out.println(ancestor.data);

	}

	// My solution: O(H^2)? 
	public static TreeNode hasCommonAncestor(TreeNode p, TreeNode q){
		if (p == null || q == null) return null;
		// Only if we don't allow node itself to be an ancestor:
		//if (p.parent == null || q.parent == null) return false;
		
		while (p.parent != null){
			p = p.parent;
			TreeNode r = q;
			
			while (r.parent != null){
				r = r.parent;
				if (p == r)
					return p;
			}
		}
		
		return null;
	}
	
	// Book's solution: O(n) time on balanced tree
	public static boolean covers(TreeNode root, TreeNode p){
		if (root == null) return false;
		if (root == p) return true;
		
		return covers(root.left, p) || covers(root.right, p);
	}
	
	public static TreeNode commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q){
		
		if (root == null) return null;
		if (root == p || root == q) return root;
		
		boolean is_p_on_left = covers(root.left, p);
		boolean is_q_on_left = covers(root.left, q);
		
		// If p or q are on different sides, return root
		if (is_p_on_left != is_q_on_left) return root;
		
		// Else they are on the same side, Traverse this side
		TreeNode child_side = is_p_on_left ? root.left : root.right;
		return commonAncestorHelper(child_side, p, q);
	}
	
	public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q){
		if (!covers(root, p) || !covers(root, q)) // Error check if p and q are in tree
			return null;
		
		return commonAncestorHelper(root, p, q);
	}
	
	// Book's solution 2
	public static class Result{
		public TreeNode node;
		public boolean isAncestor;
		public Result(TreeNode n, boolean isAncestor){
			node = n;
			this.isAncestor = isAncestor;
		}
	}
	
	Result commonAncestorHelper2(TreeNode root, TreeNode p, TreeNode q){
		if (root == null){
			return new Result(null, false);
		}
		
		if (root == p && root == q){
			return new Result(root, true);
		}
		
		Result rx = commonAncestorHelper2(root.left, p, q);
		if (rx.isAncestor){ // Found common ancestor
			return rx;
		}
		
		Result ry = commonAncestorHelper2(root.right, p, q);
		if (ry.isAncestor){ // Found common ancestor
			return ry;
		}
		
		// Found p and q in tree
		if (rx.node != null && ry.node != null){
			return new Result(root, true);
		}
		else if (root == p || root == q){
			// If we're currently at p or q, and we also found one of those nodes
			// in a subtree, then this is truly an ancestor and the flag should be set true
			boolean isAncestor = rx.node != null || ry.node != null ? true : false;
			return new Result(root, isAncestor);
		}
		else {
			return new Result(rx.node != null ? rx.node : ry.node, false);
		}
	}
}
