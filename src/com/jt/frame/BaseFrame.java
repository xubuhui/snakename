package com.jt.frame;

import javax.swing.JFrame;

import com.jt.util.ImageUtil;

public class BaseFrame extends JFrame{
	//���ô�����Ϣ
	public void initFrame() {
		//���ô������ʾλ��
		this.setBounds(300,50,705,515);
		//���ñ���
		this.setTitle("̰����");
		//����ͼ��
		this.setIconImage(ImageUtil.getImage("img/logo.png"));
		//���ò���,��ʹ�ò���
		this.setLayout(null);
		//���ô��岻�ɵ��ڴ�С
		this.setResizable(false);

		
	
	}
	

}
