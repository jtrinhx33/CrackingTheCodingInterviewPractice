package Stacks_and_Queues;

import java.util.Stack;

public class MyQueue{

	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		

		queue.enqueue(2);
		queue.enqueue(3);
		
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}
		
	private Stack<Integer> stack1;	
	private Stack<Integer> stack2;

	public MyQueue(){
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}

	public void enqueue(int data){
		stack1.push(data);
	}

	public int dequeue(){
		
		if (stack2.isEmpty()){
			while (!stack1.isEmpty()){
				int p = stack1.pop();
				stack2.push(p);
			}
		}
	
		if (!stack2.isEmpty()){
			return stack2.pop();
		}

		return 0;
	}
}
