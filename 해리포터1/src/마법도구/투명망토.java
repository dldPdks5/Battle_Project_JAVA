package 마법도구;
public class 투명망토 extends 마법도구 {
	
	int skill = 50;

	public 투명망토() {}
	
	public 투명망토(String name) {
		super(name);
	}
	
//	public 투명망토(String name, int skill) {
//		super(name, skill);
//	}
	
	public void 방어하기() {
		System.out.println("투명망토로 공격을 막기!!");
	}
	
	public void 공격 () {
		System.out.println("투명망토로는 공격할 수 없습니다.");
	}
	
	
	public int getSkill() {
		return this.skill;
	}

	public void setSkill(int skill) {
		this.skill = skill;
	}
}
