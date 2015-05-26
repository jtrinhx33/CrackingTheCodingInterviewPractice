package Sorting;

import java.util.Hashtable;
import java.util.LinkedList;

public class FindElementMatrixRowAndColSorted {

	/**
	 * Question 11.6
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*int[][] array = {{ 1, 2, 3, 4},
				{ 5, 6, 7, 8},
				{ 9, 10, 11, 12},
				{ 13, 14, 15, 16}};
	
		printSpiral(array, 4, 4);*/
		
		
	}
	
	// m = # rows, n = # columns
	public static void printSpiral(int[][] array, int m, int n){

		// Error checks here

		int top = 0;
		int bottom = m - 1;
		int left = 0;
		int right = n - 1;

		while (left < right || top < bottom){

			// Take care of top row of spiral
			for (int ii = left; ii <= right; ii++){
			
				System.out.print(array[top][ii] + " ");
			}
			
			top++;
			// 	Take care of first column of spiral
			for (int ii = top; ii <= bottom; ii++){
				System.out.print(array[ii][right] + " ");
			}

			// Set some bounds for last half of spiral
			right--;
			top++;

			// 3rd leg of spiral
			for (int ii = right; ii >= left; ii--){
				System.out.print(array[bottom][ii] + " ");
			}
			
			// 4th leg of spiral
			for (int ii = bottom; ii > top; ii--){
				System.out.print(array[ii][left] + " ");
			}

			// Set bounds for next spiral
			bottom--;
			left++;
		}
	}

	
	// Book's solution 1
	public static boolean findElement(int[][] matrix, int elem){
		int row = 0;
		int col = matrix[0].length - 1;
		
		while(row < matrix.length && col >= 0){
			if (matrix[row][col] == elem){
				return true;
			}
			else if(matrix[row][col] > elem){
				col--;
			}
			else {
				row++;
			}
		}
		
		return false;
	}
	
	// Book's solution 2, binary search, split into 4 quadrants and recurse on valid sections
	// Diagonal must also be sorted
	public static Coordinate findElement(int[][] matrix, Coordinate origin, Coordinate dest, int x){
		if (!origin.inbounds(matrix) || !dest.inbounds(matrix)){
			return null;
		}
		
		if (matrix[origin.row][origin.column] == x){
			return origin;
		}
		else if (!origin.isBefore(dest)){
			return null;
		}
		
		// Set to start of the diagonal and end to the end of the diagonal.
		// Since the grid may not be square, the end may not equal dest
		Coordinate start = (Coordinate) origin.clone();
		int diagDist = Math.min(dest.row - origin.row, dest.column - origin.column);
		
		Coordinate end = new Coordinate(start.row + diagDist, start.column + diagDist);
		Coordinate p = new Coordinate(0, 0);
		
		// Do binary search on the diagonal, looking for the first element greater than x
		while (start.isBefore(end)){
			p.setToAverage(start, end);
			
			if (x > matrix[p.row][p.column]){
				start.row = p.row + 1;
				start.column = p.column + 1;
			}
			else {
				end.row = p.row - 1;
				end.column = p.column - 1;
			}
		}
		
		// Split the grid into quadrants. Search the bottom left and the top right
		return partitionAndSearch(matrix, origin, dest, start, x);
		
	}
	
	public static Coordinate partitionAndSearch(int[][] matrix, Coordinate origin, Coordinate dest, Coordinate pivot, int elem){
		Coordinate lowerLeftOrigin = new Coordinate(pivot.row, origin.column);
		Coordinate lowerLeftDest = new Coordinate(dest.row, pivot.column - 1);
		Coordinate upperRightOrigin = new Coordinate(origin.row, pivot.column);
		Coordinate upperRightDest = new Coordinate(pivot.row - 1, dest.column);
		
		Coordinate lowerLeft = findElement(matrix, lowerLeftOrigin, lowerLeftDest, elem);
		if(lowerLeft == null){
			return findElement(matrix, upperRightOrigin, upperRightDest, elem);
		}
		
		return lowerLeft;
	}
	
	public static Coordinate findElementWrapper(int[][] matrix, int x){
		Coordinate origin = new Coordinate(0,0);
		Coordinate dest = new Coordinate(matrix.length - 1, matrix[0].length - 1);
		
		return findElement(matrix, origin, dest, x);
	}
}
