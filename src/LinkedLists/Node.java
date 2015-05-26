package LinkedLists;

/**
 * Linked List node class
 * @author Jeannie
 *
 */
public class Node {
	
	Node next = null;
	int data;
	
	/**
	 * Constructor for Node: Singly linked list
	 * @param d
	 */
	public Node(int d){
		data = d;
	}
	
	public void appendToTail(int d){
		Node end = new Node(d);
		Node n = this;
		
		// Get to last node in list
		while (n.next != null){
			n = n.next; // Move to next node in list
		}
		n.next = end;
	}
	
	public Node deleteNode(Node head, int d){
		
		Node n = head;
		
		// For the case that head is the node we want to delete
		if (n.data == d){
			return head.next; // Moved head
		}
		
		while (n.next != null){
			if (n.next.data == d){
				n.next = n.next.next; // Set "next" node to point to the one after (a.k.a. deleting the one we found
				return head; // Head didn't change
			}
			n = n.next;
		}
		return head;
	}
	
	
	
	public String printForward() {
		if (next != null) {
			return data + "->" + next.printForward();
		} else {
			return ((Integer) data).toString();
		}
	}
}
