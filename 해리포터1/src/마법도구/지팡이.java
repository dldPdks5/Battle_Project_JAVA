package 마법도구;
public class 지팡이 extends 마법도구 {
	
	int skill = 70;

	public 지팡이() {}
	
	public 지팡이(String name) {
		super(name);
	}

	public void 영혼뺏기() {
		System.out.println("지팡이로 영혼을 빼내기! 익스펙토페트로놈~!");
	}
	
	@Override
	public void 공격 () {
		this.영혼뺏기();
	}
	
	public int getSkill() {
		return this.skill;
	}

	public void setSkill(int skill) {
		this.skill = skill;
	}
}
