package LinkedLists;

import CareerCupLibrary.AssortedMethods;
import CareerCupLibrary.LinkedListNode;

public class KthToLast {

	/**
	 * Problem 2.2
	 * @param args
	 */
	public static void main(String[] args) {
		
		// My solution
		LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
		System.out.println(head.printForward());
		int nth = 7;
		LinkedListNode n = kthToLast(head, nth);
		if (n != null) {
			System.out.println(nth + "th to last node is " + n.data);
		} else {
			System.out.println("null");
		}
		
		
		LinkedListNode headPIExposed = AssortedMethods.randomLinkedList(10, 0, 10);
		System.out.println(headPIExposed.printForward());
		int m = 7;
		LinkedListNode N = MthToLast(headPIExposed, m);
		if (N != null) {
			System.out.println(nth + "th to last node is " + N.data);
		} else {
			System.out.println("null");
		}
		
		
		
		LinkedListNode head2 = AssortedMethods.randomLinkedList(10, 0, 10);
		System.out.println(head2.printForward());
		nth = 7;
		n = nthToLast(head2, nth);
		if (n != null) {
			System.out.println(nth + "th to last node is " + n.data);
		} else {
			System.out.println("null");
		}
		
		
	}
	
	public static LinkedListNode MthToLast(LinkedListNode head, int m){
		if (head == null) return null;
		if (m < 0) return null;
		
		LinkedListNode runner = head;
		LinkedListNode n = head;
		
		int counter = 0;
		
		while (runner != null){
			
			if (counter == m){
				n = head;
			}
			else if (counter > m){
				n = n.next;
			}
			
			counter++;
			runner = runner.next;
		}
		
		if (counter < m)
			return null;
		
		return n;
	}
	

	public static LinkedListNode kthToLast(LinkedListNode head, int k){
		if (head == null) return null;
		LinkedListNode n = head;
		LinkedListNode kTracker = null;
		int counter = 1;
		
		while (n != null){
			
			if (n.next != null){
				counter++;
				
				if (counter == k){
					kTracker = head;
				}
				else if (counter >= k){
					kTracker = kTracker.next;
				}
				n = n.next;
			}
			else {
				return kTracker;
			}
		}
		
		if (counter < k)
			return kTracker;
		
		return kTracker;
	}
	
	// Book's solution
	// Time: O(n), Space: O(n)
	public static LinkedListNode nthToLast(LinkedListNode head, int n) {
		if (n <= 0) return null;
		
		if (head == null || n < 1) {
			return null;
		}

		LinkedListNode p1 = head;
		LinkedListNode p2 = head;
		for (int j = 0; j < n - 1; ++j) { // skip n-1 steps ahead
			if (p2 == null) {
				return null; // not found since list size < n
			}
			p2 = p2.next;
		}
		if (p2 == null) {
			return null;
		}
		while (p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
	  	}
	  	return p1;
	}
	
	// O(n) space
	public static int nthToLastRecursive(LinkedListNode head, int k){
		if (head == null) return 0;
		
		int ii = nthToLastRecursive(head.next, k) + 1;
		if (ii == k){
			System.out.println(head.data);
		}
		
		return ii;
	}
}
