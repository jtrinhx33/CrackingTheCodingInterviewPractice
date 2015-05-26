package Stacks_and_Queues;

import java.util.LinkedList;
import java.util.Stack;

public class SortStackAscendingOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(10);
		stack.push(9);
		stack.push(8);
		stack.push(7);
		stack.push(6);
		stack.push(5);
		stack.push(4);
		stack.push(3);
		stack.push(2);
		stack.push(1);
		
		/*Stack<Integer> stack1 = stack;
		System.out.println("Before:");
		while (!stack.isEmpty()){
			System.out.println(stack.pop());
		}*/
		
		
		
		Stack<Integer> stack2 = sortAscending(stack);
		
		System.out.println("After:");
		while (!stack2.isEmpty()){
			System.out.println(stack2.pop());
		}

	}

	public static Stack<Integer> sortAscending(Stack<Integer> stack){

		if (stack == null || stack.isEmpty()) return stack;	
		
		Stack<Integer> stack2 = new Stack<Integer>();
		int count = stack.size();

		for (int ii = 0; ii < stack.size(); ii++){
			int min = stack.peek();

			while (!stack.isEmpty()){
				int p = stack.pop();
				if (p < min){
					min = p;
				}
				
				stack2.push(p);
			}

			boolean isFound = false;
			for (int jj = 0; jj < count; jj++){
				int p = stack2.pop();
				if (p == min && isFound == false){
					isFound = true;
				}
				else {
					stack2.push(p);
				}
			}
			count--;
		}

		// Stack 2 now contains all sorted values
		return stack2;
	}

}
