package Stacks_and_Queues;

public class ThreeStacksUsingOneArray {

	/**
	 * Problem 3.1
	 * @param args
	 */
	static int stackSize = 10;
	static int[] array = new int[stackSize * 3];
	public static void main(String[] args) {
		for (int ii = 0; ii < array.length; ii++){
			array[ii] = -1;
		}
		
		push(4, 0);
		push(2, 0);
		push(10, 1);
		
		for (int ii = 0; ii < array.length; ii++){
			System.out.println(array[ii]);
		}
		pop(0);
		System.out.println("After pop:");
		for (int ii = 0; ii < array.length; ii++){
			System.out.println(array[ii]);
		}
	}
	
	public static void push(int data, int stackNum){
		if (stackNum < 0 || stackNum >= 3){
			return ;
		}

		for (int ii = stackNum * stackSize; ii < ((stackNum + 1)* stackSize) - 1; ii++){
			
			if (array[ii] == -1){
				array[ii] = data;
				break;
			}
		}
	}
	
	public static int pop(int stackNum){
		if (stackNum < 0 || stackNum >= 3){
		return -1;
		}

		int item = -1;

		for (int ii = ((stackNum + 1) * stackSize) - 1; ii >= stackNum * stackSize; ii--){
			if (array[ii] != -1){
				item = array[ii];
				array[ii] = -1;
				break;
			}
		}

		return item;
	}

	public static int peek(int stackNum){
		if (stackNum < 0 || stackNum >= 3){
		return -1;
		}

		int item = -1;
		for (int ii = ((stackNum + 1) * stackSize) - 1; ii >= stackNum * stackSize; ii--){
			if (array[ii] != -1){
				item = array[ii];
			}
		}
		return item;
	}

}
