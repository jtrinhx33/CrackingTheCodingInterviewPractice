package Arrays_and_Strings;

public class RepeatLetters {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(CommonCharacters("dogfgsadsiasdf", "dogfish"));
	}

	public static String CommonCharacters(String s1, String s2){
		
		char[] checker = new char[128];
		
		StringBuilder result = new StringBuilder();
	
		for (int ii = 0; ii < s1.length(); ii++){
			char c = s1.charAt(ii);
			checker[c]++;
		}
		
		for (int ii = 0; ii < s2.length(); ii++){
			char c = s2.charAt(ii);
			
			if (checker[c] > 0){
				result.append(c);
			}
		}
		
		return result.toString();
	}
}
