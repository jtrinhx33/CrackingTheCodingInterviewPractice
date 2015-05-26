package Sorting;

public class FindStringFromSortedArrayContainingEmptyStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String[] array = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
		int index = find(array, 0, array.length - 1, "ball");
		System.out.println(index);
	}

	public static int find(String[] array, int left, int right, String elem){
		
		int mid = (left + right) / 2;
		if (array[mid] == elem) return mid;
		if (left > right) return -1;
		
		if (array[mid] == ""){
			boolean word_on_right = false;
			
			for (int ii = mid; ii < right; ii++){
				if (array[ii] != ""){
					mid = ii;
					word_on_right = true;
					break;
				}
			}
			
			if (!word_on_right){ // Look for next non-empty string on left side
				for (int ii = mid; ii >= left; ii--){
					if (array[ii] != ""){
						mid = ii;
						break;
					}
				}
			}
		}
		
		// Binary search
		if (array[mid] == elem){
			return mid;
		}
		//else if (array[mid] < elem){ // Search right
		else if (IsLessThan(array[mid], elem)){ // Search right
			return find(array, mid + 1, right, elem);
		}
		//else if (array[mid] > elem){
		else if (!IsLessThan(array[mid], elem)){
			return find(array, left, mid - 1, elem);
		}
		
		return -1;
	}
	
	public static boolean IsLessThan(String s1, String s2){
		
		for (int ii = 0; ii < Math.min(s1.length(), s2.length()); ii++){
			
			if (s1.charAt(ii) < s2.charAt(ii)){
				return true;
			}
			else if (s1.charAt(ii) > s2.charAt(ii)){
				return false;
			}
		}
		
		return s1.length() < s2.length();
		
	}
	
	// Book's solution
	public static int searchR(String[] strings, String str, int first, int last){
		
		if (first > last) return -1;
		
		// Move mid to middle
		int mid = (last + first) / 2;
		
		// If mid is empty, find closest non-empty string
		if (strings[mid].isEmpty()){
			int left = mid - 1;
			int right = mid + 1;
			while (true){
				if (left < first && right > last){
					return -1;
				}
				else if (right <= last && !strings[right].isEmpty()){
					mid = right;
					break;
				}
				else if (left >= first && !strings[left].isEmpty()){
					mid = left;
					break;
				}
				right++;
				left--;
			}
		}
		
		// Check for string, and recurse if necessary
		if (str.equals(strings[mid])){ // Found it!
			return mid;
		}
		else if (strings[mid].compareTo(str) < 0){ // Search right
			return searchR(strings, str, mid + 1, last);
		}
		else { // Search left
			return searchR(strings, str, first, mid - 1);
		}
	}
	
	public static int search(String[] strings, String str){
		if (strings == null || str == null || str == ""){
			return -1;
		}
		
		return searchR(strings, str, 0, strings.length - 1);
	}
}
