package Arrays_and_Strings;

public class SetZeroMatrix {

	/**
	 * Problem 1.7
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] matrix = {{1, 5, 4, 0},
				{10, 9, 0, 2},
				{1, 4, 7, 7}};
		int m = 3;
		int n = 4;
			
		setZeroMatrix(matrix, m, n);
		
		int[][] matrix2 = {{1, 5, 4, 0},
				{10, 9, 0, 2},
				{1, 4, 7, 7}};
		setZeros(matrix2);
		
		int[][] matrix3 = {{1, 5, 4, 0},
				{10, 9, 0, 2},
				{1, 4, 7, 7}};
		setZeros2(matrix3);
	}

	public static void printMatrix(int[][] matrix, int m, int n){
		for (int i = 0; i < m; i++) {
		    for (int j = 0; j < n; j++) {
		        System.out.print(matrix[i][j] + " ");
		    }
		    System.out.print("\n");
		}
	}
	
	public static void setZeroMatrix(int[][] matrix, int m, int n){
		System.out.println("Before: ");
		printMatrix(matrix, m, n);
		
		boolean isZero[][] = new boolean[m][n];
		
		// Find the 0's and mark them
		for (int rr = 0; rr < m; rr++){
			
			for (int cc = 0; cc < n; cc++){
				
				if (matrix[rr][cc] == 0){
					isZero[rr][cc] = true;
				}
				else {
					isZero[rr][cc] = false;
				}
			}
		}
		
		// Set specific rows and columns to 0
		for (int rr = 0; rr < m; rr++){
			
			for (int cc = 0; cc < n; cc++){
				
				if (isZero[rr][cc] == true){
					
					// Set row
					for (int ii = 0; ii < n; ii++){
						matrix[rr][ii] = 0;
					}
					
					// Set column
					for (int ii = 0; ii < m; ii++){
						matrix[ii][cc] = 0;
					}
				}
			}
		}
		
		System.out.println("After: ");
		printMatrix(matrix, m, n);
	}
	
	// Book's solution: Take up less space. Keep track of rows and columns that are to be set zero and that's it
	public static void setZeros(int[][] matrix){
		boolean[] row = new boolean[matrix.length];
		boolean[] column = new boolean[matrix[0].length];
		
		// Store the row and column index with value 0
		for (int ii = 0; ii < matrix.length; ii++){
			for (int jj = 0; jj < matrix[0].length; jj++){
				if (matrix[ii][jj] == 0){
					row[ii] = true;
					column[jj] = true;
				}
			}
		}
		
		// Nullify rows
		for (int ii = 0; ii < row.length; ii++){
			if (row[ii]) nullifyRow(matrix, ii);
		}
		
		// Nullify columns
		for (int jj = 0; jj < column.length; jj++){
			if (column[jj]) nullifyColumn(matrix, jj);
		}
		
		System.out.println("After: ");
		printMatrix(matrix, matrix.length, matrix[0].length);
	}
	
	public static void nullifyRow(int[][] matrix, int row){
		for (int jj = 0; jj < matrix[0].length; jj++)
			matrix[row][jj] = 0;
	}
	
	public static void nullifyColumn(int[][] matrix, int column){
		for (int ii = 0; ii < matrix.length; ii++){
			matrix[ii][column] = 0;
		}
	}
	
	
	// O(1) space
	public static void setZeros2(int[][] matrix) {
		int[] row = new int[matrix.length];	
		int[] column = new int[matrix[0].length];

		// Store the row and column index with value 0
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length;j++) {
				if (matrix[i][j] == 0) {
					row[i] = 1; 
					column[j] = 1;
		 		}
			}
		} 

		// Set arr[i][j] to 0 if either row i or column j has a 0
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if ((row[i] == 1 || column[j] == 1)) {
					matrix[i][j] = 0;
				}
			}
		}
		
		System.out.println("After: ");
		printMatrix(matrix, matrix.length, matrix[0].length);
	}
}
