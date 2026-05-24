//마법도구
package 마법도구;
public class 마법도구 {
	private String name;
	private int skill;

	public 마법도구() {}
	
	public 마법도구(String name) {
		this.name = name;
	}
	
	public void 공격 () {
		System.out.println("마법도구로 공격합니다");
	}
	

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSkill() {
		return this.skill;
	}

	public void setSkill(int skill) {
		this.skill = skill;
	}
	
//	public String toString() {
//        return this.name; // 객체를 출력할 때 이름만 반환하도록 설정
//    }

}
