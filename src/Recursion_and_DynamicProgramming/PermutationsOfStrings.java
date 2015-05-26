package Recursion_and_DynamicProgramming;

import java.util.ArrayList;

public class PermutationsOfStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "abcd";
		boolean[] isUsed = new boolean[str.length()];
		StringBuilder s = new StringBuilder();
		permute(str, isUsed, 0, s);
		
		/*ArrayList<String> list = getPermutations(str);
		for (String p : list){
			System.out.println(p);
		}*/
		
	}

	// O(n!)
	public static void permute(String str, boolean[] isUsed, int index, StringBuilder s){
		if (str == "" || str == null) return;
		
		if (index == str.length()){
			System.out.println(s);
			return;
		}
		else {
			// Iterate through beginning chars
			for (int ii = 0; ii < str.length(); ii++){
				
				if (isUsed[ii] == false){
					s.append(str.charAt(ii));
					isUsed[ii] = true;
					
					permute(str, isUsed, index + 1, s);
					
					// Reset recently added char
					isUsed[ii] = false;
					s.deleteCharAt(s.length() - 1);
				}
			}
		}
	}
	
	
	// Book's solution
	public static ArrayList<String> getPermutations(String str){
		if (str == null) return null;
		
		ArrayList<String> permutations = new ArrayList<String>();
		
		if (str.length() == 0) { // Base case
			permutations.add("");
			return permutations;
		}
		
		char first = str.charAt(0); // Get the first char
		String remainder = str.substring(1);
		ArrayList<String> words = getPermutations(remainder);
		for (String word : words){
			for (int jj = 0; jj <= word.length(); jj++){
				String s = insertCharAt(word, first, jj);
				permutations.add(s);
			}
		}
		
		return permutations;
	}
	
	public static String insertCharAt(String word, char c, int ii){
		// Separate into two parts and insert character
		String start = word.substring(0, ii);
		String end = word.substring(ii);
		return start + c + end;
	}
}
