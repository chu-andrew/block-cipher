package blockCipher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BlockCipher {
	public static void main(String[] args) {
		System.out.println(
				cipher(cipher(read("C:\\Users\\andre\\eclipse-workspace\\Block Cipher\\blockCipher\\test.txt"))));
	}

	public static String cipher(String input) {
		String in = input.toLowerCase();
		in = in.replaceAll("[^a-zA-Z0-9]", "");

		int blockLen = (int) Math.ceil(Math.sqrt(in.length()));
		char[][] block = new char[blockLen][blockLen];

		fillBlock(block, in);
		// printBlock(block);

		return cipherBlock(block);
	}

	private static void fillBlock(char[][] block, String in) {
		int counter = 0;
		for (int i = 0; i < block.length; i++) {
			for (int j = 0; j < block[0].length; j++) {
				if (counter < in.length()) {
					block[i][j] = in.charAt(counter);
				} else
					block[i][j] = 'x';
				counter++;
			}
		}
	}

	private static void printBlock(char[][] block) {
		for (int i = 0; i < block.length; i++) {
			for (int j = 0; j < block[0].length; j++) {
				System.out.print(block[i][j]);
			}
			System.out.println();
		}
	}

	private static String cipherBlock(char[][] block) {
		String out = "";
		for (int j = 0; j < block.length; j++) {
			for (int i = 0; i < block[0].length; i++) {
				out += block[i][j];
			}
		}
		return out;
	}

	public static String read(String filename) {
		Path fileName = Path.of(filename);

		String content = "";
		try {
			content = Files.readString(fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return content;
	}
}
