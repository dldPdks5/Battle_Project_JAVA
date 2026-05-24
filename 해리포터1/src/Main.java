import 마법사.*;
import 마법도구.*;
import java.util.*;
import java.util.Random;


public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		//캐릭터 생성 
		해리포터 haPd = new 해리포터("짱해리포터", 1000, 100);
		헤르미온느 heMi = new 헤르미온느("똒똑헤르미온느", 1000, 100);
		볼드모트 vol = new 볼드모트("무섭볼트모트", 1000, 100);
		벨라트릭스 bel = new 벨라트릭스("강렬벨라트릭스", 1000, 100);

		//팀끼리 리스트 생성 
		List<마법사> goodTeam = new ArrayList();
		goodTeam.add(haPd);
		goodTeam.add(heMi);

		List<마법사> evilTeam = new ArrayList<>();
		evilTeam.add(vol);
		evilTeam.add(bel);

		//마법사 전체 리스트 하나 더 생성함. 
		List<마법사> allWizards = new ArrayList<>();
		allWizards.add(haPd);
		allWizards.add(heMi);
		allWizards.add(vol);
		allWizards.add(bel);

		//무기 생성 
		지팡이 cane = new 지팡이("마법지팡이");
		투명망토 cape = new 투명망토("예쁜투명망토");
		그리핀도르의칼 sword = new 그리핀도르의칼("쌩그리핀도르의칼");
		물약 medicine = new 물약("치유물약");

		//무기 리스트 생성 
		List<마법도구> weaponList = new ArrayList<>();
		weaponList.add(cane);
		weaponList.add(cape);
		weaponList.add(sword);
		weaponList.add(medicine);


		마법사 attacker, target;
		System.out.println();
		System.out.println("============<해리포터 게임!>============");

		while(true) {
			// 게임 종료 -  리스트가 비어있으면 전멸
			if (goodTeam.isEmpty()) {
				System.out.println("======= 게임 종료: 볼드모트 팀 승리! =======");
				break;
			} else if (evilTeam.isEmpty()) {
				System.out.println("======= 게임 종료: 해리포터 팀 승리! =======");
				break;
			}

			// 현재 생존자 상태 출력
			System.out.println("\n------ [현재 생존자 상태] ------");
			for (int i = 0; i < allWizards.size(); i++) {
				allWizards.get(i).showStatus();
			}
			System.out.println("------------------------");

			
			
			System.out.println("<<공격할 마법사를 선택하세요. >>");
			for(int i=0; i<allWizards.size(); i++) {
				System.out.printf("%d. %s ", (i + 1), allWizards.get(i).getName());
			}
			System.out.print("\n입력 : ");
			int attackerId = input.nextInt() - 1;


			if (attackerId < 0 || attackerId >= allWizards.size()) {
				System.out.println("잘못된 선택입니다. 처음으로 돌아갑니다.");
				continue;
			}
			attacker = allWizards.get(attackerId);


			boolean isHealing = false;

			//attacker == 헤르미온느, 벨라트릭스 
			//마법도구  = 물약
			if (attacker instanceof 헤르미온느 || attacker instanceof 벨라트릭스) {
				System.out.println("<< 수행할 행동을 선택하세요 >>");
				System.out.println("1. 공격하기  2. 치유하기");
				System.out.print("입력 : ");
				int action = input.nextInt();

				if (action == 2) { //치유 모드
					isHealing = true;
				}
			}

			if (isHealing) {
				마법사 healTarget = null;
				
				System.out.println("<<공격(치유)할 대상을 선택하세요. >>");
				for (int i = 0; i < allWizards.size(); i++) {
					System.out.printf("%d. %s ", (i + 1), allWizards.get(i).getName());
				}
				System.out.print("\n입력 : ");
				int targetId2 = input.nextInt() - 1;
				
				healTarget = allWizards.get(targetId2);				

				if (goodTeam.contains(healTarget) || evilTeam.contains(healTarget)) {
					if(attacker instanceof 헤르미온느) {
						마법도구 물약;
						((헤르미온느)attacker).치료하기(healTarget, medicine);
					}
					else if(attacker instanceof 벨라트릭스) {
						((벨라트릭스)attacker).치료하기(healTarget, medicine);
					}
				} 
				else {
					System.out.println("치유 대상이 이미 사망하여 치유할 수 없습니다.");
				}

				System.out.println("턴이 끝났습니다.");
				continue; 
			}
			else {
				System.out.println("<< 장착할 무기를 선택하세요 >>");
				System.out.print("0. 맨손(무기 없음)");

				for (int i = 0; i < weaponList.size(); i++) {
					System.out.printf(" %d. %s(스킬력: %d) ", (i + 1), weaponList.get(i).getName(), weaponList.get(i).getSkill());
				}
				System.out.print("\n입력 : ");
				int weaponId = input.nextInt();

				if (weaponId == 0) {
					attacker.setWeapon(null);
					System.out.println(attacker.getName() + "의 무기는 없습니다.");
				} else if (weaponId > 0 && weaponId <= weaponList.size()) {
					attacker.setWeapon(weaponList.get(weaponId - 1));
					System.out.println(attacker.getName() + "의 무기는 " + attacker.getWeapon().getName() + "입니다.");
				} else {
					System.out.println("잘못된 무기 선택입니다. 처음으로 돌아갑니다.");
					continue;
				}

			}


			System.out.println("<<공격할 대상을 선택하세요. >>");
			for (int i = 0; i < allWizards.size(); i++) {
				System.out.printf("%d. %s ", (i + 1), allWizards.get(i).getName());
			}
			System.out.print("\n입력 : ");
			int targetId = input.nextInt() - 1;

			if (targetId < 0 || targetId >= allWizards.size()) {
				System.out.println("잘못된 선택입니다. 처음으로 돌아갑니다.");
				continue;
			}
			target = allWizards.get(targetId);

			Random r = new Random();

			System.out.println("[attacker]는 " + attacker.getName() + ", [target]은 " + target.getName() + "입니다.");

			int m = r.nextInt(4);
			if (m == 0) {
				// target.setWeapon(new 투명망토("투명망토", 50));
				target.setWeapon(new 투명망토("예쁜투명망토"));
			}

			//랜덤으로 럭키.. 공격 7배를 추가해 봤어요 + 마법사에 럭키공격() 생성자
			int lucky = r.nextInt(8); ///랜덤 럭키 숫자
			if(lucky==7) {
				System.out.println("★★★★★★★럭키 공격 7배!!★★★★★★★");
				if (attacker.getWeapon() == null) attacker.럭키공격(target);					
				else attacker.럭키공격(target, attacker.getWeapon());
			}
			else {
				if (attacker.getWeapon() == null) attacker.공격하기(target);
				else attacker.공격하기(target, attacker.getWeapon());
			}
			

			if (target.getHp() <= 0) {
				System.out.println("☠ " + target.getName() + " 이/가 쓰러졌습니다. ☠");
				goodTeam.remove(target);
				evilTeam.remove(target);
				allWizards.remove(target); // 선택지에서도 삭제
			}

			System.out.println("공격이 끝났습니다. ");

		}


	}

}