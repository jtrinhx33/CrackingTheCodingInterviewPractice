package Sorting;

import java.util.ArrayList;
import java.util.Collections;

public class CircusTower {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

	}
	
	public static ArrayList<HtWt> getIncreasingSequence(ArrayList<HtWt> items){
		Collections.sort(items);
		return longestIncreasingSubsequence(items);
	}
	
	public static void longestIncreasingSubsequence(ArrayList<HtWt> array, ArrayList<HtWt>[] solutions, int current_index){
		if (current_index >= array.size() || current_index < 0) return;
		
		HtWt current_element = array.get(current_index);
		
		// Find longest sequence we can append current_element to
		ArrayList<HtWt> best_sequence = null;
		for (int ii = 0; ii < current_index; ii++){
			if (array.get(ii).isBefore(current_element)){
				best_sequence = seqWithMaxLength(best_sequence, solutions[ii]);
			}
		}
		
		// Append current element
		ArrayList<HtWt> new_solution = new ArrayList<HtWt>();
		if (best_sequence != null){
			new_solution.addAll(best_sequence);
		}
		new_solution.add(current_element);
		
		// Add to list and recurse
		solutions[current_index] = new_solution;
		longestIncreasingSubsequence(array, solutions, current_index + 1);
	}
	
	public static ArrayList<HtWt> longestIncreasingSubsequence(ArrayList<HtWt> array){
		ArrayList<HtWt>[] solutions = new ArrayList[array.size()];
		longestIncreasingSubsequence(array, solutions, 0);
		
		ArrayList<HtWt> best_sequence = null;
		for (int ii = 0; ii < array.size(); ii++){
			best_sequence = seqWithMaxLength(best_sequence, solutions[ii]);
		}
		
		return best_sequence;
	}
	
	public static ArrayList<HtWt> seqWithMaxLength(ArrayList<HtWt> seq1, ArrayList<HtWt> seq2){
		if (seq1 == null) return seq2;
		if (seq2 == null) return seq1;
		
		return seq1.size() > seq2.size() ? seq1 : seq2;
	}

}
