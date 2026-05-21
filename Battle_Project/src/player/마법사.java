package player;

import weapon.*;

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
			System.out.println(target.getName() + " 이/가 " + target.getWeapon() + " 을/를 가져서 공격이 무효화됩니다." );
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
			System.out.println(target.getName() + " 이/가 " + target.getWeapon() + " 을/를 가져서 공격이 무효화됩니다." );
			target.setWeapon(null);
		}
		else {
			target.setHp(target.getHp() - this.getSkill()*7);
			System.out.println(this.getName() + " 이/가 " + target.getName() + " 을/를 공격합니다.");
		}
		//같은 팀 공격 불가는 하위클래스 오버라이딩으로
	}

	public void 공격하기(마법사 target, 마법도구 weapon){

		if(weapon instanceof 물약) {
			System.out.println("물약으로는 공격할 수 없습니다.");
			return;
		}

		if(weapon instanceof 투명망토) {
			System.out.println("투명망토로는 공격할 수 없습니다.");
			return;
		}

		if(target.getWeapon() instanceof 투명망토) {
			System.out.println(target.getName() + " 이/가 " + target.getWeapon().getName() +" 을/를 가져서 공격이 무효화됩니다.");
			target.setWeapon(null);
		}
		else {
			System.out.println(this.getName() + " 이/가 " + weapon.getName() + " 으로 " +target.getName() + "을/를 공격합니다.");
			target.setHp(target.getHp() - (this.getSkill()+ weapon.getSkill()));
		}  	



	}

	public void 럭키공격(마법사 target, 마법도구 weapon){

		if(weapon instanceof 물약) {
			System.out.println("물약으로는 공격할 수 없습니다.");
			return;
		}

		if(weapon instanceof 투명망토) {
			System.out.println("투명망토로는 공격할 수 없습니다.");
			return;
		}

		if(target.getWeapon() instanceof 투명망토) {
			System.out.println(target.getName() + " 이/가 " + target.getWeapon().getName() +" 을/를 가져서 공격이 무효화됩니다.");
			target.setWeapon(null);
		}
		else {
			System.out.println(this.getName() + " 이/가 " + weapon.getName() + " 으로 " +target.getName() + "을/를 공격합니다.");
			target.setHp(target.getHp() - (this.getSkill()+ weapon.getSkill())*7);
		}  	

	}

	//한명의 상태보이기
	public void showStatus() {
        if(this.hp <= 0) {
            System.out.printf("%s (☠ 사망)\n", this.getName());
        } else {
            System.out.printf("%s(hp: %d, skill: %d)\n", this.getName(), this.getHp(), this.getSkill());
        }
    }


	public String getName() {return name;}

	public void setName(String name) {this.name = name;}

	public int getHp() {return hp;}

	public void setHp(int hp) {this.hp = Math.max(0, hp);} //HP가 음수가 되지 않도록 수정했습니다! 

	public int getSkill() {return skill;}

	public void setSkill(int skill) {this.skill = skill;}

	public 마법도구 getWeapon() {return weapon;}

	public void setWeapon(마법도구 weapon) {this.weapon = weapon;}



}
