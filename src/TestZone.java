import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class TestZone {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//String[] array = new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"};
		/*String[] array = new String[]{"NORTH", "WEST", "SOUTH", "EAST"};
		String[] output = dirReduc(array);
		for (int ii = 0; ii < output.length; ii++){
			System.out.println(output[ii]);
		}*/
		
		Stack<Integer> deck = new Stack<Integer>();
		
		deck.push(2);
		deck.push(3);
		deck.push(4);
		deck.push(5);
		deck.push(6);
		deck.push(7);
		deck.push(8);
		deck.push(9);
		deck.push(10);
		deck.push(11);
		deck.push(12);
		deck.push(13);
		deck.push(14);
		
		Collections.shuffle(deck);
		System.out.println(Collections.min(deck));
		System.out.println(Collections.max(deck));
		
		int size_of_full_deck = deck.size();
		
		for (int ii = 0; ii < size_of_full_deck; ii++){
			
			System.out.print(deck.pop() + " ");
		}
		
		System.out.println();
		String[] strings = { "", "e", "es", "s", "st", "t", "te", "tes", "est", "test", "tet", "ts", "tst", "tt", "et"};
		ArrayList<String> stringsList = new ArrayList<String>();
		for (int ii = 0; ii < strings.length; ii++){
			stringsList.add(strings[ii]);
		}
		
		Collections.sort(stringsList);
		for (int ii = 0; ii < stringsList.size(); ii++){
			System.out.print(stringsList.get(ii) + " ");
		}
		/*System.out.println(reverseString("hello"));
		
		int array[] = { 1, 2, 3, 4, 5};
		System.out.println(find(array, 12));*/
		
		
		/*HashMap<Integer, Integer> dict = new HashMap<Integer, Integer>();
		dict.put(1, 0);
		dict.put(1, (dict.get(1) + 1));
		dict.put(1, (dict.get(1) + 1));
		dict.put(1, (dict.get(1) + 1));
		dict.put(3, 0);
		dict.put(3, (dict.get(3) + 1));
		dict.put(3, (dict.get(3) + 1));
		
		System.out.println(dict.get(1));
		System.out.println(dict.get(3));
		System.out.println(dict.keySet());
		System.out.println(dict.values());*/
		
		//String input = "waterbottle";
		//System.out.println(rotateString(input, 3));
		
		/*int[][] mult = multiplicationTable(12, 12);
		for (int ii = 0; ii < mult.length; ii++){
			for (int jj = 0; jj < mult[0].length; jj++){
				System.out.print(mult[ii][jj] + " ");
			}
			System.out.println();
		}*/
		
		/*String input = new String("The dogman was no ordinary dog, nor man, but rather a peculiar dog-like man who barked like a dog, and panted like a dog, he even ate like a dog.  He owned a dog named Doglips, and interestingly enough, his favorite food was hotdogs.");

		String[] words = input.split("[\\s'-.]");
		
		int counter = 0;
		for (String word : words){
			
			if (word.equals("dog")){
				counter++;
			}
		}
		
		System.out.println(counter);*/


		//System.out.println(parity(new String("hello")));

		//System.out.println(strncmp("swaraj","zaxzs",7));
	}
	
	public static int addBackwards(int[] array, int index){
		
		int elem = array[index];
		index++;
		if(index >= array.length)
			return array[array.length-1];
		
		return elem + addBackwards(array, index);
	}






	public static void addforward2(int[] array, int index, int tot){

		int elem = array[index];
		int total = tot + elem;
		index++;
		
		if(index >= array.length ){
			System.out.println(total);
			return;
		}
		else
			addforward2(array, index, total);

	}
	
	public static String parity(String msg){
		String parityStr = null;
		int n = msg.hashCode();
		switch (n % 2){
		case 0: 
			parityStr = "even";
			break;
		case 1:
			parityStr = "odd";
			break;
		}
		return parityStr;
	}
	
	
	public static String[] dirReduc(String[] arr) {
        int count_N = 0;
        int count_S = 0;
        int count_E = 0;
        int count_W = 0;
        
        for (int ii = 0; ii < arr.length; ii++){
        	String dir = arr[ii];
    		if (dir == "NORTH") count_N++;
            if (dir == "SOUTH") count_S++;
            if (dir == "EAST") count_E++;
            if (dir == "WEST") count_W++;
        }
          
          String[] out;
          
          if (count_N == count_S){
            count_N = 0;
            count_S = 0;
          }
          else if (count_N < count_S){
            count_S = count_S - count_N;
            count_N = 0;
          }
          else if (count_N > count_S){
            count_N = count_N - count_S;
            count_S = 0;
          }
          
          
          if (count_E == count_W){
            count_E = 0;
            count_W = 0;
          }
          else if (count_E < count_W){
            count_W = count_W - count_E;
            count_E = 0;
          }
          else if (count_E > count_W){
            count_E = count_E - count_W;
            count_W = 0;
          }
            	
        	out = new String[count_N + count_S + count_E + count_W];
        	
        	int jj = 0;
        	for (int ii = 0; ii < count_N; ii++){
        		out[jj] = "NORTH";
        		jj++;
        	}
        	for (int ii = 0; ii < count_S; ii++){
        		out[jj] = "SOUTH";
        		jj++;
        	}
        	for (int ii = 0; ii < count_E; ii++){
        		out[jj] = "EAST";
        		jj++;
        	}
        	for (int ii = 0; ii < count_W; ii++){
        		out[jj] = "WEST";
        		jj++;
        	}
        
        	return out;
    
    }
	
	public static int[][] multiplicationTable(int n, int m){

		int[][] out = new int[n][m];

		for (int ii = 1; ii <= n; ii++){
			
			for (int jj = 1; jj <= m; jj++){
				out[ii - 1][jj - 1] = ii * jj;
			}
		}

		return out;
	}
	
	public static int strncmp(String s1,String s2,int n)
    {
		
        if(s1.length() < n || s2.length() < n)
            n = s1.length() > s2.length() ? s1.length() : s2.length();
            
         for(int ii = 0; ii < n; ii++)
         {
            if(s1.charAt(ii) != s2.charAt(ii))
            {
                return s1.charAt(ii) > s2.charAt(ii) ? 1 : -1;
            }
        }
        return 0;
    }
	
	public static String rotateString(String input, int n){
		
		// input = "waterbottle"; n = 3;
		// after rotating = "erbottlewat
		if (input == null || input == "" || input.length() == 1) return input;
		
		int mod = n % input.length();
		String first = input.substring(mod, input.length());
		String second = input.substring(0, mod);
		
		return first + second;
		
	}

	
	
	public static boolean find(int[] array, int item){
		
		if (array == null || array.length == 0) return false;

		for (int ii = 0; ii < array.length; ii++){
			if (array[ii] == item) return true;
		}

		return false;
	}
	
	public static String reverseString(String str){

		if (str == null || str == "") return str;

		char[] char_array = str.toCharArray();
	
		StringBuilder s = new StringBuilder();
	
		for (int ii = char_array.length - 1; ii >= 0; ii--){
			s.append(char_array[ii]);
		}
	
		return s.toString();
	}
}
