package player;
import java.util.Scanner;

import weapon.*;

public class 헤르미온느 extends 마법사 implements IHeal {

	public 헤르미온느() {}
	public 헤르미온느(String name, int hp, int skill) {
		super(name, hp, skill);
	}

	public void 책읽기(){
		System.out.println("헤르미온느 : 책읽으며 열공");
	}

	public void 마법연습하기(){
		System.out.println("헤르미온느 : 마법연습! 윙가르디움 레비오우사!");
	}

	public void 치료하기() {}
	
	public void 치료하기(마법도구 medicine) {}


	// 헤르미온느가 마법사로 선택되었으니까 super로 이름은 받고, 행동은 아래부터보이도록 꼭 헤르미온느 타입으로 받아야 함.

	Scanner input = new Scanner(System.in);



	public void 치료하기(마법사 target, 마법도구 medicine) {
		if(target instanceof 볼드모트 || target instanceof 벨라트릭스 ) {
			System.out.println("다른팀은 치료할 수 없습니다.");
			return;
		}
		
		if(medicine instanceof 물약) {
			target.setHp(target.getHp()+ medicine.getSkill());
			System.out.println(super.getName() + "이 " + medicine.getName() +"으로 " + target.getName() +"을 치료합니다." );
		}
		else {
			System.out.println("마법도구가 물약이 아니면 치료할 수 없습니다.");
		}
	}

	public void 공격하기(마법사 target) {
		if(target instanceof 헤르미온느 || target instanceof 해리포터) {
			System.out.println("자기자신이나 같은 팀은 공격할 수 없습니다.");
			return;
		}
		else {
			super.공격하기(target);
		}
	}
	
	public void 럭키공격(마법사 target) {
		if(target instanceof 헤르미온느 || target instanceof 해리포터) {
			System.out.println("자기자신이나 같은 팀은 공격할 수 없습니다.");
			return;
		}
		else {
			super.럭키공격(target);
		}
	}



	public void 공격하기(마법사 target, 마법도구 weapon) {
		if(target instanceof 헤르미온느 || target instanceof 해리포터) {
			System.out.println("자기자신이나 같은 팀은 공격할 수 없습니다.");
			return; // 값을 넣으면 reuturn 값 나와서 다시 출력하는 걸로
		}

		else {
			super.공격하기(target, weapon);
		}

	}

	public void 럭키공격(마법사 target, 마법도구 weapon) {
		if(target instanceof 헤르미온느 || target instanceof 해리포터) {
			System.out.println("자기자신이나 같은 팀은 공격할 수 없습니다.");
			return; // 값을 넣으면 reuturn 값 나와서 다시 출력하는 걸로
		}

		else {
			super.럭키공격(target, weapon);
		}

	}
	@Override
	public void 치료하기(마법사 target) {
		// TODO Auto-generated method stub
		
	}

}
