package Arrays_and_Strings;

public class IsSubstring {

	/**
	 * Problem 1.8
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean isRotation(String s1, String s2){
		
		// Check if s1 is permutation of s2
		int[] char_Array = new int[128];
		
		for (int ii = 0; ii < s1.length(); ii++){
			char c = s1.charAt(ii);
			char_Array[c]++;
		}
		
		for (int ii = 0; ii < s2.length(); ii++){
			char c = s2.charAt(ii);
			if (--char_Array[c] < 0)
				return false;
		}
		
		// Find matching char
		StringBuilder s = new StringBuilder();
		int index = 0;
		
		for (int ii = 0; ii < s1.length(); ii++){
			boolean isMatch = false;
			
			for (int jj = 0; jj < s2.length(); jj++){
				
				
				if (s1.charAt(ii) == s2.charAt(jj)){
					
					// Found matching char (initial)
					int iiOriginal = ii;
					if (s1.charAt(ii) == s2.charAt(jj)){
						isMatch = true;
						ii++;
						
						for (int kk = jj + 1; kk < s2.length(); kk++){
							
							if (s1.charAt(ii) != s2.charAt(kk)){
								isMatch = false;
							}
							else {
								ii++;
							}
						}
						
						if (isMatch == true){
							index = jj;
							break;
						}
						
						ii = iiOriginal;
					}					
				}
				
				if (isMatch == true)
					break;
			}
			
			if (isMatch == true)
				break;
			else {
				index = 0;
			}
		}
		
		String subS2 = s2.substring(0, index);
		
		return isSubstring(s1, subS2);
	}
	
	// Book's solution (much better and shorter)
	public static boolean IsRotation(String s1, String s2){
		int length = s1.length();
		
		// Check that s1 and s2 are equal length and not empty
		if (length == s2.length() && length > 0){
			
			// Concatenate s1 and s1 with new buffer
			String s1s1 = s1 + s1;
			return isSubstring(s1s1, s2);
		}
		
		return false;
	}

	// Assumed method
	private static boolean isSubstring(String s1s1, String s2) {
		// TODO Auto-generated method stub
		return false;
	}

}
