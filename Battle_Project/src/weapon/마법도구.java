package weapon;
public class 마법도구 {
	private String name;
	private int skill;

	public 마법도구() {}
	public 마법도구(String name, int skill) {
		this.name = name;
		this.skill = skill;
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
	
	

}
