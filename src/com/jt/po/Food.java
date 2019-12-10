package com.jt.po;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import com.jt.util.Config;

/**
 * 食物类
 * @author xgq
 *
 */
public class Food {
	
	private int row ;//所在的行
	private int col ;//所在的列
	
	public Food() {
		repair();
	}
	
	//随机指定行列
	public void repair() {
			row =new Random().nextInt(Config.ROWS);//0-Config.Rows-1
			col =new Random().nextInt(Config.ROWS);	
	
	}
	
   public void draw(Graphics g) {
	// TODO Auto-generated method stub
	   //设置画笔颜色
	   g.setColor(Color.red);
	   //绘制食物
	   g.fillRect(col*Config.SPAN, row*Config.SPAN, Config.SPAN,Config.SPAN);

  }	
   //获得食物所在的矩形区域Rectangle
   public Rectangle getRect() {
	   return new Rectangle(col*Config.SPAN, row*Config.SPAN,Config.SPAN,Config.SPAN);
	   	   
   }
   
   
   
}
