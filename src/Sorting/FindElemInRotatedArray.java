package Sorting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FindElemInRotatedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] array = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
		//int[] array = {50, 5, 20, 30, 40};
		//System.out.println(find(array, 5));
		//System.out.println(search(array, 0, array.length - 1, 5));
		
	}
	
	public static List<String> foo(){ 
		List<String> L = new LinkedList<String>(); 
		L.add("yo");
		return L; 
	}

	public static int find(int[] array, int elem){
		if (array == null || array.length == 0){
			return -1;
		}
		
		int start = 0;
		int end = array.length - 1;
		int mid = ((end - start) / 2) + start;
		
		while (start <= end){
			mid = ((end - start) / 2) + start;
			if (array[mid] == elem)
				return mid;
			
			/*if (array[start] <= elem){
				end = mid;
			}
			else if (array[end] >= elem){
				start = mid;
			}*/
			
			if (array[start] >= array[mid]){
				end = mid;
			}
			else if (array[end] >= array[mid]){
				start = mid;
			}
			
			// Last element
			if (start == end && array[start] != elem)
				return -1;
		}
		
		return -1;
	}
	
	
	// Book's solution. O(log n), but realistically O(n) because we can easily end up searching both halves
	public static int search(int[] array, int left, int right, int x){
		
		int mid = (left + right) / 2;
		
		if (x == array[mid]) return mid; // Found element
		
		if (right < left){
			return -1;
		}
		
		// Either the left or right half must be normally ordered.
		// Find out which side is normally ordered, and then use the normally ordered half
		// to figure out which side to search to find x.
		if (array[left] < array[mid]) { // Left is normally ordered
			if (x >= array[left] && x <= array[mid]){
				return search(array, left, mid - 1, x); // Search  left
			}
			else {
				return search(array, mid + 1, right, x); // Search right
			}
		}
		else if (array[mid] < array[left]){ // Right is normally ordered
			if (x >= array[mid] && x <= array[right]){
				return search(array, mid + 1, right, x); // Search right
			}
			else {
				return search(array, left, mid - 1, x); // Search left
			}
		}
		else if (array[left] == array[mid]){ // Left half is all repeats
			if (array[mid] != array[right]){ // If right is diff., search it
				return search(array, mid + 1, right, x); // Search right
			}
			else { // Else, we have to search both halves
				int result = search(array, left, mid - 1, x); // Search left
				if (result == -1){
					return search(array, mid + 1, right, x); // Search right
				}
				else {
					return result;
				}
			}
		}
		return -1;
	}
	
	
}
