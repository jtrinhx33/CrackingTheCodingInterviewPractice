package Sorting;

public class BubbleSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] array = {1, 6, 10, 22, 44, 103, 89, 22, 24, 23};
		
		System.out.print("Unsorted: ");
		for (int ii = 0; ii < array.length; ii++){
			System.out.print(array[ii] + " ");
		}
		
		System.out.println();
		System.out.print("Sorted: ");
		int[] result = BubbleSort(array);
		
		for (int ii = 0; ii < result.length; ii++){
			System.out.print(result[ii] + " ");
		}
		
	}

	public static int[] BubbleSort(int[] array){
		
		for (int ii = 0; ii < array.length; ii++){
			
			boolean isSwapped = false;
			for (int jj = ii + 1; jj < array.length; jj++){
				
				if (isSwapped){ 
					continue;
				}
				
				if (array[jj - 1] > array[jj]){ // Swap if first value in pair is greater than second value
					int temp = array[jj - 1];
					array[jj - 1] = array[jj];
					array[jj] = temp;
					isSwapped = true;
				}
				
			}
		}
		
		return array;
	}
	
	
	
}
