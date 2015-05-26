package LinkedLists;

import CareerCupLibrary.LinkedListNode;
import CareerCupLibrary.AssortedMethods;

public class Partition {

	/**
	 * Problem 2.4
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedListNode list1 = AssortedMethods.randomLinkedList(5, 0, 9);
		LinkedListNode list2 = AssortedMethods.randomLinkedList(5, 0, 9);
		System.out.println("Before: ");
		System.out.println(list1.printForward());		
		//System.out.println(list2.printForward());
		
		LinkedListNode n = partition(list1, 4);
		//partition(list2, 4);
		
		System.out.println("After: ");
		System.out.println(n.printForward());		
		//System.out.println(list2.printForward());

	}
	
	public static LinkedListNode partition(LinkedListNode n, int x){
		LinkedListNode nLess = null;
		LinkedListNode nLessHead = null;
		LinkedListNode nGreaterEqualHead = null;
		LinkedListNode nGreaterEqual = null;
		
		if (n == null || n.next == null) return null;
		
		while (n != null){ // Partition input into 2 linked lists
			
			LinkedListNode next = n.next;
			n.next = null;
			if (n.data < x){
				
				if (nLess == null){
					nLessHead = n;
					nLess = nLessHead;
				}
				else {
					nLess.next = n;
					nLess = n;
				}
			}
			else if (n.data >= x){
				if (nGreaterEqual == null){
					nGreaterEqualHead = n;
					nGreaterEqual = nGreaterEqualHead;
				}
				else{
					nGreaterEqual.next = n;
					nGreaterEqual = n;
				}
			}
			n = next;
		}
		
		if (nLessHead == null){
			return nGreaterEqualHead;
		}
		// Merge the two lists
		nLess.next = nGreaterEqualHead;
		
		return nLessHead;
	}

	// Book's solution
	public static LinkedListNode partition2(LinkedListNode node, int x){
		LinkedListNode beforeStart = null;
		LinkedListNode beforeEnd = null;
		LinkedListNode afterStart = null;
		LinkedListNode afterEnd = null;
		
		// Partition list
		while (node != null){
			LinkedListNode next = node.next;
			node.next = null;
			
			if (node.data < x){
				// Insert node into end of before list
				if (beforeStart == null){
					beforeStart = node;
					beforeEnd = beforeStart;
				}
				else{
					beforeEnd.next = node;
					beforeEnd = node;
				}
			}
			else {
				// Insert node into end of after list
				if (afterStart == null){
					afterStart = node;
					afterEnd = afterStart;
				}
				else {
					afterEnd.next = node;
					afterEnd = node;
				}
			}
			node = next;
		}
		
		if (beforeStart == null){
			return afterStart;
		}
		
		// Merge before list and after list
		beforeEnd.next = afterStart;
		return beforeStart;
	}
	
	// Another solution from book to make code a little shorter
	// Start new list using existing nodes
	// Elements larger than pivot are put at tail, and elements smaller are put at head
	// Each time we insert an element, we update either the head or tail
	public static LinkedListNode partition3(LinkedListNode node, int x){
		LinkedListNode head = node;
		LinkedListNode tail = node;
		
		while (node != null){
			LinkedListNode next = node.next;
			 
			if (node.data < x){
				// Insert node at head
				node.next = head;
				head = node;
			}
			else {
				// Insert node at tail
				tail.next = node;
				tail = node;
			}
			node = next;
		}
		tail.next = null;
		
		// The head has changed so we need to return it to user
		return head;
		
	}
	
}
