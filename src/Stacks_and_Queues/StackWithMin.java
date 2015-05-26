package Stacks_and_Queues;

public class StackWithMin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		StackWithMin stack = new StackWithMin();
		stack.push(6);
		stack.push(5);
		stack.push(6);
		stack.push(2);
		
		NodeWithMin n = stack.top;
		
		while (n != null){
			System.out.print(n.data + "->");
			n = n.next;
		}
		System.out.println("");
		System.out.println("Min: " + stack.top.min);
		
		stack.pop();
		n = stack.top;
		while (n != null){
			System.out.print(n.data + "->");
			n = n.next;
		}
		System.out.println("");
		System.out.println("Min: " + stack.top.min);
		
		
		stack.pop();
		n = stack.top;
		while (n != null){
			System.out.print(n.data + "->");
			n = n.next;
		}
		System.out.println("");
		System.out.println("Min: " + stack.top.min);
		
		stack.pop();
		n = stack.top;
		while (n != null){
			System.out.print(n.data + "->");
			n = n.next;
		}
		System.out.println("");
		System.out.println("Min: " + stack.top.min);
		
	}
	
	public static NodeWithMin top = null;

	public static void push(int data){
		if (top == null){
			top = new NodeWithMin(data);
			top.min = data;
		}
		else {
			NodeWithMin n = new NodeWithMin(data);
			if (data < top.min) {
				n.min = data;
			}
			else {
				n.min = top.min;
			}
				n.next = top;
				top = n;
		}
	}

	public static NodeWithMin pop(){
		if (top == null) return null;
		NodeWithMin t = top;

		if (top.next == null) {
			top = null;
		}
		else {
			top = top.next;
		}
		
		return t;
	}

	public static int min(){
		if (top == null) return 0;

		return top.min;
	}

}