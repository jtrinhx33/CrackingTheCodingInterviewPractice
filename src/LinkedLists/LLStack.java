package LinkedLists;

import CareerCupLibrary.LinkedListNode;

public class LLStack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LLStack stack = new LLStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.push(7);
		stack.push(8);
		stack.push(9);
		stack.push(10);
		
		for (int ii = 0; ii < 10; ii++){
			
			System.out.println(stack.pop().data);
		}
	}
	
	public LinkedListNode top;
	
	public LLStack(){
		
		top = null;
	}
	
	public void push(int data){
		
		if (top == null){
			
			top = new LinkedListNode(data, null, null);
			return;
		}
		
		LinkedListNode newTop = new LinkedListNode(data, null, null);
		newTop.next = top;
		top = newTop;
		
	}
	
	public LinkedListNode pop(){
		
		if (top == null) return null;
		
		LinkedListNode retNode = top;
		top = top.next;
		return retNode;
	}

}
