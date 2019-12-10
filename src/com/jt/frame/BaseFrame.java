package com.jt.frame;

import javax.swing.JFrame;

import com.jt.util.ImageUtil;

public class BaseFrame extends JFrame{
	//设置窗体信息
	public void initFrame() {
		//设置窗体的显示位置
		this.setBounds(300,50,705,515);
		//设置标题
		this.setTitle("贪吃蛇");
		//设置图标
		this.setIconImage(ImageUtil.getImage("img/logo.png"));
		//设置布局,不使用布局
		this.setLayout(null);
		//设置窗体不可调节大小
		this.setResizable(false);

		
	
	}
	

}
