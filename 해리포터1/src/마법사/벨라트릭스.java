//벨라트릭스
package 마법사;
import 마법도구.*;

public class 벨라트릭스 extends 마법사 implements IHeal {
	
	public 벨라트릭스() {}
	public 벨라트릭스(String name, int hp, int skill) {
		super(name, hp, skill);
	}

    public void 탈옥하기(){
	    System.out.println("벨라트릭스 : 나가서 세상을 정복하자 우하하");
    }

    public void 고문하기(){
	    System.out.println("벨라트릭스 : 저 아이를 데려와서 고문해라");
    }

    public void 소리지르기(){
	    System.out.println("벨라트릭스 : 끼이이ㅑ야야야이야야야핫");
    }


	public void 치료하기() {}
	
	public void 치료하기(마법사 target) {
		
	}
	
	// 벨라트릭스가 마법사로 선택되었으니까 super로 이름은 받고, 행동은 아래부터보이도록 꼭 헤르미온느 타입으로 받아야 함.

	//아래 수정
	public void 치료하기(마법사 target, 마법도구 medicine) {
		if(target instanceof 해리포터 || target instanceof 헤르미온느 ) {
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
    	if(target instanceof 벨라트릭스 || target instanceof 볼드모트) {
    		System.out.println("자기자신이나 같은 팀은 공격할 수 없습니다.");
    		return;
    	}
    	else {
    		super.공격하기(target);
    	}
	}
    public void 공격하기(마법사 target, 마법도구 weapon) {
    	if(target instanceof 벨라트릭스 || target instanceof 볼드모트) {
    		System.out.println("자기자신이나 같은 팀은 공격할 수 없습니다.");
    		return;
    	}
    	
    	else {
    		super.공격하기(target, weapon);
    	}

    }
    public void 럭키공격(마법사 target, 마법도구 weapon) {
    	if(target instanceof 벨라트릭스 || target instanceof 볼드모트) {
    		System.out.println("자기자신이나 같은 팀은 공격할 수 없습니다.");
    		return; // 값을 넣으면 reuturn 값 나와서 다시 출력하는 걸로
    	}
    	
    	else {
    		super.럭키공격(target, weapon);
    	}

    }

}