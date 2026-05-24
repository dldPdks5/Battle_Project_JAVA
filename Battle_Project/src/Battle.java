import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;

import player.*;
import weapon.*;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

public class Battle extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel 해리포터Img;
	private JButton 해리포터_선택btn;
	private JLabel 헤르미온느Img;
	private JButton 헤르미온느_선택btn;
	private JButton 볼드모트_선택btn;
	private JLabel 벨라트릭스Img;
	private JButton 벨라트릭스_선택btn;
	private JLabel 볼드모트Img;
	private JProgressBar progressBar_haPd;
	private JProgressBar progressBar_heMi;
	private JProgressBar progressBar_vol;
	private JProgressBar progressBar_bel;
	private JButton 공격하기_btn;
	private JButton 치유하기_btn;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_3;
	private JPanel panel_2;
	private JButton btnNewButton_1;
	private JButton btnNewButton;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnx;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
    private JTextArea textArea;
	
	private List<마법사> allWizards;
    private List<마법사> goodTeam;
    private List<마법사> evilTeam;
    private List<마법도구> weaponList;
    
    private 마법사 attacker = null;
    private 마법사 target = null;
    private 마법도구 selectedWeapon = null;
    
    private JLabel statusGuideLabel;
   
    

	/**
	 * Create the frame.
	 */
	public Battle(List<마법사> allWizards, List<마법사> goodTeam, List<마법사> evilTeam, List<마법도구> weaponList) {
		this.allWizards = allWizards;
		this.goodTeam = goodTeam;
		this.evilTeam = evilTeam;
		this.weaponList = weaponList;		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//현재 단계 설명
		statusGuideLabel = new JLabel("★ 먼저 행동할 [공격자] 캐릭터 버튼을 클릭하세요!");
		statusGuideLabel.setBounds(277, 355, 400, 23);
		statusGuideLabel.setForeground(Color.BLUE);
		contentPane.add(statusGuideLabel);
		
		공격하기_btn = new JButton("공격하기");
		공격하기_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				executeAction(false); // 공격 실행
			}
		});
		공격하기_btn.setBounds(277, 330, 109, 23);
		contentPane.add(공격하기_btn);
		
		치유하기_btn = new JButton("치유하기");
		치유하기_btn.setBounds(409, 330, 109, 23);
		contentPane.add(치유하기_btn);
		
		panel = new JPanel();
		panel.setBounds(10, 10, 245, 164);
		contentPane.add(panel);
		panel.setLayout(null);
		
		해리포터_선택btn = new JButton("해리포터");
		해리포터_선택btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		해리포터_선택btn.setBounds(142, 28, 93, 23);
		panel.add(해리포터_선택btn);
		
		해리포터Img = new JLabel("");
		해리포터Img.setBounds(11, 10, 121, 117);
		panel.add(해리포터Img);
		해리포터Img.setIcon(new ImageIcon(Battle.class.getResource("/image/해리포터.jpg")));
		해리포터Img.setBackground(Color.YELLOW);
		
		progressBar_haPd = new JProgressBar();
		progressBar_haPd.setBounds(11, 137, 226, 14);
		panel.add(progressBar_haPd);
		progressBar_haPd.setValue(100);
		progressBar_haPd.setForeground(Color.RED);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 787, 347);
		panel.add(lblNewLabel);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 184, 245, 164);
		contentPane.add(panel_1);
		
		헤르미온느Img = new JLabel("");
		헤르미온느Img.setBounds(10, 10, 121, 117);
		panel_1.add(헤르미온느Img);
		헤르미온느Img.setIcon(new ImageIcon(Battle.class.getResource("/image/헤르미온느.jpg")));
		
		헤르미온느_선택btn = new JButton("헤르미온느");
		헤르미온느_선택btn.setBounds(141, 31, 93, 23);
		panel_1.add(헤르미온느_선택btn);
		
		progressBar_heMi = new JProgressBar();
		progressBar_heMi.setBounds(10, 140, 226, 14);
		panel_1.add(progressBar_heMi);
		progressBar_heMi.setValue(100);
		progressBar_heMi.setForeground(Color.RED);
		
		panel_2 = new JPanel();
		panel_2.setBounds(535, 10, 253, 164);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		볼드모트Img = new JLabel("");
		볼드모트Img.setBounds(10, 10, 121, 117);
		panel_2.add(볼드모트Img);
		볼드모트Img.setIcon(new ImageIcon(Battle.class.getResource("/image/볼드모트.jpg")));
		
		볼드모트_선택btn = new JButton("볼드모트");
		볼드모트_선택btn.setBounds(143, 31, 93, 23);
		panel_2.add(볼드모트_선택btn);
		
		progressBar_vol = new JProgressBar();
		progressBar_vol.setBounds(10, 140, 226, 14);
		panel_2.add(progressBar_vol);
		progressBar_vol.setValue(100);
		progressBar_vol.setForeground(Color.RED);
		
		panel_3 = new JPanel();
		panel_3.setBounds(535, 184, 253, 164);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		벨라트릭스Img = new JLabel("");
		벨라트릭스Img.setBounds(10, 10, 121, 117);
		panel_3.add(벨라트릭스Img);
		벨라트릭스Img.setIcon(new ImageIcon(Battle.class.getResource("/image/벨라트릭스.jpg")));
		
		벨라트릭스_선택btn = new JButton("벨라트릭스");
		벨라트릭스_선택btn.setBounds(141, 30, 93, 23);
		panel_3.add(벨라트릭스_선택btn);
		
		progressBar_bel = new JProgressBar();
		progressBar_bel.setBounds(8, 137, 226, 14);
		panel_3.add(progressBar_bel);
		progressBar_bel.setValue(100);
		progressBar_bel.setForeground(Color.RED);
		
		btnNewButton = new JButton("지팡이");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(10, 383, 102, 95);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("그리핀도르의칼");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(178, 383, 102, 95);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("투명망토");
		btnNewButton_2.setBounds(350, 383, 102, 95);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("물약");
		btnNewButton_3.setBounds(535, 383, 102, 95);
		contentPane.add(btnNewButton_3);
		
		btnx = new JButton("무기X");
		btnx.setBounds(686, 383, 102, 95);
		contentPane.add(btnx);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(278, 12, 239, 308);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		textArea.append("============<해리포터 게임!>============\n");
		printCurrentStatus(); // 현재 생존자 생태를 JTextArea에 표시
		updateHpBars();

	}
	
	
	
	
	private void executeAction(boolean isHealingMode) {
		if (attacker == null || target == null) {
			JOptionPane.showMessageDialog(this, "공격자와 대상을 모두 선택해야 합니다!");
			return;
		}

		textArea.append("\n🔔 --- 턴 시작 --- 🔔\n");

		// [치유 모드] 구현
		if (isHealingMode) {
			if (attacker instanceof 헤르미온느) {
				((헤르미온느) attacker).치료하기(target, findWeaponByName("물약"));
				textArea.append("💚 헤르미온느가 " + target.getName() + "을 치유했습니다.\n");
			} else if (attacker instanceof 벨라트릭스) {
				((벨라트릭스) attacker).치료하기(target, findWeaponByName("물약"));
				textArea.append("💚 벨라트릭스가 " + target.getName() + "을 치유했습니다.\n");
			} else {
				textArea.append("❌ " + attacker.getName() + "는 치유 스킬이 없습니다! 공격만 가능합니다.\n");
				return;
			}
		} 
		// [공격 모드] 구현
		else {
			Random r = new Random();
			int m = r.nextInt(4);
			if (m == 0) {
				target.setWeapon(new 투명망토("투명망토", 50));
				textArea.append("[이벤트] " + target.getName() + "이/가 투명망토를 두릅니다!\n");
			}

			// 럭키 공격 확률 계산
			int lucky = r.nextInt(8);
			if (lucky == 7) {
				textArea.append("💥💥 럭키 공격 7배 발동!! 💥💥\n");
				if (attacker.getWeapon() == null) attacker.럭키공격(target);
				else attacker.럭키공격(target, attacker.getWeapon());
			} else {
				if (attacker.getWeapon() == null) attacker.공격하기(target);
				else attacker.공격하기(target, attacker.getWeapon());
			}
			
			textArea.append("⚔️ " + attacker.getName() + " ➔ " + target.getName() + " 공격 완료!\n");
		}

		// 사후 결과 반영 및 체력바 UI 업데이트
		updateHpBars();

		// 사망 처리 판정
		if (target.getHp() <= 0) {
			textArea.append("☠️ " + target.getName() + "이(가) 쓰러졌습니다.\n");
			goodTeam.remove(target);
			evilTeam.remove(target);
			allWizards.remove(target);
			
			// 쓰러진 캐릭터 버튼 비활성화 처리
			disableDeadButton(target.getName());
		}

		// 승리 조건 체크
		if (goodTeam.isEmpty()) {
			JOptionPane.showMessageDialog(this, "게임 종료: 볼드모트 팀 승리!");
			공격하기_btn.setEnabled(false);
			치유하기_btn.setEnabled(false);
		} else if (evilTeam.isEmpty()) {
			JOptionPane.showMessageDialog(this, "게임 종료: 해리포터 팀 승리!");
			공격하기_btn.setEnabled(false);
			치유하기_btn.setEnabled(false);
		}

		// 다음 턴을 위한 객체 초기화 및 안내선언
		attacker = null;
		target = null;
		selectedWeapon = null;
		statusGuideLabel.setText("★ 턴 종료. 다음 [공격자] 캐릭터 버튼을 클릭하세요!");
	}
	
	private void updateHpBars() {
		for (마법사 w : allWizards) {
			int hp = Math.max(0, w.getHp()); // 음수 방지
			if (w.getName().equals("짱해리포터")) {
				progressBar_haPd.setValue(hp);
				progressBar_haPd.setString("HP: " + hp + " / 1000");
			} else if (w.getName().equals("똒똑헤르미온느")) {
				progressBar_heMi.setValue(hp);
				progressBar_heMi.setString("HP: " + hp + " / 1000");
			} else if (w.getName().equals("무섭볼트모트")) {
				progressBar_vol.setValue(hp);
				progressBar_vol.setString("HP: " + hp + " / 1000");
			} else if (w.getName().equals("강렬벨라트릭스")) {
				progressBar_bel.setValue(hp);
				progressBar_bel.setString("HP: " + hp + " / 1000");
			}
		}
	}
	
	private void disableDeadButton(String name) {
		if (name.equals("짱해리포터")) 해리포터_선택btn.setEnabled(false);
		else if (name.equals("똒똑헤르미온느")) 헤르미온느_선택btn.setEnabled(false);
		else if (name.equals("무섭볼트모트")) 볼드모트_선택btn.setEnabled(false);
		else if (name.equals("강렬벨라트릭스")) 벨라트릭스_선택btn.setEnabled(false);
	}
	
	private void selectWeapon(int idx) {
		if (attacker == null) {
			textArea.append("❌ 공격자를 먼저 선택해야 무기를 장착할 수 있습니다.\n");
			return;
		}
		selectedWeapon = weaponList.get(idx);
		attacker.setWeapon(selectedWeapon);
		textArea.append("⚔️ [무기] 장착: " + selectedWeapon.getName() + "\n");
		statusGuideLabel.setText("★ 이제 [공격 대상] 캐릭터 버튼을 클릭하세요.");
	}
	
	private 마법도구 findWeaponByName(String name) {
		for (마법도구 w : weaponList) {
			if (w.getName().equals(name)) return w;
		}
		return null;
	}
	
	private void printCurrentStatus() {
		textArea.append("\n------ [현재 생존자 상태] ------\n");
		for (int i = 0; i < allWizards.size(); i++) {
			마법사 w = allWizards.get(i);
			// 각 객체의 showStatus()가 원래 콘솔 출력용(System.out)이므로,
			// GUI 창 안쪽 보기를 위해 텍스트 양식을 매칭
			textArea.append("• " + w.getName() + " (HP: " + w.getHp() + ")\n");
		}
		textArea.append("------------------------\n");
	}
	
	private void selectWizard(마법사 wizard) {
		if (wizard == null || wizard.getHp() <= 0) {
			textArea.append("❌ 이미 사망한 캐릭터는 선택할 수 없습니다.\n");
			return;
		}

		// 1단계: 공격자가 결정되지 않았을 때 -> 첫 번째로 누른 캐릭터를 공격자로 세팅
		if (attacker == null) {
			attacker = wizard;
			textArea.append("▶ [공격자] 선택 ➔ " + attacker.getName() + "\n");
			statusGuideLabel.setText("★ 하단에서 [장착할 무기] 버튼을 클릭하세요.");
		} 
		// 2단계: 공격자는 골랐고, 타겟이 비어있을 때 -> 두 번째로 누른 캐릭터를 대상으로 세팅
		else if (target == null) {
			if (attacker == wizard) {
				textArea.append("❌ 자기 자신을 공격 대상으로 지정할 수 없습니다.\n");
				return;
			}
			target = wizard;
			textArea.append("🎯 [대상] 선택 ➔ " + target.getName() + "\n");
			statusGuideLabel.setText("★ 중앙의 [공격하기] 또는 [치유하기] 버튼을 누르세요!");
		} 
		// 3단계: 이미 한 번 고른 상태에서 또 캐릭터를 누르면 초기화하고 다시 첫 단계로
		else {
			attacker = wizard;
			target = null;
			selectedWeapon = null;
			textArea.append("\n🔄 선택 초기화! 새 [공격자] ➔ " + attacker.getName() + "\n");
			statusGuideLabel.setText("★ 하단에서 [장착할 무기] 버튼을 클릭하세요.");
		}
	}
	
	private 마법사 findWizardByName(String name) {
		for (마법사 w : allWizards) {
			if (w.getName().equals(name)) return w;
		}
		return null;
	}
	
	
	
	
	
}
