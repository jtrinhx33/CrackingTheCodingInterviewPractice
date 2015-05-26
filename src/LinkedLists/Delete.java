package LinkedLists;

import CareerCupLibrary.AssortedMethods;
import CareerCupLibrary.LinkedListNode;

public class Delete {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
		System.out.println(head.printForward());
		delete(head.next.next.next.next, head); // delete node 4
		System.out.println(head.printForward());
	}

	public static boolean delete(LinkedListNode item, LinkedListNode head){
		if (item == null) return true;
		
		LinkedListNode runner = head;
		
		if (head == item){
			head = head.next;
			// update tail if this is only element in list
			if (head.next == null){
				//tail.data = head.data;
				//tail.next = head.next;
			}
			// When original list was only 1 element in it
			if (head == null) {
				//tail = null;
			}
			return true;
		}
		
		while (runner.next != null){
			
			if (runner.next == item){
				runner.data = runner.next.data;
				runner.next = runner.next.next;
				
				if (runner.next == null){ // update tail if necessary
					//tail.next = runner.next;
					//tail.data = runner.data;
				}
				
				return true;
			}
			runner = runner.next;
		}
		return false;
	}
	
}
