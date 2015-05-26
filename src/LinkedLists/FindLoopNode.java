package LinkedLists;

import java.util.HashSet;

import CareerCupLibrary.AssortedMethods;
import CareerCupLibrary.LinkedListNode;

public class FindLoopNode {

	/**
	 * Problem 2.6
	 * @param args
	 */
	public static void main(String[] args) {
		
		LinkedListNode list1 = AssortedMethods.randomLinkedList(10, 0, 9);

		LinkedListNode n = list1;
		LinkedListNode nMid = new LinkedListNode();
		
		// Find end of list
		int count = 0;
		while (n != null){
			
			if (count == 3)
				nMid = n;
			
			if (n.next == null && count > 3){
				break;
			}
			
			count++;
			n = n.next;
		}
		// Append to make loop
		n.next = nMid;
		//LinkedListNode out = findLoopNode(list1);
		LinkedListNode out = FindBeginning(list1);
		System.out.println("  " + out.printForward());
	}
	

	public static LinkedListNode findLoopNode(LinkedListNode head){
		
		HashSet<LinkedListNode> list = new HashSet<LinkedListNode>();
		
		LinkedListNode n = head;
		
		if (n == null || n.next == null) return null;
		
		list.add(n); // Add first node
		
		while (n.next != null){
			
			if (list.contains(n.next)){ // Found duplicate
				return n.next;
			}
			else {
				list.add(n.next);
			}
			
			n = n.next;
		}
		return null;
	}
	
	// Book's solution
	public static LinkedListNode FindBeginning(LinkedListNode head){
		LinkedListNode slow = head;
		LinkedListNode fast = head;
		
		// Find meeting point
		// This will be LOOP_SIZE - k steps into the linked list
		while (fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) { // Collision
				break;
			}
		}
		
		// Error check - no meeting point, and therefore no loop
		if (fast == null || fast.next == null){
			return null;
		}
		
		// Move slow to Head
		// Keep fast as meeting point. Each are k steps from the loop start
		// If they move at the same pace, they must meet at Loop Start
		slow = head;
		while (slow != fast){
			slow = slow.next;
			fast = fast.next;
		}
		
		// Both now point to the start of the loop
		return fast;
	}
}
