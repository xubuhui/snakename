package com.jt.frame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.jt.panel.LoginPanel;
import com.jt.panel.RegPanel;
import com.jt.util.ImageUtil;

public class RegFrame extends BaseFrame{
	
	RegPanel regPanel =new RegPanel(this);
//	SnakeFrame snakeFrame;
	
	//����޲εĹ��췽�������ڴ������촰��
	public RegFrame() {
		//���ô�����Ϣ�ķ���initFrame����
		initFrame();
		//���ùرմ���ʱ������ֹ
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//���Panel���
//		this.add(loginPanel);
		addComponents();
		
		//���ô�����ʾ��ͨ��������������
		this.setVisible(true);
		
	}
	private void addComponents() {
		// TODO Auto-generated method stub
		this.add(regPanel);
//		snakeFrame.dispose();
	}


}
