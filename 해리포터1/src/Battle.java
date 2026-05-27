import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;

import 마법도구.*;
import 마법사.*;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
	private JLabel 볼드모트Img;
	private JButton 볼드모트_선택btn;
	private JLabel 벨라트릭스Img;
	private JButton 벨라트릭스_선택btn;
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

	private 해리포터 haPd = new 해리포터("짱해리포터", 1000, 100);
	private 헤르미온느 heMi = new 헤르미온느("똒똑헤르미온느", 1000, 100);
	private 볼드모트 vol = new 볼드모트("무섭볼트모트", 1000, 100);
	private 벨라트릭스 bel = new 벨라트릭스("강렬벨라트릭스", 1000, 100);

	private 지팡이 cane = new 지팡이("지팡이");
	private 투명망토 cape = new 투명망토("투명망토");
	private 그리핀도르의칼 sword = new 그리핀도르의칼("그리핀도르의칼");
	private 물약 medicine = new 물약("물약");

	private 마법사 attacker = null;
	private 마법사 target = null;
	private 마법도구 selectedWeapon = null;
	private boolean isWeaponSelected = false;
	private boolean isHealingMode = false;

	private JLabel statusGuideLabel;

	public Battle() {
		this.allWizards = new ArrayList<>();
		this.allWizards.add(this.haPd);
		this.allWizards.add(this.heMi);
		this.allWizards.add(this.vol);
		this.allWizards.add(this.bel);

		this.goodTeam = new ArrayList<>();
		this.goodTeam.add(this.haPd);
		this.goodTeam.add(this.heMi);

		this.evilTeam = new ArrayList<>();
		this.evilTeam.add(this.vol);
		this.evilTeam.add(this.bel);

		this.weaponList = new ArrayList<>();
		this.weaponList.add(this.cane);
		this.weaponList.add(this.sword);
		this.weaponList.add(this.cape);
		this.weaponList.add(this.medicine);

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
				setActionMode(false); // 공격 실행
			}
		});
		공격하기_btn.setBounds(277, 330, 109, 23);
		contentPane.add(공격하기_btn);

		치유하기_btn = new JButton("치유하기");
		치유하기_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setActionMode(true); // 치유 실행
			}
		});
		치유하기_btn.setBounds(409, 330, 109, 23);
		contentPane.add(치유하기_btn);

		panel = new JPanel();
		panel.setBounds(10, 10, 245, 164);
		contentPane.add(panel);
		panel.setLayout(null);

		해리포터_선택btn = new JButton("해리포터");
		해리포터_선택btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectWizard(haPd);
			}
		});
		해리포터_선택btn.setBounds(142, 28, 93, 23);
		panel.add(해리포터_선택btn);

		해리포터Img = new JLabel("");
		해리포터Img.setBounds(11, 10, 121, 117);
		panel.add(해리포터Img);		
		ImageIcon a1 = new ImageIcon(Battle.class.getResource("/images/해리포터.jpg"));
		Image b1 = a1.getImage().getScaledInstance(121,  117, Image.SCALE_SMOOTH);
		ImageIcon c1 = new ImageIcon(b1);		
		해리포터Img.setIcon(c1);		

		progressBar_haPd = new JProgressBar();
		progressBar_haPd.setBounds(11, 137, 226, 14);
		panel.add(progressBar_haPd);
		progressBar_haPd.setMaximum(1000);
		progressBar_haPd.setValue(1000);
		progressBar_haPd.setStringPainted(true);
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
		ImageIcon a2 = new ImageIcon(Battle.class.getResource("/images/헤르미온느.jpg"));
		Image b2 = a2.getImage().getScaledInstance(121,  117, Image.SCALE_SMOOTH);
		ImageIcon c2 = new ImageIcon(b2);		
		헤르미온느Img.setIcon(c2);		

		헤르미온느_선택btn = new JButton("헤르미온느");
		헤르미온느_선택btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectWizard(heMi);
			}
		});
		헤르미온느_선택btn.setBounds(141, 31, 93, 23);
		panel_1.add(헤르미온느_선택btn);

		progressBar_heMi = new JProgressBar();
		progressBar_heMi.setBounds(10, 140, 226, 14);
		panel_1.add(progressBar_heMi);
		progressBar_heMi.setMaximum(1000);
		progressBar_heMi.setValue(1000);
		progressBar_heMi.setStringPainted(true);
		progressBar_heMi.setForeground(Color.RED);
		

		panel_2 = new JPanel();
		panel_2.setBounds(535, 10, 253, 164);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		볼드모트Img = new JLabel("");
		볼드모트Img.setBounds(10, 10, 121, 117);
		panel_2.add(볼드모트Img);
		ImageIcon a3 = new ImageIcon(Battle.class.getResource("/images/볼드모트.jpg"));
		Image b3 = a3.getImage().getScaledInstance(121,  117, Image.SCALE_SMOOTH);
		ImageIcon c3 = new ImageIcon(b3);		
		볼드모트Img.setIcon(c3);		

		볼드모트_선택btn = new JButton("볼드모트");
		볼드모트_선택btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectWizard(vol);
			}
		});
		볼드모트_선택btn.setBounds(143, 31, 93, 23);
		panel_2.add(볼드모트_선택btn);

		progressBar_vol = new JProgressBar();
		progressBar_vol.setBounds(10, 140, 226, 14);
		panel_2.add(progressBar_vol);
		progressBar_vol.setMaximum(1000);
		progressBar_vol.setValue(1000);
		progressBar_vol.setStringPainted(true);
		progressBar_vol.setForeground(Color.RED);

		panel_3 = new JPanel();
		panel_3.setBounds(535, 184, 253, 164);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		벨라트릭스Img = new JLabel("");
		벨라트릭스Img.setBounds(10, 10, 121, 117);
		panel_3.add(벨라트릭스Img);
		ImageIcon a4 = new ImageIcon(Battle.class.getResource("/images/벨라트릭스.jpg"));
		Image b4 = a4.getImage().getScaledInstance(121,  117, Image.SCALE_SMOOTH);
		ImageIcon c4 = new ImageIcon(b4);		
		벨라트릭스Img.setIcon(c4);		

		벨라트릭스_선택btn = new JButton("벨라트릭스");
		벨라트릭스_선택btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectWizard(bel);
			}
		});
		벨라트릭스_선택btn.setBounds(141, 30, 93, 23);
		panel_3.add(벨라트릭스_선택btn);

		progressBar_bel = new JProgressBar();
		progressBar_bel.setBounds(8, 137, 226, 14);
		panel_3.add(progressBar_bel);
		progressBar_bel.setMaximum(1000);
		progressBar_bel.setValue(1000);
		progressBar_bel.setStringPainted(true);
		progressBar_bel.setForeground(Color.RED);

		btnNewButton = new JButton("지팡이");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectWeapon(0);
			}
		});
		btnNewButton.setBounds(10, 383, 102, 95);
		contentPane.add(btnNewButton);

		btnNewButton_1 = new JButton("그리핀도르의칼");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectWeapon(1);
			}
		});
		btnNewButton_1.setBounds(178, 383, 102, 95);
		contentPane.add(btnNewButton_1);

		btnNewButton_2 = new JButton("투명망토");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectWeapon(2);
			}
		});
		btnNewButton_2.setBounds(350, 383, 102, 95);
		contentPane.add(btnNewButton_2);

		btnNewButton_3 = new JButton("물약");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectWeapon(3);
			}
		});
		btnNewButton_3.setBounds(535, 383, 102, 95);
		contentPane.add(btnNewButton_3);

		btnx = new JButton("무기X");
		btnx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (attacker == null) {
					textArea.append("❌ 공격자를 먼저 선택해야 합니다.\n");
					return;
				}
				selectedWeapon = null;
				attacker.setWeapon(null);
				isWeaponSelected = true;
				textArea.append("🛡️ [무기] 맨손 상태로 설정되었습니다.\n");
				statusGuideLabel.setText("★ 이제 [공격 대상] 캐릭터 버튼을 클릭하세요.");
			}
		});
		btnx.setBounds(686, 383, 102, 95);
		contentPane.add(btnx);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(278, 12, 239, 308);
		contentPane.add(scrollPane);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		공격하기_btn.setEnabled(false);
	    치유하기_btn.setEnabled(false);
	    setWeaponButtonsEnabled(false);

		textArea.append("=======<해리포터 게임!>=======\n");
		printCurrentStatus(); 
		updateHpBars();
	}

	//공격 혹은 치유를 결정하는 유효성 체크 메소드
	private void setActionMode(boolean healing) {
		if (attacker == null) {
			JOptionPane.showMessageDialog(this, "캐릭터(공격자)를 먼저 선택해 주세요!");
			return;
		}

		if (healing) {
			if (attacker instanceof 헤르미온느 || attacker instanceof 벨라트릭스) {
				isHealingMode = true;
				
				selectedWeapon = findWeaponByName("물약");
	            attacker.setWeapon(selectedWeapon);
	            isWeaponSelected = true;
				
				textArea.append("💚 [행동 선택] 치유하기 모드 ➔ 자동으로 " + selectedWeapon.getName() + " 장착 완료!\n");
				statusGuideLabel.setText("★ 치유할 [아군 캐릭터] 버튼을 클릭하세요.");
				setWeaponButtonsEnabled(false);
			} else {
				JOptionPane.showMessageDialog(this, attacker.getName() + "는 치유할 수 없습니다.");
			} 
		}else {
			isHealingMode = false;
			isWeaponSelected = false;
			selectedWeapon = null;
			
			textArea.append("⚔️ [행동 선택] 공격하기 모드로 전환되었습니다.\n");
			statusGuideLabel.setText("★ 하단에서 [장착할 무기] 버튼을 클릭하세요.");
			
			setWeaponButtonsEnabled(true);
		}
		공격하기_btn.setEnabled(false);
	    치유하기_btn.setEnabled(false);	
	}


	private void executeAction(boolean isHealingMode) {
		if (attacker == null || target == null) {
			JOptionPane.showMessageDialog(this, "공격자와 대상을 모두 선택해야 합니다!");
			return;
		}

		textArea.append("[실행] 공격자: " + attacker.getName() + " ➔ 대상: " + target.getName() + "\n");

		if (isHealingMode) {
			if (attacker instanceof 헤르미온느) {
				((헤르미온느) attacker).치료하기(target, findWeaponByName("물약"));
				textArea.append("💚 헤르미온느가 " + target.getName() + "을 치유했습니다.\n");
			} else if (attacker instanceof 벨라트릭스) {
				((벨라트릭스) attacker).치료하기(target, findWeaponByName("물약"));
				textArea.append("💚 벨라트릭스가 " + target.getName() + "을 치유했습니다.\n");
			}
		} else {
			Random r = new Random();
			int m = r.nextInt(4);
			if (m == 0) {
				target.setWeapon(new 투명망토("투명망토"));
				textArea.append("[이벤트] " + target.getName() + "이/가 투명망토를 두릅니다!\n");
			}

			int lucky = r.nextInt(8);
			if (lucky == 7) {
				textArea.append("💥💥 럭키 공격 7배 발동!! 💥💥\n");
				if (attacker.getWeapon() == null) attacker.럭키공격(target);
				else attacker.럭키공격(target, attacker.getWeapon());
			} else {
				if (attacker.getWeapon() == null) attacker.공격하기(target);
				else {
			        // ⭐ GUI textArea에 물약/망토 경고 로그를 미리 찍어주기
			        if (attacker.getWeapon() instanceof 물약) {
			            textArea.append("🧪 [경고] 물약으로는 공격할 수 없습니다!\n");
			        } else if (attacker.getWeapon() instanceof 투명망토) {
			            textArea.append("🛡️ [경고] 투명망토로는 공격할 수 없습니다!\n");
			        }
			        attacker.공격하기(target, attacker.getWeapon());
			    }
			}

			textArea.append("⚔️ " + attacker.getName() + " ➔ " + target.getName() + " 공격 완료!\n");
		}

		updateHpBars();

		if (target.getHp() <= 0) {
			textArea.append("☠️ " + target.getName() + "이(가) 쓰러졌습니다.\n");
			goodTeam.remove(target);
			evilTeam.remove(target);
			allWizards.remove(target);
			disableDeadButton(target.getName());
		}

		if (goodTeam.isEmpty()) {
			JOptionPane.showMessageDialog(this, "======= 게임 종료: 볼드모트 팀 승리! =======");
			disableAllGameButtons();
			return;
		} else if (evilTeam.isEmpty()) {
			JOptionPane.showMessageDialog(this, "======= 게임 종료: 해리포터 팀 승리! =======");
			disableAllGameButtons();
			return;
		}

		attacker = null;
		target = null;
		selectedWeapon = null;
		isWeaponSelected = false;
		isHealingMode = false;
		
		공격하기_btn.setEnabled(false);
	    치유하기_btn.setEnabled(false);
	    setWeaponButtonsEnabled(false);
		
		textArea.append("\n------------------------\n");
		statusGuideLabel.setText("★ 턴 종료. 다음 [공격자] 캐릭터 버튼을 클릭하세요!");
	}

	private void updateHpBars() {
		for (마법사 w : allWizards) {
			int hp = Math.max(0, w.getHp()); 
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
		if (weaponList == null || idx >= weaponList.size()) {
			textArea.append("❌ 해당 무기가 존재하지 않습니다.\n");
			return;
		}
		selectedWeapon = weaponList.get(idx);
		attacker.setWeapon(selectedWeapon);
		isWeaponSelected = true;
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
			textArea.append("• " + w.getName() + " (HP: " + w.getHp() + ")\n");
		}
		textArea.append("------------------------\n");
	}

	private void selectWizard(마법사 wizard) {
		if (wizard == null || wizard.getHp() <= 0) {
			textArea.append("❌ 이미 사망한 캐릭터는 선택할 수 없습니다.\n");
			return;
		}

		// 1단계: 공격자 선택
		if (attacker == null) {
			attacker = wizard;
			textArea.append("▶ [공격자] 선택 ➔ " + attacker.getName() + "\n");
			
			if (attacker instanceof 헤르미온느 || attacker instanceof 벨라트릭스) {
	            공격하기_btn.setEnabled(true);
	            치유하기_btn.setEnabled(true);
	            statusGuideLabel.setText("★ 수행할 행동 [공격하기] 또는 [치유하기] 버튼을 누르세요!");
	        } else {
	            공격하기_btn.setEnabled(true);
	            치유하기_btn.setEnabled(false); // 해리포터, 볼드모트는 치유 불가
	            statusGuideLabel.setText("★ [공격하기] 버튼을 누르세요!");
	        }
	        
	        // 공격자를 고른 직후엔 아직 무기나 타겟을 고를 수 없게 방어
	        setWeaponButtonsEnabled(false);
		
		} 
		// 2단계: target 선택
		else if (target == null) {
			// ⭐ 무기 선택 유효성 검사 (아직 무기를 안 골랐다면 진행 차단)

			if (isHealingMode) {
				// 치유 모드: 같은 팀만 치유 가능 (해리포터팀끼리, 볼드모트팀끼리)
				boolean isAttackerGood = goodTeam.contains(attacker);
				boolean isTargetGood = goodTeam.contains(wizard);

				if (isAttackerGood != isTargetGood) {
					textArea.append("❌ 치유하기는 아군(같은 팀)에게만 사용할 수 있습니다!\n");
					JOptionPane.showMessageDialog(this, "적 팀을 치유할 수 없습니다!");
					return;
				}
			} else {
				// 공격 모드: 무기 선택 여부 선행 확인
				if (!isWeaponSelected) {
					textArea.append("❌ 무기를 고르지 않았습니다! 하단 무기 버튼(혹은 무기X)을 선택하세요.\n");
					JOptionPane.showMessageDialog(this, "무기를 선택하세요!");
					return;
				}

				// 공격 모드: 같은 팀 공격 불가 체크
				boolean isAttackerGood = goodTeam.contains(attacker);
				boolean isTargetGood = goodTeam.contains(wizard);

				if (isAttackerGood == isTargetGood) {
					textArea.append("❌ 아군을 공격할 수 없습니다! 다른 대상을 선택하세요.\n");
					JOptionPane.showMessageDialog(this, "적 팀 캐릭터를 선택해야 합니다.");
					return;
				}
			}
			target = wizard;
			executeAction(isHealingMode);
		} 
		// 3단계: 초기화 후 재지정
		else {
			attacker = wizard;
			target = null;
			selectedWeapon = null;
			isWeaponSelected = false;
			isHealingMode = false;
			공격하기_btn.setEnabled(true);
	        치유하기_btn.setEnabled(attacker instanceof 헤르미온느 || attacker instanceof 벨라트릭스);
	        setWeaponButtonsEnabled(false);
			textArea.append("\n🔄 선택 초기화! 새 [공격자] ➔ " + attacker.getName() + "\n");
		}
	}

	private 마법사 findWizardByName(String name) {
		for (마법사 w : allWizards) {
			if (w.getName().equals(name)) return w;
		}
		return null;
	}

	private void disableAllGameButtons() {
		공격하기_btn.setEnabled(false);
		치유하기_btn.setEnabled(false);
		해리포터_선택btn.setEnabled(false);
		헤르미온느_선택btn.setEnabled(false);
		볼드모트_선택btn.setEnabled(false);
		벨라트릭스_선택btn.setEnabled(false);
	}
	
	private void setWeaponButtonsEnabled(boolean enabled) {
	    btnNewButton.setEnabled(enabled);   // 지팡이
	    btnNewButton_1.setEnabled(enabled); // 그리핀도르의칼
	    btnNewButton_2.setEnabled(enabled); // 투명망토
	    btnNewButton_3.setEnabled(enabled); // 물약
	    btnx.setEnabled(enabled);           // 무기X
	}
}