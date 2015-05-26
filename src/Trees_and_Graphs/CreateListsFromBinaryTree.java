package Trees_and_Graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import CareerCupLibrary.AssortedMethods;
import CareerCupLibrary.TreeNode;

public class CreateListsFromBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = AssortedMethods.createTreeFromArray(nodes_flattened);
		ArrayList<LinkedList<TreeNode>> list = createLists(root);
		//ArrayList<LinkedList<TreeNode>> list = findLevelLinkList(root);
		printResult(list);
	}

	public static ArrayList<LinkedList<TreeNode>> createLists(TreeNode root){
		if (root == null) return null;
		
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode current = root;
		queue.add(current);
		ArrayList<LinkedList<TreeNode>> array = new ArrayList<LinkedList<TreeNode>>();
		
		while (!queue.isEmpty()){
			
			LinkedList<TreeNode> listLevel = (LinkedList<TreeNode>) queue.clone();
			array.add(listLevel);
			int size = queue.size();
			for (int ii = 0; ii < size; ii++){
				
				current = queue.remove();
				if (current.left != null) queue.add(current.left);
				if (current.right != null) queue.add(current.right);
				
				if (ii + 1 >= size){
					if (!queue.isEmpty()){
						listLevel = (LinkedList<TreeNode>) queue.clone();
						array.add(listLevel);
						size = queue.size();
						ii = -1;
					}
				}
			}
		}
		
		return array;
	}
	
	// Book's solution
	public static void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level){
		if (root == null) return; // Base case
		
		LinkedList<TreeNode> list = null;
		if (lists.size() == level){ // Level not contained in list
			list = new LinkedList<TreeNode>();
			
			// Levels are always traversed in order. So if this is the first time we've visited level i,
			// we must have seen levels 0 through i - 1. We can therefore safely add the level at the end.
			lists.add(list);
		}
		else {
			list = lists.get(level);
		}
		list.add(root);
		createLevelLinkedList(root.left, lists, level + 1);
		createLevelLinkedList(root.right, lists, level + 1);
	}
	
	public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root){
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
		createLevelLinkedList(root, lists, 0);
		return lists;
	}
	
	public static void printResult(ArrayList<LinkedList<TreeNode>> result){
		int depth = 0;
		for(LinkedList<TreeNode> entry : result) {
			Iterator<TreeNode> i = entry.listIterator();
			System.out.print("Link list at depth " + depth + ":");
			while(i.hasNext()){
				System.out.print(" " + ((TreeNode)i.next()).data);
			}
			System.out.println();
			depth++;
		}
	}
}
