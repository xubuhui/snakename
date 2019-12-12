package com.jt.po;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

import com.jt.dao.UserDao;
import com.jt.util.Config;

public class Snake {
	
	//蛇头
	Node head;
	
	//蛇身
	Node body;
	//蛇尾
	Node tail;
	Food food;//当前食物
	int score=0;
	Boolean a =false;


	//用于创建贪吃蛇对象
	public Snake(Food food) {
		this.food=food;//给食物属性赋值
		//实例化
		head =new Node(7,13,Config.R);
		body =new Node(7,12,Config.R);
		tail =new Node(7,11,Config.R);
		
		//设置节点间的关系
		head.next=body;
		body.pre=head;
		body.next=tail;
		tail.pre=body;
		
		
	}
//	//绘制蛇的方法
//	public void draw(Graphics g, int i) {
//		// TODO Auto-generated method stub
//		
//		
//	}
	//绘制蛇的方法--》绘制蛇的每一个节点
	public void draw(Graphics g) {
		//得到蛇的每一个节点
		for(Node node=head;node!=null;node=node.next) {
//			得到每一个节点
			node.draw(g);
			a=true;
		}
		
	}
	public void move() {
		//1.添加头节点2.判断是否吃到食物3.如果吃到食物，则移除尾节点4.判断蛇是否死亡
		//1.添加蛇头
		
	    addHead();
	    
 
		if(!isEat()) {
			//移除尾节点
			removeTail();
		}
		checkDeath();	
		
	}
	
	//判断蛇是否死亡
	private void checkDeath() {
		// TODO Auto-generated method stub
		//越界
		if(head.row<0||head.row>Config.ROWS-1||head.col<0||head.col>Config.COLS-1) {
			//越界死亡
			Config.isLive =false;
			
		}
		//蛇身的节点和任意节点重合（蛇头的行与任意节点的行一致同时舌头的列与此节点的列一致）
		//遍历得到蛇头以外的所有节点，一旦某一个节点的行列与蛇头的行列一致，则蛇死亡
		for(Node n =head.next;n!=null;n=n.next) {
			
			if(n.row==head.row && n.col ==head.col) {
				Config.isLive=false;
			}
		}
		
		//如果死亡 ，保存成绩到数据库
		if(Config.isLive==false) {
			int rs =UserDao.insertData(score, Config.user.getId());
			if(rs>0) {
				System.out.println("成功");
			}
		}
		
		
	}
	private void removeTail() {
		// TODO Auto-generated method stub
		tail.pre.next=null;//设置真尾节点
		tail =tail.pre;//设置尾节点为原节点的上一个节点
		
	}
	public Rectangle getRect() {
		return new Rectangle(head.col*Config.SPAN, head.row*Config.SPAN, Config.SPAN, Config.SPAN);
	}
	//判断是否吃到食物 true 吃到 false 未吃到
	public boolean isEat() {
	
		//获得蛇头所在的矩形区域
		
		//获得食物所在的矩形区域
		
		//判断这两个所在的矩形区域，如果交叉代表吃到，否则未吃到
		if(getRect().intersects(food.getRect())) {
			//吃到了
			food.repair();
			//记分
			score++;
			Config.num++;
			return true;
		}
		
		return false;

	}

	public int getScore() {
		return score;
	}

	
	//添加蛇头
	private void addHead() {
		//创建新节点
		Node node=null;
		//根据蛇头前进的方向不同，创建新节点。
		switch(head.dir) {
		case Config.U:
			//蛇头前进的方向为上》头结点的行为1列

			node = new Node(head.row-1, head.col, head.dir);
			break;
		case Config.D:
			//蛇头前进的方向为下
	
			node = new Node(head.row+1, head.col, head.dir);
	
			break;
		case Config.L:
			//蛇头前进的方向为左
		
			node = new Node(head.row, head.col-1, head.dir);
		
			break;	
		case Config.R:
			//蛇头前进的方向为右
			
			node = new Node(head.row, head.col+1, head.dir);
	
			break;
		default:
			break;
			
		
		}
		//设置新节点与原节点的关系
		node.next=head;
		head.pre=node;
		//设置新节点为蛇头
		head =node;
		
		
	
		
	}
//	控制蛇的移动方向 -》蛇头
	public void dirControl(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(a) {
	    	switch (arg0.getKeyCode()) {
			case KeyEvent.VK_UP:
				//按上键 将蛇头前进的方向设置为上(前进方向不为下 防止蛇自撞)
				if(!head.dir.equals(Config.D)) {
					//设置蛇头前进方向 上↑
					head.dir =Config.U;	

//					System.out.println("上");
				}
				break;
			case KeyEvent.VK_DOWN:
			
				if(!head.dir.equals(Config.U)) {
					head.dir =Config.D;	
			
//					System.out.println("下");
				}
				
				break;
			case KeyEvent.VK_LEFT:
				
				if(!head.dir.equals(Config.R)) {
					head.dir =Config.L;

//					System.out.println("左");
					
				}
				
				
				break;
			case KeyEvent.VK_RIGHT:
				if(!head.dir.equals(Config.L)) {
					head.dir =Config.R;	

//					System.out.println("右");
				}
				
				break;

			default:
				break;
	    }
	    	  a=false;	
		}
		
		
	}
	
	

}
