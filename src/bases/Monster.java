package bases;

import utils.Dice;

public abstract class Monster extends Living {
	//Livingクラスのコンストラクタを利用したMonsterクラスのコンストラクタ
	public Monster(String name , String weapon) {
		super(name, weapon);
	}
		
	//attackメソッドをオーバーライド
	@Override
	public void attack(Living target) {
		// 1から10までのサイコロを振り、自分の攻撃力とかけ合わせた値を相手に与えるダメージとする
		int damage = (Dice.get(1 , 10)) * this.offensive;
		// 相手のHPをダメージ値だけ減らす
		target.hp -= damage;
		// コンソールにステータスを表示
		System.out.println("\n「" + this.name + "」　が「　" + this.weapon + "」で攻撃！「" + target.name +"」　に" + damage +"のダメージを与えた。");
	}
}
