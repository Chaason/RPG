package bases;

public abstract class Living {
	protected String name;
	protected String weapon;
	protected int hp;
	protected int offensive;
	
	//nameとweaponのコンストラクタ
	public Living(String name , String weapon) {
		this.name = name;
		this.weapon = weapon;
	}
	
	//各フィールド変数のゲッター設定
	public String getName() {
		return this.name;
	}
	
	public String getWeapon() {
		return this.weapon;
	}
	
	public int getHp() {
		return this.hp;
	}
	
	public int getOffensive() {
		return this.offensive;
	}
	
	//各フィールド変数のセッター設定
	public void setName(String name) {
		this.name = name;
	}
	
	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public void setOffensive(int offensive) {
		this.offensive = offensive;
	}
	
	//ターゲットに攻撃するメソッド
	public abstract void attack(Living target);
	
	//自身を表現する文字列のオーバーライド
	@Override
	public String toString() {
		String alert = "";
		if(this.hp <= 50) {
			alert ="★ HP残りわずか！アブナイ";
		}
		return String.format("[名前]: %s, [ヒットポイント]: %d, [攻撃力]: %d %s", this.name, this.hp, this.offensive, alert);
	} 
	
}
