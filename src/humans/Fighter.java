package humans;

import java.util.Random;

import bases.Human;

public class Fighter extends Human {
	
	public Fighter(String name, String weapon) {
		super(name , weapon);
		this.hp = getHp(240, 300);
		this.offensive = getOffensive(17, 23);
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
