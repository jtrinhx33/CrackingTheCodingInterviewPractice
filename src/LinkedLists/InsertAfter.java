package LinkedLists;

import CareerCupLibrary.AssortedMethods;
import CareerCupLibrary.LinkedListNode;

public class InsertAfter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
		System.out.println(head.printForward());
		System.out.println(insertAfter(head.next.next.next.next, 123, head)); // delete node 4
		System.out.println(head.printForward());
	}

	public static boolean insertAfter(LinkedListNode item, int data, LinkedListNode head){
	
		if (item == null) { // insert at front of the list
			LinkedListNode front = new LinkedListNode(data, null, null);
			front.next.data = head.data;
			front.next = head.next;
			head = front; // update new head
			
			if (head.next == null) {// update tail if there is only one element
				//tail = head;
			}
			
			return true;
		}
		
		// Insert normally
		LinkedListNode runner = head;
		while (runner != null){
			
			if (item == runner){
				if (runner.next == null){
					runner.next.data = data;
					runner.next.next = null;
					
					//tail = runner.next; // update tail
					return true;
				}
				
				// Not at tail
				LinkedListNode second = new LinkedListNode(0, null, null);
				second.data = runner.next.data;
				second.next = runner.next.next;
				
				// Connect list together
				runner.next.data = data;
				runner.next.next = second;
				
				return true;
			}
			
			runner = runner.next;
			
		}
		return false;
	}
	
}
