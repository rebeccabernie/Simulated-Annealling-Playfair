// AI Project 2018 - Break a Playfair Cipher using Simulated Annealling
// Rebecca Kane G00320698

package ie.gmit.sw.ai;

import java.awt.BufferCapabilities.FlipContents;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

// Runner class - doesn't actually do anything, just calls other classes/methods
public class CipherBreaker {

	public static void main(String[] args) throws IOException {
		/*SimulatedAnnealling sa = new SimulatedAnnealling();
		PlayfairImpl pf = new PlayfairImpl();

		String filename = "EncryptedExamTips.txt";
		//System.out.println("Working Directory = " + System.getProperty("user.dir")); // Get current directory, adapted from https://stackoverflow.com/a/7603444
		Path path = FileSystems.getDefault().getPath(filename);
		//System.out.println("Path: " + path);
		
		String primedText = pf.primePlainTxt(FilePreparer.readFile(path));
		String[] digraphs = pf.makeDigraphs(primedText);
		//System.out.println("\n1. Primed Text: " + primedText);
		//System.out.println("2. Digraphs: " + Arrays.toString(digraphs)); // Print array contents - https://stackoverflow.com/a/409795

		//pf.printMatrix(key); // Prints two matrices, first is th given key and second is just ints 0-24

		String decrypted = sa.decrypt(digraphs);
		//String decrypted = pf.decrypt(key, digraphs);
		System.out.println("\nDecrypted: \n" + decrypted);*/
		
		String key = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
		PlayfairImpl.printMatrix(key);
		String nKey = swapRows(key, (int)(Math.random() * 4), (int)(Math.random() * 4)); // Try swapping cols 2 and 4
		System.out.println("New Key:");
		PlayfairImpl.printMatrix(nKey);
		
	}

	private static String swapRows(String key, int row1, int row2) {
		// Works similar to swapping columns
		if (row1 == row2) { // Making sure same row can't be passed in to be swapped
			System.out.println("Same");
			return swapRows(key, (int)(Math.random() * 4), (int)(Math.random() * 4));
		} else {
			System.out.println("Different");
			row1 = row1 * 5; // Need to get index, not row num -> 4th row = row 3 = 3*5 = index 15.
			row2 = row2 * 5;
			char[] newKey = key.toCharArray();
			for(int i = 0; i < key.length() / 5 ; i++) {
				char temp =  newKey[(i + row1)]; // Set temporary = newKey at index i + row number
				newKey[(i + row1)] = newKey[(i + row2)]; // Set char at that index to be the char at that index + 2nd given row's number
				newKey[(i + row2)] = temp; // Set that index to be the temp value
				// I.e. for each row, swap the chars in the given columns
			}
			return new String(newKey);
		}
	}
	
	
	
}
