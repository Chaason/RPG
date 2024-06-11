package demo;

import java.util.ArrayList;
import java.util.List;

import bases.Human;
import bases.Monster;
import humans.Brave;
import humans.Fighter;
import humans.Wizard;
import monsters.Dragon;
import monsters.Oak;
import monsters.Slime;
import utils.Dice;

public class Main {

	public static void main(String[] args) {
		System.out.println("★★ ==== 戦いの開始だ！！ ==== ★★");
		//各人間クラスのインスタンス化
		Human brave = new Brave("沖田総司", "剣");
		Human fighter = new Fighter("金太郎", "斧");
		Human wizard = new Wizard("安倍晴明", "魔法");
		
		//人間グループをリストに追加
		List<Human> humans = new ArrayList<>(); 
		humans.add(brave);
		humans.add(fighter);
		humans.add(wizard);
		
		//各モンスタークラスのインスタンス化
		Monster slime = new Slime("キングスライム", "体当たり");
		Monster oak = new Oak("オークキング", "槍");
		Monster dragon = new Dragon("紅龍", "炎");
		
		//モンスターグループをリストに追加
		List<Monster> monsters = new ArrayList<>();
		monsters.add(slime);
		monsters.add(oak);
		monsters.add(dragon);
		
		//現在の各グループの状態を一覧表示
		showGroupInfos(humans, monsters);
		
		//第何回戦かを示すカウンター変数定義
		int count = 1;
		
		//勝敗がつくまで無限ループ
		while(true) {
			System.out.printf("\n★ 第%d回戦 ==========\n", count);
			System.out.println("\n[人間のターン！]\n");
			Human h = choiceHuman(humans);
			Monster m = choiceMonster(monsters);
			//選ばれた人間が選ばれたモンスターを攻撃
			h.attack(m);
			//hpが0になればリストから外して、リスト要素が0になったらループを終わらせる。
			if(m.getHp() <= 0) {
				System.out.println("\n★「" + m.getName() + "」　は倒れた。\n");
				monsters.remove(m);
			}
			if(monsters.isEmpty()) {
				System.out.println("\n★★ ==== 決着がついた！！ ==== ★★\n");
				System.out.println("\n#### 人間達は勝利した！！ ####\n");
				break;
			}
			
			System.out.println("\n[モンスターのターン！]\n");
			h = choiceHuman(humans);
			m = choiceMonster(monsters);
			//選ばれたモンスターが選ばれた人間を攻撃
			m.attack(h);
			//hpが0になればリストから外して、リスト要素が0になったらループを終わらせる。
			if(h.getHp() <= 0) {
				System.out.println("\n★「" + h.getName() + "」　は倒れた。\n");
				humans.remove(h);
			}
			if(humans.isEmpty()) {
				System.out.println("\n★★ ==== 決着がついた！！ ==== ★★\n");
				System.out.println("\n#### モンスター達は勝利した！！ ####\n");
				break;
			}
			//現在の各グループの状態を一覧表示
			showGroupInfos(humans, monsters);
			
			//ループの変数を1増やす
			count++;
		}
		
		showGroupInfos(humans, monsters);
	}
	
	
	// 引数でもらった人間グループリストからランダムに1人を選択し、その結果を戻り値とするメソッド
	public static Human choiceHuman(List<Human> humans) {
		Human human = humans.get(Dice.get(0, humans.size() - 1));
		System.out.printf("人間グループから 「%s」 のお出ましだ！\n", human.getName());
		return human;
	}

	// 引数でもらったモンスターグループリストからランダムに1人を選択し、その結果を戻り値とするメソッド
	public static Monster choiceMonster(List<Monster> monsters) {
		Monster monster = monsters.get(Dice.get(0, monsters.size() - 1));
		System.out.printf("モンスターグループから 「%s」 のお出ましだ！\n", monster.getName());
		return monster;
	}

	// 引数でもらった人間グループリストとモンスターグループリストのそれぞれの情報一覧を表示するメソッド
	public static void showGroupInfos(List<Human> humans, List<Monster> monsters) {

		System.out.println("\n## === グループ情報 === ##");
		System.out.printf("# [人間グループ]: %d人\n", humans.size());
		for (Human human : humans) {
			System.out.println(human);
		}

		System.out.printf("\n# [モンスターグループ]: %d人\n", monsters.size());
		for (Monster monster : monsters) {
			System.out.println(monster);
		}
	}

}
