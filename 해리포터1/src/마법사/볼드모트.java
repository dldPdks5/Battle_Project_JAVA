package 마법사;
import 마법도구.*;

public class 볼드모트 extends 마법사 {
	
	public 볼드모트() {}
	public 볼드모트(String name, int hp, int skill) {
		super(name, hp, skill);
	}

    public void 영혼뺏어먹기(){
    	System.out.println("볼드모트 : 츄릅. 영혼을 먹엇어용");
    }

    public void 혼내기(){
    	System.out.println("볼드모트 : 어헛!");
    }
   public void 공격하기(마법사 target) {
    	if(target instanceof 볼드모트 || target instanceof 벨라트릭스) {
    		System.out.println("자기자신이나 같은 팀은 공격할 수 없습니다.");
    		return;
    	}
    	else {
    		super.공격하기(target);
    	}
	}
   
   public void 럭키공격(마법사 target) {
   	if(target instanceof 볼드모트 || target instanceof 벨라트릭스) {
   		System.out.println("자기자신이나 같은 팀은 공격할 수 없습니다.");
   		return;
   	}
   	else {
   		super.럭키공격(target);
   	}
	}
	
   public void 공격하기(마법사 target, 마법도구 weapon) {
    	if(target instanceof 볼드모트 || target instanceof 벨라트릭스) {
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