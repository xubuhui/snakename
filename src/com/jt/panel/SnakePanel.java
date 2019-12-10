package com.jt.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TrayIcon.MessageType;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.jt.po.Food;
import com.jt.po.Snake;
import com.jt.util.Config;
import com.jt.util.ImageUtil;

import javazoom.jl.player.Player;

//游戏面板
public class SnakePanel extends JPanel implements KeyListener{

	Food food =new Food();
	Snake snake =new Snake(food);
	SnakeThread SnakeThread=new SnakeThread();//创建贪吃蛇移动的对象

	Font font=new Font("黑体",Font.BOLD,30);//字体对象
	Image bg_game=ImageUtil.getImage("img/bg_game.jpg");
	int speed=400;
	public static Player player = null;
	
	public SnakePanel() {
		//初始化面板信息
		initPanel();
		//给当前面板设置键盘事件的监听
		this.addKeyListener(this);
		
		//启动蛇移动的线程
	
		SnakeThread.start();
//		
	
	}
	//初始化面板信息
	private void initPanel() {
		// TODO Auto-generated method stub
		this.setBounds(0,0,700,440);
//		this.setBackground(Color.yellow);
		this.setBackground(Color.yellow);
		
		
	}
	//重写paint方法（绘制容器）
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		//绘制网格
		
		//设置画笔颜色
//		g.setColor(Color.gray);
		//绘制横线
//		for(int i=0;i<Config.ROWS;i++) {
//			g.drawLine(0, Config.SPAN*i, Config.COLS*Config.SPAN,Config.SPAN*i);
//		}
		//绘制竖线
//		for (int i = 0; i < Config.COLS; i++) {
//			g.drawLine(Config.SPAN*i, 0,Config.SPAN*i,Config.ROWS*Config.SPAN);
//		}
//		绘制背景图片
		g.drawImage(bg_game, 0, 0, this);
		

		//绘制食物,设置画笔颜色
		food.draw(g);
		
		//调用蛇绘制自身的方法，来绘制蛇
		snake.draw(g);
		
		//设置画笔颜色
		g.setColor(Color.gray);
		
		g.setFont(font);
		//绘制文字
		g.drawString("Score: "+snake.getScore(), 40, 40);

		
	}
	// 创建贪吃蛇的线程类
	class SnakeThread extends Thread{

//		private boolean pause = false;
		//线程做的事情
		@Override
		public void run() {
			super.run();
			new Thread(()->{
				playM();
			}).start();
			while(Config.isLive) {
				
				
				while(Config.pause) {
					System.out.println("暂停");
				}
//				System.out.println(Config.num);
				
				if(Config.num%5==0&&Config.num!=0&&speed>100) {
					Config.num =0;
					speed=speed-100;
					try {
						Thread.sleep(speed);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					try {
						Thread.sleep(speed);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
//				System.out.println("v"+speed);
				setFocusable(true);
				requestFocus();
				
				 //调用移动的方法
			
				snake.move();
				//重绘
				repaint();
			}
			
			if(!Config.isLive) {
				
				JOptionPane.showMessageDialog(SnakePanel.this, "游戏结束", "消息", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	

	}
	
//	class SnakeMusic extends SnakeThread{
//		
//		@Override
//		public void run() {
//			// TODO Auto-generated method stub
//			super.run();
//			playM();
//			
//		}
//	}
	
	public void playM() {
		try {
			//声明一个File对象
			File mp3 = new File("bgm/DV.mp3");
			
			//创建一个输入流
			FileInputStream fileInputStream = new FileInputStream(mp3);
			
			//创建一个缓冲流
			BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
			
			//创建播放器对象，把文件的缓冲流传入进去
			player = new Player(bufferedInputStream);
			
			//调用播放方法进行播放
			player.play();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//当键已释放的时候调用
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

		//控制蛇的移动方向
		
		snake.dirControl(arg0);

	}
	
	//键盘按下的时候调用
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	//当键入有效字符时调用 字符
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}
