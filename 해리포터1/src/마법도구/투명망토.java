package 마법도구;
public class 투명망토 extends 마법도구 {
	
	int skill = 40;

	public 투명망토() {}
	
	public 투명망토(String name) {
		super(name);
	}
	
	public void 방어하기() {
		System.out.println("투명망토로 공격을 막아 무효화됩니다!");
	}
	
	@Override
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
