package com.jt.frame;

import javax.swing.JFrame;

import com.jt.panel.ButtonPanel;
import com.jt.panel.SnakePanel;
import com.jt.util.Config;

public class SnakeFrame extends BaseFrame{
	
	public SnakePanel snakePanel =new SnakePanel();
	ButtonPanel buttonPanel =new ButtonPanel(this);
	
	//�û�������Ϸ����Ĵ���
	public SnakeFrame() {
		//���ô�����Ϣ
		initFrame();
		//���ùرմ���ʱ������ֹ
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addComponents();
		//���ÿɼ�
		this.setVisible(true);
	
		
	}

	public void addComponents() {
		this.add(snakePanel);
		//��ȡ����
		snakePanel.setFocusable(true);
		snakePanel.requestFocus();
		this.add(buttonPanel);
		
	}
}
