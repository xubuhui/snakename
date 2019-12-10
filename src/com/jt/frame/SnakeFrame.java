package com.jt.frame;

import javax.swing.JFrame;

import com.jt.panel.ButtonPanel;
import com.jt.panel.SnakePanel;
import com.jt.util.Config;

public class SnakeFrame extends BaseFrame{
	
	public SnakePanel snakePanel =new SnakePanel();
	ButtonPanel buttonPanel =new ButtonPanel(this);
	
	//用户创建游戏界面的窗体
	public SnakeFrame() {
		//设置窗体信息
		initFrame();
		//设置关闭窗口时程序终止
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addComponents();
		//设置可见
		this.setVisible(true);
	
		
	}

	public void addComponents() {
		this.add(snakePanel);
		//获取焦点
		snakePanel.setFocusable(true);
		snakePanel.requestFocus();
		this.add(buttonPanel);
		
	}
}
