package 마법도구;

public class 그리핀도르의칼 extends 마법도구 {
	
	int skill = 50;


	public 그리핀도르의칼(String name) {
		super(name);
	}
	

	public void 찌르기() {
		System.out.println("그리핀도르 칼로 찌르기!");
	}
	
	@Override
	public void 공격() {
		this.찌르기();
	}
	
	public int getSkill() {
		return this.skill;
	}

	public void setSkill(int skill) {
		this.skill = skill;
	}
}
