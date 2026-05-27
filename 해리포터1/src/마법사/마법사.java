//마법사
package 마법사;

import 마법도구.*;

public class 마법사 implements IAttack {
	private String name;
	private int hp;
	private int skill;
	private 마법도구 weapon;

	public 마법사() {}
	public 마법사(String name, int hp, int skill) {
		this.name = name;
		this.hp = hp;
		this.skill = skill;
		System.out.println("마법사 " + this.name +" 이/가 초기화되어 생성되었습니다.");
	}

	public void 공격하기(){
	}

	public void 공격하기(마법사 target){
		if(target.getWeapon() instanceof 투명망토) {
			System.out.print(target.getName() + "이/가 ");
			((투명망토)target.getWeapon()).방어하기();
			target.setWeapon(null);
		}
		else {
			target.setHp(target.getHp() - this.getSkill());
			System.out.println(this.getName() + " 이/가 " + target.getName() + " 을/를 공격합니다.");
		}

		//같은 팀 공격 불가는 하위클래스 오버라이딩으로
	}
	
	///공격 7배 효과
	public void 럭키공격(마법사 target){ //////
		if(target.getWeapon() instanceof 투명망토) {
			System.out.print(target.getName() + "이/가 ");
			((투명망토)target.getWeapon()).방어하기();
			target.setWeapon(null);
		}
		else {
			target.setHp(target.getHp() - this.getSkill()*7);
			System.out.println(this.getName() + " 이/가 " + target.getName() + " 을/를 공격합니다.");
		}
		//같은 팀 공격 불가는 하위클래스 오버라이딩으로
	}

	public void 공격하기(마법사 target, 마법도구 weapon){

		if(weapon instanceof 물약 || weapon instanceof 투명망토) {
			weapon.공격();
			return;
		}

		if(target.getWeapon() instanceof 투명망토) {
			System.out.print(target.getName() + "이/가 ");
			((투명망토)target.getWeapon()).방어하기();
			target.setWeapon(null);
		}
		else {
			System.out.println(this.getName() + " 이/가 " + weapon.getName() + " 으로 " +target.getName() + "을/를 공격합니다.");
			//마법도구 공격
			weapon.공격();
			target.setHp(target.getHp() - (this.getSkill()+ weapon.getSkill()));
		}  	

	}
	
	public void 럭키공격(마법사 target, 마법도구 weapon){ /////

		if(weapon instanceof 물약 || weapon instanceof 투명망토) {
			weapon.공격();
			return;
		}


		if(target.getWeapon() instanceof 투명망토) {
			System.out.print(target.getName() + "이/가 ");
			((투명망토)target.getWeapon()).방어하기();
			target.setWeapon(null);
		}
		else {
			System.out.println(this.getName() + " 이/가 " + weapon.getName() + " 으로 " +target.getName() + "을/를 공격합니다.");
			//마법도구 공격
			weapon.공격();
			target.setHp(target.getHp() - (this.getSkill()+ weapon.getSkill())*7);
		}  	

	}

	//한명의 상태보이기
	public void showStatus() {
		System.out.printf("%s(hp: %d, power: %2d) ", this.getName(), this.getHp(), this.getSkill());
		System.out.println();
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getSkill() {
		return skill;
	}

	public void setSkill(int skill) {
		this.skill = skill;
	}

	public 마법도구 getWeapon() {
		return weapon;
	}

	public void setWeapon(마법도구 weapon) {
		this.weapon = weapon;
	}



}