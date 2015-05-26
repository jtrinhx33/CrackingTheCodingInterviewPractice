package Arrays_and_Strings;

public class IsTwoStringsPermutations {

	/**
	 * Problem 1.3
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Time: O(n^2), Space: 
		System.out.println(IsPermutation("cat", "atc"));
		
		System.out.println(permutation1("cat", "atc"));
		
		System.out.println(permutation2("cat", "atc"));
	}

	// My solution (does not count white spaces as significant)
	public static boolean IsPermutation(String firstStr, String secondStr)
	{
		boolean[] firstStrCheck = new boolean[firstStr.length()];
		
		for (int ii = 0; ii < firstStrCheck.length; ii++){
			firstStrCheck[ii] = false;
		}
		
		for (int ii = 0; ii < secondStr.length(); ii++){
			
			for (int jj = 0; jj < firstStr.length(); jj++){
				
				if (secondStr.charAt(ii) == firstStr.charAt(jj) && firstStrCheck[jj] == false)
					firstStrCheck[jj] = true;
			}
		}
		
		for (int ii = 0; ii < firstStrCheck.length; ii++){
			
			if (firstStrCheck[ii] == false)
				return false;
		}
		
		return true;
	}
	
	// Real solution
	public static String sort(String s)
	{
		char[] content = s.toCharArray();
		java.util.Arrays.sort(content);
		
		return new String(content);
	}
	// Solution 1
	public static boolean permutation1(String s, String t){
		if (s.length() != t.length()){
			return false;
		}
		return sort(s).equals(sort(t));
	}
	
	// Solution 2
	public static boolean permutation2(String s, String t)
	{
		if (s.length() != t.length()){
			return false;
		}
		
		int letters[] = new int[182]; // Assuming we are using ASCII strings
		char[] s_array = s.toCharArray();
		
		for (char c : s_array){
			// count number of each char in s.
			letters[c]++;
		}
		
		for (int ii = 0; ii < t.length(); ii++){
			int c = (int)t.charAt(ii);
			if (--letters[c] < 0){
				return false;
			}
		}
		
		return true;
	}
}
