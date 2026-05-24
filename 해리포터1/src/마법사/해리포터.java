package 마법사;
import 마법도구.*;

public class 해리포터 extends 마법사 {
	
	public 해리포터() {}
	public 해리포터(String name, int hp, int skill) {
		super(name, hp, skill);
	}

	public void 퀴디치경기하기() {
		System.out.println("해리포터 : 골드 스니치 잡으러 가야지~!");
	}

	public void 케이크먹기() {
		System.out.println("해리포터 : 케이크 먹어요! 너무 맛있당 >.<");
	}

	public void 마법수련하기() {
		System.out.println("해리포터 : 웡→가↗디→움↘레→비→오→사↗? 웡→가↗디→움↘레→비→오⤴사↗?");
	}
	
	@Override
    public void 공격하기(마법사 target) {
    	if(target instanceof 해리포터 || target instanceof 헤르미온느) {
    		System.out.println("자기자신이나 같은 팀은 공격할 수 없습니다.");
    		return;
    	}
    	else {
    		super.공격하기(target);
    	}
    }
	
	public void 럭키공격(마법사 target) {
    	if(target instanceof 해리포터 || target instanceof 헤르미온느) {
    		System.out.println("자기자신이나 같은 팀은 공격할 수 없습니다.");
    		return;
    	}
    	else {
    		super.럭키공격(target);
    	}
    }
	

	@Override
    public void 공격하기(마법사 target, 마법도구 weapon) {
    	if(target instanceof 해리포터 || target instanceof 헤르미온느) {
    		System.out.println("자기자신이나 같은 팀은 공격할 수 없습니다.");
    		return;
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

}
    
