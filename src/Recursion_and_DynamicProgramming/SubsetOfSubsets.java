package Recursion_and_DynamicProgramming;

import java.util.ArrayList;

public class SubsetOfSubsets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(1);
		array.add(2);
		array.add(3);
		array.add(4);
		
		//ArrayList<ArrayList<Integer>> allsubsets = getSubsets(array, 0);
		ArrayList<ArrayList<Integer>> allsubsets = getSubsets2(array);
		for(ArrayList<Integer> subset : allsubsets){
			System.out.print("{ ");
			for (int item : subset){
				System.out.print(item + " ");
			}
			System.out.print("}\n");
		}
		System.out.println("Total subsets: " + allsubsets.size());
	}

	// O(2^n) time and space
	public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> array, int index){
		ArrayList<ArrayList<Integer>> allsubsets;
		
		if (array.size() == index) { // Base case
			allsubsets = new ArrayList<ArrayList<Integer>>();
			allsubsets.add(new ArrayList<Integer>()); // Empty set
		}
		else {
			allsubsets = getSubsets(array, index + 1);
			int item = array.get(index);
			int Size = allsubsets.size();
			
			// Add current item to copy of existing subsets, and add to main subset
			for (int ii = 0; ii < Size; ii++){
				ArrayList<Integer> subset = new ArrayList<Integer>();
				subset.addAll(allsubsets.get(ii));
				subset.add(item);
				allsubsets.add(subset);
			}
		}
		
		return allsubsets;
	}
	
	// Solution using combinatorics. Also O(2^n)
	public static ArrayList<ArrayList<Integer>> getSubsets2(ArrayList<Integer> array){
		 
		ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
		int max = 1 << array.size(); // Compute 2^n
		 
		for (int kk = 0; kk < max; kk++){
			ArrayList<Integer> subset = convertIntToSet(kk, array);
			allsubsets.add(subset);
		}
		 
		return allsubsets;
	}
	
	public static ArrayList<Integer> convertIntToSet(int x, ArrayList<Integer> array){
		
		ArrayList<Integer> subset = new ArrayList<Integer>();
		int index = 0;
		
		for (int kk = x; kk > 0; kk >>= 1){
			if ((kk & 1) == 1){
				subset.add(array.get(index));
			}
			index++;
		}
		
		return subset;
	}
}
