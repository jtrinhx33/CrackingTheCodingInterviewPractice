package Sorting;

public class SelectionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {211, 67, 10, 22, 44, 103, 89, 22, 24, 23, 79, 64};
		
		System.out.print("Unsorted: ");
		for (int ii = 0; ii < array.length; ii++){
			System.out.print(array[ii] + " ");
		}
		
		System.out.println();
		System.out.print("Sorted: ");
		int[] result = SelectionSort(array);
		
		for (int ii = 0; ii < result.length; ii++){
			System.out.print(result[ii] + " ");
		}
	}

	public static int[] SelectionSort(int[] array){
		
		for (int ii = 0; ii < array.length; ii++){
			
			int currentMin = array[ii];
			int currentMinIndex = ii;
			
			for (int jj = ii + 1; jj < array.length; jj++){
				
				if (array[jj] < currentMin){
					currentMin = array[jj];
					currentMinIndex = jj;
				}
				
			}
			
			// Swap next smallest element with current index
			int temp = array[ii];
			array[ii] = array[currentMinIndex];
			array[currentMinIndex] = temp;
			
		}
		
		return array;
		
	}
	
}
