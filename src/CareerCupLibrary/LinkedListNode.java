package CareerCupLibrary;

public class LinkedListNode {
	public LinkedListNode next;
	public LinkedListNode prev;
	public LinkedListNode child;
	public int data;
	public LinkedListNode(int d, LinkedListNode n, LinkedListNode p) {
		data = d;
		setNext(n);
		setPrevious(p);
		child = null;
	}
	
	public LinkedListNode() {
		// TODO Auto-generated constructor stub
	}

	public void setNext(LinkedListNode n) {
		next = n;
		if (n != null && n.prev != this) {
			n.setPrevious(this);
		}
	}
	
	public void setPrevious(LinkedListNode p) {
		prev = p;
		if (p != null && p.next != this) {
			p.setNext(this);
		}
	}	
	
	public String printForward() {
		if (next != null) {
			return data + "->" + next.printForward();
		} else {
			return ((Integer) data).toString();
		}
	}
}
