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
	
	//添加无参的构造方法，用于创建构造窗体
	public LoginFrame() {
		//调用窗体信息的方法initFrame（）
		initFrame();
		//设置关闭窗口时程序终止
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//添加Panel组件
//		this.add(loginPanel);
		addComponents();
		
		//设置窗体显示，通常在最后进行设置
		this.setVisible(true);
		
	}
	private void addComponents() {
		// TODO Auto-generated method stub
		this.add(loginPanel);
//		snakeFrame.dispose();
	}


	//程序的入口
	public static void main(String[] args) {
		
		new LoginFrame();
		
	}
}
