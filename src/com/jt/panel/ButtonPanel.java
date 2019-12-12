package com.jt.panel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.jt.frame.RankFrame;
import com.jt.frame.SnakeFrame;
import com.jt.util.Config;

//��Ϸ���
public class ButtonPanel extends JPanel implements ActionListener{
	JButton btn_pause;//��ͣ��ť
	JButton btn_continue;//������ť
	JButton btn_restart;//���¿�ʼ��ť
	JButton btn_rank;//���а�ť
	JButton btn_admin;//��̨
	SnakeFrame snakeFrame;
//	public boolean pause = false;
	
	public ButtonPanel(SnakeFrame snakeFrame) {
		this.snakeFrame =snakeFrame;
		//��ʼ�������Ϣ
		initPanel();
		//��ʼ�������Ϣ
		initComponents();
		//������
		addComponents();
	}

	private void addComponents() {
		// TODO Auto-generated method stub
		this.add(btn_pause);
		this.add(btn_continue);
		this.add(btn_restart);
		this.add(btn_rank);
		if(Config.user.getUsername().equals("root")) {
			this.add(btn_admin);
		}
	
		
	}
	private void initComponents() {
		// TODO Auto-generated method stub
		btn_pause =new JButton("��ͣ��Ϸ");
		btn_continue =new JButton("������Ϸ");
		btn_restart =new JButton("���¿�ʼ");
		btn_rank =new JButton("��Ϸ����");
		btn_admin =new JButton("��̨����");
		
		
		//����ť���õ�������
		btn_pause.addActionListener(this);
		btn_continue.addActionListener(this);
		btn_restart.addActionListener(this);
		btn_rank.addActionListener(this);
		btn_admin.addActionListener(this);
	}
	//��ʼ�������Ϣ
	private void initPanel() {
		// TODO Auto-generated method stub
		this.setBounds(0,440,700,50);

		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btn_pause) {
		
			gamePause();
		}
		if(e.getSource()==btn_continue) {
			gameContinue();
		}
		if(e.getSource()==btn_restart) {
			gameResTart();
		}
		if(e.getSource()==btn_rank) {
			gameRank();
		}
		if(e.getSource()==btn_admin) {
			gameAdmin();
		}
		
	}
	
	private void gameAdmin() {
		// TODO Auto-generated method stub
		gamePause();
		snakeFrame.snakePanel.player.close();
		 try {
				Runtime.getRuntime().exec(
						 "cmd   /c   start   http://localhost/snakegame/welcome.html ");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
	}

	//��Ϸ����
	private void gameRank() {
		// TODO Auto-generated method stub
		
		//��ͣ��Ϸ
		gamePause();
		snakeFrame.setVisible(false);
		//�����д���
		new RankFrame(snakeFrame);
		
		
		
	}
//	���¿�ʼ
	private void gameResTart() {
		// TODO Auto-generated method stub
		
	
		Config.isLive=true;
//		Config.re=true;
		snakeFrame.setVisible(false);
		snakeFrame.snakePanel.player.close();
		snakeFrame.snakePanel.SnakeThread.stop();
		
		new SnakeFrame();
		
		
	}
	//������Ϸ
	private void gameContinue() {
		// TODO Auto-generated method stub
		
		Config.pause = false;
		
	}
	//��ͣ��Ϸ
	private void gamePause() {
		// TODO Auto-generated method stub

		Config.pause = true;
			
		
	}
}
