package Recursion_and_DynamicProgramming;

public class FindMagicIndex {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//int[] array = {-10, -2, 0, 1, 2, 3, 6, 10, 20};
		int[] array = {-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13};
		//System.out.println("Magic index: " + findMagicIndex(array, 0, array.length - 1));
		//System.out.println("Magic index: " + findMagicIndexNonDistinctValues(array, 0, array.length - 1));
		System.out.println("Magic index: " + magicFast(array, 0, array.length - 1));
	}

	// O(log n) time?
	public static int findMagicIndex(int[] array, int start, int end){
		if (array.length <= 0) return -1;
		if (end < start || start < 0 || end > array.length) return -1;
				
		int mid = (end + start) / 2;
		
		if (array[mid] == mid)	// Found 
			return mid;
		else if (array[mid] < mid){ // Prepare right half
			
			return findMagicIndex(array, mid + 1, end);
		}
		else if (array[mid] > mid){ // Prepare left half
			
			return findMagicIndex(array, start, mid - 1);
		}
		return -1;
	}
	
	// O(log n) time?
	public static int findMagicIndexNonDistinctValues(int[] array, int start, int end){
		if (array.length <= 0) return -1;
		if (end < start || start < 0 || end > array.length) return -1;
				
		int mid = (end + start) / 2;
		
		if (array[mid] == mid)	// Found 
			return mid;
		
		else if (array[mid] < mid){ // Prepare right half
			start = Math.max(mid + 1, array[mid]);
			return findMagicIndex(array, start, end);
		}
		
		else if (array[mid] > mid){ // Prepare left half
			end = Math.min(mid - 1, array[mid]);
			return findMagicIndex(array, start, end);
		}
		return -1;
	}
	
	// Book's solution
	public static int magicFast(int[] array, int start, int end){
		if (array.length <= 0) return -1;
		if (end < start || start < 0 || end > array.length) return -1;
				
		int midIndex = (end + start) / 2;
		int midValue = array[midIndex];
		
		if (midIndex == midValue)	// Found 
			return midIndex;
		
		// Search left
		int leftIndex = Math.min(midIndex - 1,  midValue);
		int left = magicFast(array, start, leftIndex);
		if (left >= 0){
			return left;
		}
		
		// Seach right
		int rightIndex = Math.max(midIndex + 1, midValue);
		int right = magicFast(array, rightIndex, end);
		
		return right;
	}
}
