package com.jt.frame;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.jt.panel.LoginPanel;
import com.jt.util.ImageUtil;

import javazoom.jl.player.Player;

public class LoginFrame extends BaseFrame{
	
	LoginPanel loginPanel =new LoginPanel(this);

//	SnakeFrame snakeFrame;
	
	//����޲εĹ��췽�������ڴ������촰��
	public LoginFrame() {
		//���ô�����Ϣ�ķ���initFrame����
		initFrame();
		//���ùرմ���ʱ������ֹ
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//���Panel���
//		this.add(loginPanel);
		addComponents();
		
		//���ô�����ʾ��ͨ��������������
		this.setVisible(true);
		
	}
	private void addComponents() {
		// TODO Auto-generated method stub
		this.add(loginPanel);
//		snakeFrame.dispose();
	}


	//��������
	public static void main(String[] args) {
		
		new LoginFrame();
		
	}
}
