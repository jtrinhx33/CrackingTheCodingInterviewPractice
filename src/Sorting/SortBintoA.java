package Sorting;

public class SortBintoA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1, 2, 4, 5, 10, 40, 50, 0, 0, 0, 0, 0, 0};
		int[] B = {6, 8, 13, 15, 19, 25};
		int lastA = 7;
		int lastB = 6;
		
		int[] merged = SortBIntoA(A, B, lastA, lastB);
		
		for (int ii = 0; ii < merged.length; ii++){
			System.out.print(merged[ii] + " ");
		}
	}

	public static int[] SortBIntoA(int[] A, int[] B, int lastA, int lastB){
		int indexA = lastA - 1;
		int indexB = lastB - 1;
		int index_result = A.length - 1;
		
		while (indexB >= 0){
			
			if (A[indexA] > B[indexB] && indexA >= 0){
				A[index_result] = A[indexA];
				indexA--;
			}
			else {
				A[index_result] = B[indexB];
				indexB--;
			}
			index_result--;
		}
		
		return A;
	}
}
