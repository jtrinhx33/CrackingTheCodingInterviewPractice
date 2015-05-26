package Sorting;

public class MergeSort {

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
		MergeSort(array);
		
		for (int ii = 0; ii < array.length; ii++){
			System.out.print(array[ii] + " ");
		}
	}

	public static void MergeSort(int[] array){
		
		int[] helper = new int[array.length];
		MergeSort(array, helper, 0, array.length - 1);
		
	}
	
	public static void MergeSort(int[] array, int[] helper, int low, int high){
		
		if (low < high){
			int middle = (low + high) / 2;
			
			MergeSort(array, helper, low, middle); // Sort left half
			MergeSort(array, helper, middle, high); // Sort right half
			Merge(array, helper, low, middle, high); // Merge them
		}
	}
	
	public static void Merge(int[] array, int[] helper, int low, int middle, int high){
		
		// Copy both halves into a helper array
		for (int ii = 0; ii <= high; ii++){
			helper[ii] = array[ii];
		}
		
		int helperLeft = low;
		int helperRight = middle + 1;
		int current = low;
		
		// Iterate through helper array, compare the left and right half, 
		// copying back the smaller element from the two halves into the original array
		while (helperLeft <= middle && helperRight <= high){
			if (helper[helperLeft] <= helper[helperRight]){
				array[current] = helper[helperLeft];
				helperLeft++;
			}
			else { // If right element is smaller than left element
				
				array[current] = helper[helperRight];
				helperRight++;
			}
			current++;
		}
		
		// Copy the rest of the left side of the array into the target array
		int remaining = middle - helperLeft;
		for (int ii = 0; ii <= remaining; ii++){
			array[current + ii] = helper[helperLeft + ii];
		}
	}
}
