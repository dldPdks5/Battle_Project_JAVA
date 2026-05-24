package 마법도구;
public class 물약 extends 마법도구 {
	
	int skill = 60;

	public 물약() {}
	
	public 물약(String name) {
		super(name);
	}
	
	public void 상처치유() {
		System.out.println("물약으로 상처치유~~");
	}
	
	@Override
	public void 공격 () {
		System.out.println("물약으로는 공격할 수 없습니다.");
	}
	
	
	public int getSkill() {
		return this.skill;
	}

	public void setSkill(int skill) {
		this.skill = skill;
	}
}