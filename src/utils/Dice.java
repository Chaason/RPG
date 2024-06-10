package utils;

import java.util.Random;

public class Dice {

	private static Random r = new Random();
		
	public static int get(int min , int max) {
		return r.nextInt(max - min + 1) + min; 
	}
		
}
