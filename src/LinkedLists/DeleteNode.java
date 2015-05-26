package LinkedLists;

import CareerCupLibrary.AssortedMethods;
import CareerCupLibrary.LinkedListNode;

public class DeleteNode {

	/**
	 * Problem 2.3
	 * @param args
	 */
	public static void main(String[] args) {

		LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
		System.out.println(head.printForward());
		deleteNodeMiddle(head.next.next.next.next); // delete node 4
		System.out.println(head.printForward());
		
		LinkedListNode head2 = AssortedMethods.randomLinkedList(10, 0, 10);
		System.out.println(head2.printForward());
		deleteNode(head2.next.next.next.next); // delete node 4
		System.out.println(head2.printForward());
		
	}
	
	public static void deleteNodeMiddle(LinkedListNode n){
		
		if (n == null) return ;
		
		if (n.next == null){
			n = null;
			return ;
		}
		
		LinkedListNode next = n.next;
		if (n != null){
			n.next = next.next;
			n.data = next.data;
		}
	}

	// Book's solution
	// Copy data from next node to current (given) node, then delete next node
	public static boolean deleteNode(LinkedListNode n){
		if (n == null || n.next == null){
			return false; // Failure
		}
		
		LinkedListNode next = n.next;
		n.data = next.data;
		n.next = next.next;
		return true;
	}
}
