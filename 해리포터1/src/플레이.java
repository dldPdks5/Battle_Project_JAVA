import 마법사.*;
import 마법도구.*;
import java.util.*;
import java.util.Random;


public class 플레이 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		해리포터 haPd = new 해리포터("짱해리포터", 1000, 100);
		헤르미온느 heMi = new 헤르미온느("똒똑헤르미온느", 1000, 100);
		볼드모트 vol = new 볼드모트("무섭볼트모트", 1000, 100);
		벨라트릭스 bel = new 벨라트릭스("강렬벨라트릭스", 1000, 100);

		지팡이 cane = new 지팡이("뾰롱지팡이", 50);
		투명망토 cape = new 투명망토("촤락투명망토", 50);
		그리핀도르의칼 sword = new 그리핀도르의칼("씽그리핀도르의칼", 50);
		물약 medicine = new 물약("예쁜물약", 50);

		haPd.showStatus();
		heMi.showStatus();
		vol.showStatus();
		bel.showStatus();

		int num = 0;

		마법사 attacker, target;
		마법도구 weapon;
		System.out.println("============<해리포터 게임!>============");

		while(true) {
			String choice = "공격";
			boolean teamGoodDead = (haPd.getHp() <= 0 && heMi.getHp() <= 0);

			boolean teamEvilDead = (vol.getHp() <= 0 && bel.getHp() <= 0);

			if (teamGoodDead) {
				System.out.println("======= 게임 종료: 볼드모트 팀 승리! =======");
				break;
			} else if (teamEvilDead) {
				System.out.println("======= 게임 종료: 해리포터 팀 승리! =======");
				break;
			}
			
			System.out.println("");
			
			// 미법사 배열에 넣기
			마법사 [] 플레이어 = {haPd, heMi, vol, bel};

			System.out.println("<<공격할 마법사를 선택하세요. >>");
			System.out.printf("1. %s 2. %s 3. %s 4. %s", haPd.getName(), heMi.getName(), vol.getName(), bel.getName());
			System.out.println();
			System.out.print("입력 : ");
			num = input.nextInt();
			
			if(num<1 || num>4) {
				System.out.println("메뉴에서 마법사를 다시 선택해주세요. 게임을 다시 시작합니다. "); 
				continue;
			}
			attacker = 플레이어[num-1];
			

//			if(num==1) attacker = haPd; //업캐스팅 사용!
//			else if(num == 2) attacker = heMi;
//			else if(num == 3) attacker = vol;
//			else if(num == 4) attacker = bel;
//			else {
//				System.out.println("메뉴에서 마법사를 다시 선택해주세요. 게임을 다시 시작합니다. "); 
//				continue;
//			}

			// 무기 배열 만들어 랜덤 넣기
			마법도구 [] 무기 = {cane, cape,sword, medicine, null};
			
			Random r = new Random();
			int i = r.nextInt(5); //무기 랜덤으로 돌려서 넣기
			
			attacker.setWeapon(무기[i]);

			if(attacker.getWeapon() ==null)
				System.out.println(attacker.getName()+"의 무기는 없습니다. ");
			else
				System.out.println(attacker.getName()+"의 무기는 "+attacker.getWeapon().getName());
			
			if(attacker == heMi || attacker == bel) {
				System.out.print("공격할지 치유할지 선택하세요 : ");
				choice = input.next();
			}
			
			
			
			//attacker == 헤르미온느, 벨라트릭스 
			//마법도구  = 물약
//			if(choice.equals("치유") && attacker.getWeapon() instanceof 물약) {
//				if(attacker == heMi) {
//					
//					System.out.println(attacker.getName()+" 이/가 "+haPd.getName()+" 을/를 치유합니다. ");
//					haPd.setHp(haPd.getHp()+20);
//					System.out.println("게임을 다시 시작합니다!"); 
//					System.out.println();
//					continue;
//				}
//				else if(attacker == bel){
//					System.out.println(attacker.getName()+" 이/가 "+vol.getName()+" 을/를 치유합니다. ");
//					vol.setHp(vol.getHp()+20);
//					System.out.println("게임을 다시 시작합니다!"); 
//					System.out.println();
//					continue;
//				}
//			}
//			else {
//				System.out.println("물약이 없어 치유할 수 없습니다.");
//			}

			System.out.println("<<공격(치유)할 대상을 선택하세요. >>");
			System.out.printf("1. %s 2. %s 3. %s 4. %s", haPd.getName(), heMi.getName(), vol.getName(), bel.getName());
			System.out.println();
			System.out.print("입력 : ");
			num = input.nextInt();
			
			if(num<1 || num>4) {
				System.out.println("메뉴에서 마법사를 다시 선택해주세요. 게임을 다시 시작합니다. "); 
				continue;
			}
			target = 플레이어[num-1];

//			if(num==1) target = haPd;
//			else if(num == 2) target = heMi;
//			else if(num == 3) target = vol;
//			else if(num == 4) target = bel;
//			else {
//				System.out.println("메뉴에서 마법사를 다시 선택해주세요. 게임을 다시 시작합니다. "); 
//				continue;
//			}

			int m = r.nextInt(4); //target에 투명망토 랜덤으로 돌려서 넣기
			if(m == 0) target.setWeapon(cape);
			else target.setWeapon(null);


			System.out.println("[attacker]는 "+attacker.getName() +", [target]은 "+target.getName()+"입니다. ");
			
			
			if(choice.equals("치유")) {
				if(attacker instanceof 헤르미온느) {
					((헤르미온느)attacker).치료하기(target, attacker.getWeapon());
				}
				else if(attacker instanceof 벨라트릭스) {
					((벨라트릭스)attacker).치료하기(target, attacker.getWeapon());
				}
				haPd.showStatus();
				heMi.showStatus();
				vol.showStatus();
				bel.showStatus();
				System.out.println();
				continue;
			}

			
			//랜덤으로 럭키.. 공격 7배를 추가해 봤어요 + 마법사에 럭키공격() 생성자
			int lucky = r.nextInt(8); ///랜덤 럭키 숫자
			if(lucky==7) {
				System.out.println("럭키 공격 7배!!");
				if(attacker.getWeapon() ==null)//무기가 없는 경우, 
					attacker.럭키공격(target);
				else //무기가 있는 경우,
					attacker.럭키공격(target, attacker.getWeapon());
			}
			else {
				if(attacker.getWeapon() ==null)//무기가 없는 경우, 
					attacker.공격하기(target);
				else //무기가 있는 경우,
					attacker.공격하기(target, attacker.getWeapon());
			}
			
			System.out.println("공격이 끝났습니다. ");

			haPd.showStatus();
			heMi.showStatus();
			vol.showStatus();
			bel.showStatus();
			System.out.println();


		}


	}

}
