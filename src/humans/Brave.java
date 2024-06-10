package humans;

import java.util.Random;

import bases.Human;

public class Brave extends Human {
	
	public Brave(String name, String weapon) {
		super(name , weapon);
		this.hp = getHp(170, 230);
		this.offensive = getOffensive(7, 13);
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
