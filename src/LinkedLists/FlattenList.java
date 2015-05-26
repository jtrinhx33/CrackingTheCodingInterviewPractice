package LinkedLists;

import java.util.ArrayList;

import CareerCupLibrary.AssortedMethods;
import CareerCupLibrary.LinkedListNode;

public class FlattenList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
		System.out.println(head.printForward());
		
		head.next.child = new LinkedListNode(123123, null, null);
		
		ArrayList<LinkedListNode> list = flattenList(head);
		for (int ii = 0; ii < list.size(); ii++){
			
			System.out.print(list.get(ii).data + " ");
		}
	}

	public static ArrayList<LinkedListNode> flattenList(LinkedListNode head){
		
		if (head == null) return null;
		
		ArrayList<LinkedListNode> list = new ArrayList<LinkedListNode>();
		
		LinkedListNode runner = head;
		
		while (runner != null) {
			list.add(runner);
			runner = runner.next;
		}
		
		// populate array
		int ii = 0;
		while (ii < list.size()){
			
			if (list.get(ii).child != null){
				list.add(list.get(ii).child);
			}
			ii++;
			
		}
		
		return list;
		
	}
	
}
