package LinkedLists;

import java.util.ArrayList;

import CareerCupLibrary.AssortedMethods;
import CareerCupLibrary.LinkedListNode;

public class Sum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedListNode list1 = AssortedMethods.randomLinkedList(4, 0, 9);
		LinkedListNode list2 = AssortedMethods.randomLinkedList(3, 0, 9);
		LinkedListNode list3 = sum(list1, list2);
		System.out.println("  " + list1.printForward());		
		System.out.println("+ " + list2.printForward());			
		System.out.println("= " + list3.printForward());	
		
		int l1 = linkedListToInt(list1);
		int l2 = linkedListToInt(list2);
		int l3 = linkedListToInt(list3);
		
		System.out.print(l1 + " + " + l2 + " = " + l3 + "\n");
		System.out.print(l1 + " + " + l2 + " = " + (l1 + l2));
		
		System.out.print("\n\n");
		
		// Book's solution, test
		list1 = AssortedMethods.randomLinkedList(3, 0, 9);
		list2 = AssortedMethods.randomLinkedList(3, 0, 9);
		list3 = addLists(list1, list2, 0);
		System.out.println("  " + list1.printForward());		
		System.out.println("+ " + list2.printForward());			
		System.out.println("= " + list3.printForward());	
		
		l1 = linkedListToInt(list1);
		l2 = linkedListToInt(list2);
		l3 = linkedListToInt(list3);
		System.out.print(l1 + " + " + l2 + " = " + l3 + "\n");
		System.out.print(l1 + " + " + l2 + " = " + (l1 + l2));
	}

	public static int linkedListToInt(LinkedListNode node) {
		int value = 0;
		if (node.next != null) {
			value = 10 * linkedListToInt(node.next);
		}
		return value + node.data;
	}
	
	public static LinkedListNode sum(LinkedListNode n1, LinkedListNode n2){
		
		if (n1 == null && n2 == null) return null;
		if (n1 == null && n2 != null) return n2;
		if (n1 != null && n2 == null) return n1;
		
		int digit_n1;
		int digit_n2;
		int carry = 0;
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		while (n1 != null && n2 != null){
			
			digit_n1 = n1.data;
			digit_n2 = n2.data;
			
			int sum = digit_n1 + digit_n2 + carry; // Sum
			
			// Compute carry
			if (sum >= 10){
				carry = 1;
			}
			else
				carry = 0;
			
			result.add(sum % 10); // Store digit
			
			n1 = n1.next;
			n2 = n2.next;
		}
		
		if (n1 == null && n2 == null){
			if (carry > 0){
				result.add(carry);
			}
		}
		else{
		
			while (n1 != null){ // n2 is done
					int sum = n1.data + carry;
					if (sum >= 10) carry = 1;
					else carry = 0;
					result.add(sum % 10);
				n1 = n1.next;
			}
			
			while(n2 != null){ // n1 is done
				int sum = n2.data + carry;
				if (sum >= 10) carry = 1;
				else carry = 0;
				result.add(sum % 10);
				n2 = n2.next;
			}
		}
		
		// Create LinkedList to return
		LinkedListNode n = null;
		LinkedListNode nHead = null;
		
		for (int ii = 0; ii < result.size(); ii++){
			if (n == null){
				n = new LinkedListNode(result.get(ii), null, null);
				nHead = n;
			}
			else{
				n.next = new LinkedListNode(result.get(ii), null, null);
				n = n.next;
			}
		}
		//n.next = null;
		
		return nHead;
	}
	
	public static LinkedListNode sum2(LinkedListNode n1, LinkedListNode n2){
		if (n1 == null && n2 == null) return null;
		if (n1 == null && n2 != null) return n2;
		if (n1 != null && n2 == null) return n1;
		
		int carry = 0;
		ArrayList<Integer> result = new ArrayList<Integer>();
		ArrayList<Integer> N1 = new ArrayList<Integer>();
		ArrayList<Integer> N2 = new ArrayList<Integer>();
		
		// Store all digits
		while (n1 != null){
			N1.add(n1.data);
			n1 = n1.next;
		}
		
		// Store all digits
		while (n2 != null){
			N2.add(n2.data);
			n2 = n2.next;
		}
		
		int ii_n1 = N1.size() - 1;
		int ii_n2 = N2.size() - 1;
		
		while (ii_n1 >= 0 && ii_n2 >= 0){
			int digit_n1 = N1.get(ii_n1);
			int digit_n2 = N2.get(ii_n2);
			
			int sum = digit_n1 + digit_n2 + carry;
			if (sum >= 10) carry = 1;
			else carry = 0;
			
			result.add(sum %10);
			ii_n1--;
			ii_n2--;
		}
		
		if (ii_n1 < 0 && ii_n2 < 0){
			if (carry > 0) result.add(carry);
		}
		else {
			while (ii_n1 >= 0){
				int sum = N1.get(ii_n1) + carry;
				if (sum >= 10) carry = 1;
				else carry = 0;
				result.add(sum %10);
				ii_n1--;
			}
			
			while (ii_n2 >= 0){
				int sum = N2.get(ii_n2) + carry;
				if (sum >= 10) carry = 1;
				else carry = 0;
				result.add(sum %10);
				ii_n2--;
			}
		}
		
		// Create LinkedList to return
		LinkedListNode n = null;
		LinkedListNode nHead = null;
		
		for (int ii = result.size() - 1; ii >= 0; ii--){
			if (n == null){
				n = new LinkedListNode(result.get(ii), null, null);
				nHead = n;
			}
			else{
				n.next = new LinkedListNode(result.get(ii), null, null);
				n = n.next;
			}
		}
		//n.next = null;
		
		return nHead;
	}
	
	// Book's solution
	public static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry){
		if (l1 == null && l2 == null && carry == 0){
			return null;
		}
		
		LinkedListNode result = new LinkedListNode();
		int value = carry;
		if (l1 != null){
			value += l1.data;
		}
		if (l2 != null){
			value += l2.data;
		}
		
		result.data =  value % 10; // Second digit of number
		
		// Recurse
		if (l1 != null || l2 != null){
			LinkedListNode more = addLists(l1 == null ? null : l1.next,
											l2 == null ? null : l2.next,
											value >= 10 ? 1 : 0);
			result.setNext(more);
		}
		
		return result;
	}
	
	public static class PartialSum{
		public LinkedListNode sum = null;
		public int carry = 0;
	}
	
	/*public static LinkedListNode addLists2(LinkedListNode l1, LinkedListNode l2){
		int len1 = length(l1);
		int len2 = length(l2);
		
		// Pad the shorter list with zeros
		if (len1 < len2){
			l1 = padList(l1, len2 - len1);
		}
		else {
			l2 = padList(l2, len1 - len2);
		}
		
		// Add lists
		PartialSum sum = addListsHelper(l1, l2);
		
		// If there was a carry value left over, insert this at the front of the list. Otherwise, just return the linked list.
		if (sum.carry == 0){
			return sum.sum;
		}
		else{
			LinkedListNode result = insertBefore(sum.sum, sum.carry);
			return result;
		}
		
	}*/
	
	public static PartialSum addListsHelper(LinkedListNode l1, LinkedListNode l2){
		if (l1 == null && l2 == null){
			PartialSum sum = new PartialSum();
			return sum;
		}
		// Add smaller digits recursively
		PartialSum sum = addListsHelper(l1.next, l2.next);
		
		// Add carry to current data
		int val = sum.carry + l1.data + l2.data;
		
		// Insert sum of current digits
		LinkedListNode full_result = insertBefore(sum.sum, val % 10);
		
		// Return sum so far, and the carry value
		sum.sum = full_result;
		
		sum.carry = val / 10;
		return sum;
	}
	
	// Pad the list with zeros
	public static LinkedListNode padList(LinkedListNode l, int padding){
		LinkedListNode head = l;
		for (int ii = 0; ii < padding; ii++){
			LinkedListNode n = new LinkedListNode(0, null, null);
			head.prev = n;
			n.next = head;
			head = n;
		}
			return head;
	}
	
	// Helper function to insert node in the front of a linked list
	public static LinkedListNode insertBefore(LinkedListNode list, int data){
		LinkedListNode node = new LinkedListNode(data, null, null);
		if (list != null){
			list.prev = node;
			node.next = list;
		}
		return node;
	}
}
