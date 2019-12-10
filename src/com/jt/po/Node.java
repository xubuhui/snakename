package com.jt.po;

import java.awt.Color;
import java.awt.Graphics;

import com.jt.util.Config;

/**
 * 贪吃蛇分割节点
 * @author xgq
 *
 */

public class Node {
	
	int row;//行
	int col;//列
	String dir;//前进的方向 “u”↑ “d”, "l","r"...
	//下一个节点
	Node next;
	//上一个节点
	Node pre;

	public Node(int row, int col, String dir) {
		super();
		this.row = row;
		this.col = col;
		this.dir = dir;
	}
	//绘制节点
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.blue);
		if(this.pre==null) {
		  g.setColor(Color.green);
		}
		g.fillOval(col*Config.SPAN, row*Config.SPAN, Config.SPAN,  Config.SPAN);
		
		
	}

	

}
