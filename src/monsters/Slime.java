package monsters;

import java.util.Random;

import bases.Monster;

public class Slime extends Monster {
	
	public Slime (String name, String weapon) {
		super(name , weapon);
		this.hp = getHp(70, 130);
		this.offensive = getOffensive(5, 11);
	}
	
	public static int getHp(int min , int max) {
		Random randomHp = new Random();
		return randomHp.nextInt(max - min + 1) + min;
	}
	
	public static int getOffensive(int min , int max) {
		Random randomOffensive = new Random();
		return randomOffensive.nextInt(max - min + 1) + min;
	}
}
