package com.jt.po;

import java.awt.Color;
import java.awt.Graphics;

import com.jt.util.Config;

/**
 * ̰���߷ָ�ڵ�
 * @author xgq
 *
 */

public class Node {
	
	int row;//��
	int col;//��
	String dir;//ǰ���ķ��� ��u���� ��d��, "l","r"...
	//��һ���ڵ�
	Node next;
	//��һ���ڵ�
	Node pre;

	public Node(int row, int col, String dir) {
		super();
		this.row = row;
		this.col = col;
		this.dir = dir;
	}
	//���ƽڵ�
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.blue);
		if(this.pre==null) {
		  g.setColor(Color.green);
		}
		g.fillOval(col*Config.SPAN, row*Config.SPAN, Config.SPAN,  Config.SPAN);
		
		
	}

	

}
