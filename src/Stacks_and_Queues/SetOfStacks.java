package Stacks_and_Queues;

import java.util.ArrayList;
import java.util.Stack;

public class SetOfStacks {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SetOfStacks stack = new SetOfStacks();
		stack.push(10);
		
	}

	public ArrayList<Stack<Integer>> set = new ArrayList<Stack<Integer>>();
	public int capacity = 10;
	
	public void push(int data) {
		if (set.size() == 0) {
			set.add(new Stack<Integer>());
			set.get(0).push(data);
			return;
		}
		else {
			for (int ii = 0; ii < set.size() - 1; ii++) {
			
				if (set.get(ii).size() < capacity) { // There is space for the data
					set.get(ii).push(data);
				}
				else { // There is no space, create and add new stack to set
					if (ii + 1 >= set.size()) {
						set.add(new Stack<Integer>());
						set.get(ii).push(data);
						return;
					}
					else {
						continue;
					}
				}
			}
		}
	}

	
	public int pop(){

		if (set.size() == 0) return 0;
		int ii = set.size() - 1;
		
		int p = set.get(ii).pop();
		
		if (set.get(ii).size() == 0){
			set.remove(ii);
		}
		
		return p;
	}
	
	public int popAt(int index) {
		if (index < 0 || index > set.size() - 1) return 0;
		int p = set.get(index).pop();
		
		if (set.get(index).size() == 0){
			set.remove(index);
		}
		
		return p;
	}
}
