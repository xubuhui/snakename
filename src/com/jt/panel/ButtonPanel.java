package com.jt.panel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	SnakeFrame snakeFrame;
//	public boolean pause = false;
	
	
	
	public ButtonPanel(SnakeFrame snakeFrame) {
		this.snakeFrame =snakeFrame;
		//��ʼ�������Ϣ
		initPanel();
		//��ʼ�������Ϣ
		initComponents();
		//�������
		addComponents();
	}

	private void addComponents() {
		// TODO Auto-generated method stub
		this.add(btn_pause);
		this.add(btn_continue);
		this.add(btn_restart);
		this.add(btn_rank);
		
	}
	private void initComponents() {
		// TODO Auto-generated method stub
		btn_pause =new JButton("��ͣ��Ϸ");
		btn_continue =new JButton("������Ϸ");
		btn_restart =new JButton("���¿�ʼ");
		btn_rank =new JButton("��Ϸ����");
		
		
		//����ť���õ�������
		btn_pause.addActionListener(this);
		btn_continue.addActionListener(this);
		btn_restart.addActionListener(this);
		btn_rank.addActionListener(this);
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
		
	}
	
	//��Ϸ����
	private void gameRank() {
		// TODO Auto-generated method stub
		
		//��ͣ��Ϸ
		gamePause();
		
		//�����д���
		new RankFrame();
		
		
		
	}
//	���¿�ʼ
	private void gameResTart() {
		// TODO Auto-generated method stub
		
	
		Config.isLive=true;
//		Config.re=true;
		snakeFrame.setVisible(false);
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