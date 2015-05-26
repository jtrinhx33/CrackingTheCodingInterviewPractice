package Arrays_and_Strings;

public class ReplaceSpacesWithSpecificCharacters {

	/**
	 * Problem 1.4
	 * @param args
	 */
	public static void main(String[] args) {
		
		//String myString = replaceSpacesWithSpecificCharacters("Mr John Smith     ", 13);
		//System.out.println(myString);
		String input = "Mr John Smith     ";
		realSolution(input.toCharArray(), 13);
	}
	
	public static String replaceSpacesWithSpecificCharacters(String inputStr, int fullLength)
	{
		char[] char_Array = inputStr.toCharArray();
		int[] counterArray = new int[128];
		
		int count = 0;
		for (char c : char_Array){
			counterArray[c]++;
			count++;
			if (count >= fullLength)
				break;
		}
		int c = counterArray[' '];
		int totalLength = fullLength - counterArray[' '] + counterArray[' '] * 3;
		
		char[] new_Array = new char[totalLength];
		
		int jj = 0;
		for (int ii = 0; ii < fullLength; ii++){
			if (!(char_Array[ii] == ' ') && ii < fullLength){
				new_Array[jj] = char_Array[ii];
			}
			else {
				new_Array[jj] = '%';
				jj++;
				new_Array[jj] = '2';
				jj++;
				new_Array[jj] = '0';
				
				//ii++;
				/*while (char_Array[ii] == ' ' && ii < fullLength){
					ii++; // Skip consecutive spaces
				}*/
			}
			jj++;
		}
		System.out.println(new_Array);
		return new_Array.toString();
	}

	// Book's solution
	public static void realSolution(char[] str, int length){
		
		int spaceCount = 0;
		int newLength, ii;
		
		// First pass: count how many spaces there are
		// to determine how long the final string should be
		for (ii = 0; ii < length; ii++){
			if (str[ii] == ' '){
				spaceCount++;
			}
		}
		
		newLength = length + spaceCount * 2;
		str[newLength] = '\0';
		
		// Second pass: done in reverse order, actual editing of the string
		for (ii = length - 1; ii >= 0; ii--){
			if (str[ii] == ' '){
				str[newLength - 1] = '0';
				str[newLength - 2] = '2';
				str[newLength - 3] = '%';
				newLength = newLength - 3;
			}
			else {
				str[newLength - 1] = str[ii];
				newLength = newLength - 1;
			}
		}
		
		System.out.println(str);
	}
}
