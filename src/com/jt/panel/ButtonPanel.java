package com.jt.panel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.jt.frame.RankFrame;
import com.jt.frame.SnakeFrame;
import com.jt.util.Config;

//游戏面板
public class ButtonPanel extends JPanel implements ActionListener{
	JButton btn_pause;//暂停按钮
	JButton btn_continue;//继续按钮
	JButton btn_restart;//重新开始按钮
	JButton btn_rank;//排行按钮
	JButton btn_admin;//后台
	SnakeFrame snakeFrame;
//	public boolean pause = false;
	
	public ButtonPanel(SnakeFrame snakeFrame) {
		this.snakeFrame =snakeFrame;
		//初始化面板信息
		initPanel();
		//初始化组件信息
		initComponents();
		//添加组件
		addComponents();
	}

	private void addComponents() {
		// TODO Auto-generated method stub
		this.add(btn_pause);
		this.add(btn_continue);
		this.add(btn_restart);
		this.add(btn_rank);
		if(Config.user.getUsername().equals("root")) {
			this.add(btn_admin);
		}
	
		
	}
	private void initComponents() {
		// TODO Auto-generated method stub
		btn_pause =new JButton("暂停游戏");
		btn_continue =new JButton("继续游戏");
		btn_restart =new JButton("重新开始");
		btn_rank =new JButton("游戏排行");
		btn_admin =new JButton("后台管理");
		
		
		//给按钮设置单击监听
		btn_pause.addActionListener(this);
		btn_continue.addActionListener(this);
		btn_restart.addActionListener(this);
		btn_rank.addActionListener(this);
		btn_admin.addActionListener(this);
	}
	//初始化面板信息
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
		if(e.getSource()==btn_admin) {
			gameAdmin();
		}
		
	}
	
	private void gameAdmin() {
		// TODO Auto-generated method stub
		gamePause();
		snakeFrame.snakePanel.player.close();
		 try {
				Runtime.getRuntime().exec(
						 "cmd   /c   start   http://localhost/snakegame/welcome.html ");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
	}

	//游戏排行
	private void gameRank() {
		// TODO Auto-generated method stub
		
		//暂停游戏
		gamePause();
		snakeFrame.setVisible(false);
		//打开排行窗口
		new RankFrame(snakeFrame);
		
		
		
	}
//	重新开始
	private void gameResTart() {
		// TODO Auto-generated method stub
		
	
		Config.isLive=true;
//		Config.re=true;
		snakeFrame.setVisible(false);
		snakeFrame.snakePanel.player.close();
		snakeFrame.snakePanel.SnakeThread.stop();
		
		new SnakeFrame();
		
		
	}
	//继续游戏
	private void gameContinue() {
		// TODO Auto-generated method stub
		
		Config.pause = false;
		
	}
	//暂停游戏
	private void gamePause() {
		// TODO Auto-generated method stub

		Config.pause = true;
			
		
	}
}
