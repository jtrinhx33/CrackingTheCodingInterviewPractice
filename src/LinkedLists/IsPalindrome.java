package LinkedLists;

import java.util.ArrayList;
import java.util.Stack;

import CareerCupLibrary.AssortedMethods;
import CareerCupLibrary.LinkedListNode;

public class IsPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//LinkedListNode root = AssortedMethods.randomLinkedList(10, 0, 9);
		//list1.printForward();
		
		LinkedListNode root = new LinkedListNode(0, null, null);
		LinkedListNode prev = root;
		int data = 1;
		LinkedListNode next = new LinkedListNode(data, null, null);
		prev.setNext(next);
		prev = next;
		
		data = 2;
		next = new LinkedListNode(data, null, null);
		prev.setNext(next);
		prev = next;
		
		data = 1;
		next = new LinkedListNode(data, null, null);
		prev.setNext(next);
		prev = next;
		
		data = 0;
		next = new LinkedListNode(data, null, null);
		prev.setNext(next);
		prev = next;
		
		System.out.println(root.printForward());
		LinkedListNode reversed = reverseList(root);
		System.out.println(reversed.printForward());
		
		System.out.println(isPalindrome(root));
	}

	public static LinkedListNode reverseList(LinkedListNode head){
		LinkedListNode n = head;
		ArrayList<Integer> array = new ArrayList<Integer>();
		
		if (n == null) return null;
		
		while (n != null){
			array.add(n.data);
			n = n.next;
		}
		
		LinkedListNode N = null;
		N = new LinkedListNode(array.get(array.size() - 1), null, null);
		LinkedListNode NHead = N;
		
		for (int ii = array.size() - 2; ii >= 0; ii--){
			N.next = new LinkedListNode(array.get(ii), null, null);
			N = N.next;
		}
		return NHead;
		
	}
	
	public static boolean isPalindrome(LinkedListNode head){
		LinkedListNode n = head;
		LinkedListNode nReverse = n;
		
		nReverse = reverseList(nReverse);
		if (head == null) return false;
		while (head != null){
			if (head.data != nReverse.data){
				return false;
			}
			head = head.next;
			nReverse = nReverse.next;
		}
		return true;
	}
	
	// Book's solution
	public static boolean isPalindrome2(LinkedListNode head){
		LinkedListNode fast = head;
		LinkedListNode slow = head;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		// Push elements from first half of linked list onto stack.
		// When fast runner (which is moving at 2x speed), reaches the end of the linked list,
		// then we know we're at the middle
		while (fast != null && fast.next != null){
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		// Has odd number of elements, so skip the middle element
		if (fast != null){
			slow = slow.next;
		}
		
		while (slow != null){
			slow = slow.next;
		}
		
		while (slow != null){
			int top = stack.pop().intValue();
			
			// If values are different, then its not a palindrome
			if (top != slow.data){
				return false;
			}
			slow = slow.next;
		}
		return true;
	}
	
	// Book's solution 2: Recursive
	public static class Result{
		public Result(LinkedListNode node, boolean b) {
			this.node = node;
			this.result = b;
		}
		public LinkedListNode node;
		public boolean result;
	}
	
	public static Result isPalindromeRecurse(LinkedListNode head, int length){
		if (head == null || length == 0){
			return new Result(null, true);
		}
		else if (length == 1){
			return new Result(head.next, true);
		}
		else if (length == 2){
			return new Result(head.next.next, head.data == head.next.data);
		}
		
		Result res = isPalindromeRecurse(head.next, length - 2);
		if (!res.result || res.node == null){
			return res;
		}
		else {
			res.result = head.data == res.node.data;
			res.node = res.node.next;
			return res;
		}
	}
	
	public static boolean isPalindrome3(LinkedListNode head){
		//Result p = isPalindromeRecurse(head, listSize(head));
		//return p.result;
		return false;
	}
}
