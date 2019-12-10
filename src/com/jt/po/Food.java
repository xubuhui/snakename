package com.jt.po;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import com.jt.util.Config;

/**
 * ʳ����
 * @author xgq
 *
 */
public class Food {
	
	private int row ;//���ڵ���
	private int col ;//���ڵ���
	
	public Food() {
		repair();
	}
	
	//���ָ������
	public void repair() {
			row =new Random().nextInt(Config.ROWS);//0-Config.Rows-1
			col =new Random().nextInt(Config.ROWS);	
	
	}
	
   public void draw(Graphics g) {
	// TODO Auto-generated method stub
	   //���û�����ɫ
	   g.setColor(Color.red);
	   //����ʳ��
	   g.fillRect(col*Config.SPAN, row*Config.SPAN, Config.SPAN,Config.SPAN);

  }	
   //���ʳ�����ڵľ�������Rectangle
   public Rectangle getRect() {
	   return new Rectangle(col*Config.SPAN, row*Config.SPAN,Config.SPAN,Config.SPAN);
	   	   
   }
   
   
   
}
