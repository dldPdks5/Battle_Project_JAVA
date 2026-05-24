//Main
import 마법사.*;
import 마법도구.*;
import java.util.*;
import java.util.Random;


public class Main2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		

		해리포터 haPd = new 해리포터("짱해리포터", 200, 20); //원래 1000이었음
		헤르미온느 heMi = new 헤르미온느("똑똑헤르미온느", 200, 20);
		볼드모트 vol = new 볼드모트("무섭볼트모트", 200, 20);
		벨라트릭스 bel = new 벨라트릭스("강렬벨라트릭스", 200, 20);

		지팡이 cane = new 지팡이("지팡이", 50);
		투명망토 cape = new 투명망토("투명망토", 50);
		그리핀도르의칼 sword = new 그리핀도르의칼("그리핀도르의칼", 50);
		물약 medicine = new 물약("물약", 50);
	
		ArrayList<마법사> goodTeam = new ArrayList<마법사>();
		goodTeam.add(haPd);
		goodTeam.add(heMi);
		ArrayList<마법사> badTeam = new ArrayList<마법사>();
		badTeam.add(vol);
		badTeam.add(bel);

		haPd.showStatus();
		heMi.showStatus();
		vol.showStatus();
		bel.showStatus();

		int num = 0;

		마법사 attacker, target;
		마법도구 weapon;
		System.out.println("============<해리포터 게임!>============");

		while(true) {

			System.out.println("<<공격할 마법사를 선택하세요. >>");
			//for문으로 각각의 name 받기 ArrayList
			for(int i=0;i<goodTeam.size();i++) {
				System.out.printf("%d. %s ", (i+1), goodTeam.get(i).getName());
			}
			for(int i=0;i<badTeam.size();i++) {
				System.out.printf("%d. %s ", (i+1), badTeam.get(i).getName());
			}
			System.out.println();

			System.out.print("입력 : ");
			num = input.nextInt();
			
			//배열의 숫자

			if(num==1) attacker = haPd;
			else if(num == 2) attacker = heMi;
			else if(num == 3) attacker = vol;
			else if(num == 4) attacker = bel;
			else {
				System.out.println("메뉴에서 마법사를 다시 선택해주세요. 게임을 다시 시작합니다. "); 
				continue;
			}

			Random r = new Random();
			int i = r.nextInt(5); //무기 랜덤으로 돌려서 넣기

			if(i==0) attacker.setWeapon(cane);
			else if(i == 1) attacker.setWeapon(cape);
			else if(i == 2) attacker.setWeapon(sword);
			else if(i == 3) attacker.setWeapon(medicine);
			else if(i == 4) attacker.setWeapon(null); //무기가 없는 경우

			if(attacker.getWeapon() ==null)
				System.out.println(attacker.getName()+"의 무기는 없습니다. ");
			else
				System.out.println(attacker.getName()+"의 무기는 "+attacker.getWeapon());

			//attacker == 헤르미온느, 벨라트릭스 
			//마법도구  = 물약
			if(attacker.getWeapon() instanceof 물약) {
				if(attacker == heMi) {
					System.out.println(attacker.getName()+" 이/가 "+haPd.getName()+" 을/를 치유합니다. ");
					haPd.setHp(haPd.getHp()+20);
					System.out.println("게임을 다시 시작합니다!"); 
					continue;
				}
				else if(attacker == bel){
					System.out.println(attacker.getName()+" 이/가 "+vol.getName()+" 을/를 치유합니다. ");
					vol.setHp(vol.getHp()+20);
					System.out.println("게임을 다시 시작합니다!"); 
					continue;
				}
			}


			System.out.println("<<공격할 대상을 선택하세요. >>");
			
			//이것도 ArrayList로
			System.out.printf("1. %s 2. %s 3. %s 4. %s", haPd.getName(), heMi.getName(), vol.getName(), bel.getName());
			System.out.println();
			System.out.print("입력 : ");
			num = input.nextInt();

			if(num==1) target = haPd;
			else if(num == 2) target = heMi;
			else if(num == 3) target = vol;
			else if(num == 4) target = bel;
			else {
				System.out.println("메뉴에서 마법사를 다시 선택해주세요. 게임을 다시 시작합니다. "); 
				continue;
			}

			int m = r.nextInt(2); //target에 투명망토 랜덤으로 돌려서 넣기
			if(m == 0) target.setWeapon(cape); //if(m == 0) target.setWeapon(null);
			else target.setWeapon(null); //else target.setWeapon(cape);


			System.out.println("[attacker]는 "+attacker.getName() +", [target]은 "+target.getName()+"입니다. ");



			if(attacker.getWeapon() ==null)//무기가 없는 경우, 
				attacker.공격하기(target);
			else //무기가 있는 경우,
				attacker.공격하기(target, attacker.getWeapon());

			
			System.out.println("공격이 끝났습니다. ");

			haPd.showStatus();
			heMi.showStatus();
			vol.showStatus();
			bel.showStatus();
			System.out.println();
			
			if(target.getHp() <= 0) {

			    if(goodTeam.contains(target)) {
			        goodTeam.remove(target);
			    }

			    else if(badTeam.contains(target)) {
			        badTeam.remove(target);
			    }

			    System.out.println(target.getName() + " 탈락!");
			}
			
			//한팀이 전멸하면 게임끝
			// 팀에서 없애기, 게임에서 없애기
			if(goodTeam.size()==0 || badTeam.size()==0) {
				System.out.println("게임이 끝났어요~~~!!");
				break;
			}


		}


	}

}
