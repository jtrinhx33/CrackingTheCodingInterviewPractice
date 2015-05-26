package Arrays_and_Strings;

public class CompressString {

	/**
	 * Problem 1.5
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(compress("aabcccccaaa"));
		System.out.println(compressBad("aabcccccaaa"));
		System.out.println(compressGood("aabcccccaaa"));
		System.out.println(compressAlternate("aabcccccaaa"));
	}
	
	public static String compress(String str){
		
		if (str == "" || str == null)
			return str;
		
		StringBuilder s = new StringBuilder();
		char[] charArray = str.toCharArray();
		
		int count = 1;
		char c = charArray[0];
		
		for (int ii = 1; ii < charArray.length; ii++){
			
			if (c == charArray[ii]){
				count++;
			}
			else {
				s.append(c);		// 
				s.append(count);	// 
				count = 1;			// Reset to first count
				c = charArray[ii]; 	// Set next char to check for repeats
			}
		}
		
		// Append last character and count of it
		s.append(c);
		s.append(count);
		
		if (s.length() > str.length()){
			return str;
		}
		
		return s.toString();
	}
	
	// From book
	public static String compressBad(String str){
		String mystr = "";
		char last = str.charAt(0);
		int count = 1;
		for (int ii = 1; ii < str.length(); ii++){
			if (str.charAt(ii) == last){ // Found repeat char
				count++;
			}
			else { // Insert char count, and update last char
				mystr += last + "" + count;
				last = str.charAt(ii);
				count = 1;
			}
		}
		return mystr + last + count;
		// Note: this does not 
	}
	
	public static String compressGood(String str)
	{
		// Check if compression would create a longer string
		int size = countCompression(str);
		if (size >= str.length()){
			return str;
		}
		
		StringBuffer mystr = new StringBuffer();
		char last = str.charAt(0);
		int count = 1;
		
		for (int ii = 1; ii < str.length(); ii++){
			if (str.charAt(ii) == last) { // Found repeated char
				count++;
			}
			else { // Insert char count and update last char
				mystr.append(last); // Insert char
				mystr.append(count); // Insert count
				last = str.charAt(ii);
				count = 1;
			}
		}
		
		// Update last set of strings since loop terminates before any attempt at appending
		mystr.append(last);
		mystr.append(count);
		
		return mystr.toString();
	}
	
	public static int countCompression(String str){
		if (str == null || str.isEmpty()) return 0;
		
		char last = str.charAt(0);
		int size = 0;
		int count = 1;
		for (int ii = 1; ii < str.length(); ii++){
			if (str.charAt(ii) == last){
				count++;
			}
			else {
				last = str.charAt(ii);
				size += 1 + String.valueOf(count).length();
				count = 1;
			}
		}
		size += 1 + String.valueOf(count).length();
		
		return size;
	}
	
	// For the case when we're not allowed to use a String Buffer
	public static String compressAlternate(String str){
		// Check if compression would create a longer string
		int size = countCompression(str);
		if (size >= str.length())
			return str;
		
		char[] array = new char[size];
		int index = 0;
		char last = str.charAt(0);
		int count = 1;
		
		for (int ii = 1; ii < str.length(); ii++){
			if (str.charAt(ii) == last) { // Found repeated char
				count++;
			}
			else {
				// Update repeated character count
				index = setChar(array, last, index, count);
				last = str.charAt(ii); // Update
				count = 1;
			}
		}
		
		// Update string with last set of repeated characters
		index = setChar(array, last, index, count);
		return String.valueOf(array);
	}
	
	public static int setChar(char[] array, char c, int index, int count){
		array[index] = c;
		index++;
		
		// Convert the count to a string, then to an array of chars
		char[] cnt = String.valueOf(count).toCharArray();
		
		// Copy characters from biggest digit to smallest
		for (char x : cnt){
			array[index] = x;
			index++;
		}
		return index;
	}
}
