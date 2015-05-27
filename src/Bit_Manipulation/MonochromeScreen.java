package Bit_Manipulation;

public class MonochromeScreen {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

	}
	
	// Book's solution
	public static void drawLine(byte[] screen, int width, int x1, int x2, int y){
		int start_offset = x1 % 8;
		int first_full_byte = x1 / 8;
		if (start_offset != 0){
			first_full_byte++;
		}
		
		int end_offset = x2 % 8;
		int last_full_byte = x2 / 8;
		if (end_offset != 0){
			last_full_byte--;
		}
		
		// Set full bytes
		for (int b = first_full_byte; b <= last_full_byte; b++){
			screen[((width / 8) * y) + b] = (byte) 0xFF;
		}
		
		// Create masks for start and end of the line
		byte start_mask = (byte) (0xFF >> start_offset);
		byte end_mask = (byte) ~(0xFF >> (end_offset + 1));
		
		// Set start and end of line
		if ((x1 / 8) == (x2 / 8)){ // x1 and x2 in same byte
			//  Combine the masks
			byte mask = (byte) (start_mask & end_mask);
		}
		else { // Not in same byte
			if (start_offset != 0){
				int byte_index = ((width / 8) * y) + (first_full_byte - 1);
				screen[byte_index] |= start_mask;
			}
			
			if (end_offset != 7){
				int byte_index = ((width / 8) * y) + (last_full_byte + 1);
				screen[byte_index] |= end_mask;
			}
		}
		
	}

}
