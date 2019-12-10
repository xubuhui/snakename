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
 * 游戏排行窗体
 * @author xgq
 *
 */
public class RankFrame extends BaseFrame{
	
	RankPanel rankPanel =new RankPanel();//创建面板实例
 
	
	//创建窗体
	public RankFrame() {
		initFrame();
		//添加组件
		addComponents();
		this.setVisible(true);
		//设置关闭窗口
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {  
			  
			public void windowClosing(WindowEvent e) {  
			super.windowClosing(e);  
			Config.pause=false;
			 }  
			  
			});  
		
	}
	//添加组件
	private void addComponents() {
		// 添加游戏面板
		this.add(rankPanel);
	}

	
}
