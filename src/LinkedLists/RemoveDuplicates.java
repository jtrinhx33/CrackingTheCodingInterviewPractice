package LinkedLists;

import java.util.HashSet;

import CareerCupLibrary.AssortedMethods;
import CareerCupLibrary.LinkedListNode;

public class RemoveDuplicates {

	/**
	 * Problem 2.1
	 * @param args
	 */
	public static void main(String[] args) {
		// My solution
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(2);
		head.next.next.next = new Node(4);
		System.out.println(head.printForward());
		Node out = removeDuplicates(head);
		System.out.println(out.printForward());
		
		// Book's solution
		LinkedListNode head2 = AssortedMethods.randomLinkedList(10, 0, 10);
		System.out.println(head2.printForward());
		deleteDups2(head2);
		System.out.println(head2.printForward());
		
		head2 = AssortedMethods.randomLinkedList(10, 0, 10);
		System.out.println(head2.printForward());
		deleteDups1(head2);
		System.out.println(head2.printForward());
		
	}

	public static Node removeDuplicates(Node head){
		
		Node n1 = head;
		Node n2 = head.next;
		
		if (n1 == null || n2 == null){
			return head;
		}
		
		while (n1 != null){
			n2 = n1.next;
			
			while (n2 != null){
				
				if (n1.data == n2.data){ // Found duplicate value
					head = n1.deleteNode(head, n2.data);
					n2 = n2.next;
				}
				else {
					n2 = n2.next;
				}
			}
			
			if (n1.next != null){
				n1 = n1.next;
			}
			else {
				return head;
			}
		}
		
		return head;
	}
	
	// Time: O(N)
	public static void deleteDups1(LinkedListNode n){
		HashSet<Integer> set = new HashSet<Integer>();
		LinkedListNode previous = null;
		
		while (n != null){
			if (set.contains(n.data)){
				previous.next = n.next;
			}
			else {
				set.add(n.data);
				previous = n;
			}
			n = n.next;
		}
	}
	
	// Time: O(n^2), Space: O(1). In-place, no temporary buffers used in this solution
	public static void deleteDups2(LinkedListNode head){
		if (head == null) return;
		
		LinkedListNode current = head;
		while (current != null){
			// Remove all future nodes that have the same value
			LinkedListNode runner = current;
			while (runner.next != null){
				if (runner.next.data == current.data){
					runner.next = runner.next.next;
				}
				else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}
}
