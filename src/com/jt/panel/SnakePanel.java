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

//��Ϸ���
public class SnakePanel extends JPanel implements KeyListener{

	Food food =new Food();
	Snake snake =new Snake(food);
	SnakeThread SnakeThread=new SnakeThread();//����̰�����ƶ��Ķ���

	Font font=new Font("����",Font.BOLD,30);//�������
	Image bg_game=ImageUtil.getImage("img/bg_game.jpg");
	int speed=400;
	public static Player player = null;
	
	public SnakePanel() {
		//��ʼ�������Ϣ
		initPanel();
		//����ǰ������ü����¼��ļ���
		this.addKeyListener(this);
		
		//�������ƶ����߳�
	
		SnakeThread.start();
//		
	
	}
	//��ʼ�������Ϣ
	private void initPanel() {
		// TODO Auto-generated method stub
		this.setBounds(0,0,700,440);
//		this.setBackground(Color.yellow);
		this.setBackground(Color.yellow);
		
		
	}
	//��дpaint����������������
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		//��������
		
		//���û�����ɫ
//		g.setColor(Color.gray);
		//���ƺ���
//		for(int i=0;i<Config.ROWS;i++) {
//			g.drawLine(0, Config.SPAN*i, Config.COLS*Config.SPAN,Config.SPAN*i);
//		}
		//��������
//		for (int i = 0; i < Config.COLS; i++) {
//			g.drawLine(Config.SPAN*i, 0,Config.SPAN*i,Config.ROWS*Config.SPAN);
//		}
//		���Ʊ���ͼƬ
		g.drawImage(bg_game, 0, 0, this);
		

		//����ʳ��,���û�����ɫ
		food.draw(g);
		
		//�����߻�������ķ�������������
		snake.draw(g);
		
		//���û�����ɫ
		g.setColor(Color.gray);
		
		g.setFont(font);
		//��������
		g.drawString("Score: "+snake.getScore(), 40, 40);

		
	}
	// ����̰���ߵ��߳���
	class SnakeThread extends Thread{

//		private boolean pause = false;
		//�߳���������
		@Override
		public void run() {
			super.run();
			new Thread(()->{
				playM();
			}).start();
			while(Config.isLive) {
				
				
				while(Config.pause) {
					System.out.println("��ͣ");
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
				
				 //�����ƶ��ķ���
			
				snake.move();
				//�ػ�
				repaint();
			}
			
			if(!Config.isLive) {
				
				JOptionPane.showMessageDialog(SnakePanel.this, "��Ϸ����", "��Ϣ", JOptionPane.INFORMATION_MESSAGE);
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
			//����һ��File����
			File mp3 = new File("bgm/DV.mp3");
			
			//����һ��������
			FileInputStream fileInputStream = new FileInputStream(mp3);
			
			//����һ��������
			BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
			
			//�������������󣬰��ļ��Ļ����������ȥ
			player = new Player(bufferedInputStream);
			
			//���ò��ŷ������в���
			player.play();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//�������ͷŵ�ʱ�����
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

		//�����ߵ��ƶ�����
		
		snake.dirControl(arg0);

	}
	
	//���̰��µ�ʱ�����
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	//��������Ч�ַ�ʱ���� �ַ�
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}
