package Arrays_and_Strings;

public class RotateNxNMatrix {

	/**
	 * Problem 1.6
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 2;
		int[][] image = new int[N][N];
		
		image[0][0] = 1;
		image[0][1] = 2;
		image[1][0] = 4;
		image[1][1] = 3;
		
		//rotate(image, N);
		RotateImage90(image, N);
		rotate(image, N);
	}

	public static void PrintMatrix(int[][] image, int N){
		
		for (int row = 0; row < N; row++){
				System.out.println(image[row]);
		}
	}
	
	public static void RotateImage90(int[][] image, int N){
		
		int temp1, temp2, temp3, temp4;
		int[][] newImage = new int[N][N];
		
		for (int row = 0; row < N; row++){
			
			for (int col = 0; col < N; col++){
				// Get original pixels prior to rotation
				temp1 = image[row][col];
				temp2 = image[row][N - 1 - col];
				temp3 = image[N - 1 - row][N - 1 - col];
				temp4 = image[N - 1 - row][col];
				
				// Set pixels in their new location (rotate to right)
				newImage[row][col] = temp4;
				newImage[row][N - 1 - col] = temp1;
				newImage[N - 1 - row][N - 1 - col] = temp2;
				newImage[N - 1 - row][col] = temp3;
			}
		}
		PrintMatrix(image, N);
	}
	
	// Book solution
	public static void rotate(int[][] matrix, int n){
		
		for (int layer = 0; layer < n / 2; ++layer){
			int first = layer;
			int last = n - 1 - layer;
			for (int ii = first; ii < last; ++ii){
				int offset = ii - first;
				// Save top
				int top = matrix[first][ii];
				
				// Left -> top
				matrix[first][ii] = matrix[last-offset][first];
				
				// Bottom -> left
				matrix[last-offset][first] = matrix[last][last - offset];
				
				// Right -> bottom
				matrix[last][last - offset] = matrix[ii][last];
				
				// Top -> right
				matrix[ii][last] = top;
			}
		}
		PrintMatrix(matrix, n);
	}
}
