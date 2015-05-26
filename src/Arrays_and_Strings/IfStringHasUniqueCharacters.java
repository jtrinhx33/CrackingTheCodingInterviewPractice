package Arrays_and_Strings;
/*
 * Implement an algorithm to determine if a string has all unique characters. 
 * What if you cannot use additional data structures?
 */
public class IfStringHasUniqueCharacters {

	/**
	 * 1.1
	 * @param args
	 */
	public static void main(String[] args) {
		
		// My first attempt, Time: O(n^2) Space: O(1)
		System.out.println(IsStringHasUniqueCharacters("mewkitty"));
		
		// Real solution, Time: O(n), Space: O(1)
		System.out.println(isUniqueCharacters("mewkitty"));
		
		// Real solution, Time: O(n), Space: O(1/8)
		System.out.println(isUniqueChars("mewkitty"));
	}

	public static boolean IsStringHasUniqueCharacters(String inputString)
	{
		char[] characterCounter = new char[inputString.length()];
		char[] inputArray = inputString.toCharArray();
		
		for (int ii = 0; ii < inputArray.length; ii++){
			
			for (int jj = 0; jj < characterCounter.length; jj++){
				if (inputArray[ii] == characterCounter[jj])
				{
					return false;
				}
			}
			characterCounter[ii] = inputArray[ii];
		}
		return true;
	}
	
	// Real Solution
	public static boolean isUniqueCharacters(String str)
	{
		if (str.length() > 128) return false;
		
		boolean[] char_set = new boolean[128];
		for (int ii = 0; ii < str.length(); ii++)
		{
			int val = str.charAt(ii);
			if (char_set[val]) // Found this char in string already
				return false;
			char_set[val] = true;
		}
		
		return true;
	}
	
	// Reduce time complexity of solution by a factor of 8 by using a bit vector.
	public static boolean isUniqueChars(String str)
	{
		int checker = 0;
		for (int ii = 0; ii < str.length(); ii++){
			int val = str.charAt(ii) - 'a';
			if ((checker & (1 << val)) > 0){
				return false;
			}
			checker |= (1 << val); // Set it to checker for next iteration
		}
		
		return true;
	}
}
