package com.jt.frame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import com.jt.panel.RankPanel;
//import com.jt.panel.WindowAdapter;
//import com.jt.panel.WindowEvent;
import com.jt.util.Config;

/**
 * ��Ϸ���д���
 * @author xgq
 *
 */
public class RankFrame extends BaseFrame{
	
	RankPanel rankPanel =new RankPanel();//�������ʵ��
 
	
	//��������
	public RankFrame() {
		initFrame();
		//������
		addComponents();
		this.setVisible(true);
		//���ùرմ���
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {  
			  
			public void windowClosing(WindowEvent e) {  
			super.windowClosing(e);  
			Config.pause=false;
			 }  
			  
			});  
		
	}
	//������
	private void addComponents() {
		// �����Ϸ���
		this.add(rankPanel);
	}

	
}
