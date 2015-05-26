package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.LinkedList;

public class SortAnagrams {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] array = {"cat", "tat", "act", "att", "cute", "watermelon", "etuc"};
		System.out.println("Before: ");
		for (int ii = 0; ii < array.length; ii++){
			System.out.print(array[ii] + " ");
		}
		
		System.out.println();
		String[] result = arrangeAnagrams(array);

		System.out.println("After: ");
		for (int ii = 0; ii < result.length; ii++){
			System.out.print(result[ii] + " ");
		}
		
	}

	public static String[] arrangeAnagrams(String[] array){
		
		ArrayList<LinkedList<String>> buckets = new ArrayList<LinkedList<String>>();
		
		for (int ii = 0; ii < array.length; ii++){
			String word = array[ii];
			addToBucket(word, buckets);
		}
		
		int kk = 0;
		for (int ii = 0; ii < buckets.size(); ii++){

			for (int jj = 0; jj < buckets.get(ii).size(); jj++){
				array[kk] = buckets.get(ii).get(jj);
				kk++;
			}
		}
		
		return array;
		
	}
	
	public static void addToBucket(String word, ArrayList<LinkedList<String>> buckets){
		//String w = word;
		char[] w = word.toCharArray(); 
		
		// New list
		if (buckets.size() == 0){
			LinkedList<String> bucket = new LinkedList<String>();
			bucket.add(word);
			buckets.add(bucket);
		}
		else {
		
			boolean isFound = false;
			for (int ii = 0; ii < buckets.size(); ii++){
				char[] bucketWord = buckets.get(ii).get(0).toCharArray();
				Arrays.sort(w);
				Arrays.sort(bucketWord);
				if (Arrays.equals(w, bucketWord)){ // found in list
					buckets.get(ii).add(word);
					isFound = true;
					break;
				}
			}
			
			if (!isFound){
				// Not found in list, create new bucket and add to list of buckets
				LinkedList<String> bucket = new LinkedList<String>();
				bucket.add(word);
				buckets.add(bucket);
			}
		}
	}
	
	// Book's solution: O(n log n) time
	
	/**
	 * Compares two strings
	 * @author Jeannie
	 *
	 */
	public class AnagramComparator implements Comparator<String>{
		public String sortChars(String s){
			char[] content = s.toCharArray();
			Arrays.sort(content);
			return new String(content);
		}
		
		public int compare(String s1, String s2){
			return sortChars(s1).compareTo(sortChars(s2));
		}
	}
	
	public static void sort(String[] array){
		Hashtable<String, LinkedList<String>> hash = new Hashtable<String, LinkedList<String>>();
		
		// Group words by anagram
		for (String s : array){
			String key = sortChars(s);
			if (!hash.containsKey(key)){
				hash.put(key, new LinkedList<String>());
			}
			LinkedList<String> anagrams = hash.get(key);
			anagrams.push(s);
		}
		
		
		// Convert hash table to array
		int index = 0;
		for (String key : hash.keySet()){
			LinkedList<String> list = hash.get(key);
			for (String t : list){
				array[index] = t;
				index++;
			}
		}
	}
	
	public static String sortChars(String s){
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
}

