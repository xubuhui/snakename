package com.jt.po;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

import com.jt.dao.UserDao;
import com.jt.util.Config;

public class Snake {
	
	//��ͷ
	Node head;
	
	//����
	Node body;
	//��β
	Node tail;
	Food food;//��ǰʳ��
	int score=0;
	Boolean a =false;


	//���ڴ���̰���߶���
	public Snake(Food food) {
		this.food=food;//��ʳ�����Ը�ֵ
		//ʵ����
		head =new Node(7,13,Config.R);
		body =new Node(7,12,Config.R);
		tail =new Node(7,11,Config.R);
		
		//���ýڵ��Ĺ�ϵ
		head.next=body;
		body.pre=head;
		body.next=tail;
		tail.pre=body;
		
		
	}
//	//�����ߵķ���
//	public void draw(Graphics g, int i) {
//		// TODO Auto-generated method stub
//		
//		
//	}
	//�����ߵķ���--�������ߵ�ÿһ���ڵ�
	public void draw(Graphics g) {
		//�õ��ߵ�ÿһ���ڵ�
		for(Node node=head;node!=null;node=node.next) {
//			�õ�ÿһ���ڵ�
			node.draw(g);
			a=true;
		}
		
	}
	public void move() {
		//1.���ͷ�ڵ�2.�ж��Ƿ�Ե�ʳ��3.����Ե�ʳ����Ƴ�β�ڵ�4.�ж����Ƿ�����
		//1.�����ͷ
		
	    addHead();
	    
 
		if(!isEat()) {
			//�Ƴ�β�ڵ�
			removeTail();
		}
		checkDeath();	
		
	}
	
	//�ж����Ƿ�����
	private void checkDeath() {
		// TODO Auto-generated method stub
		//Խ��
		if(head.row<0||head.row>Config.ROWS-1||head.col<0||head.col>Config.COLS-1) {
			//Խ������
			Config.isLive =false;
			
		}
		//����Ľڵ������ڵ��غϣ���ͷ����������ڵ����һ��ͬʱ��ͷ������˽ڵ����һ�£�
		//�����õ���ͷ��������нڵ㣬һ��ĳһ���ڵ����������ͷ������һ�£���������
		for(Node n =head.next;n!=null;n=n.next) {
			
			if(n.row==head.row && n.col ==head.col) {
				Config.isLive=false;
			}
		}
		
		//������� ������ɼ������ݿ�
		if(Config.isLive==false) {
			int rs =UserDao.insertData(score, Config.user.getId());
			if(rs>0) {
				System.out.println("�ɹ�");
			}
		}
		
		
	}
	private void removeTail() {
		// TODO Auto-generated method stub
		tail.pre.next=null;//������β�ڵ�
		tail =tail.pre;//����β�ڵ�Ϊԭ�ڵ����һ���ڵ�
		
	}
	public Rectangle getRect() {
		return new Rectangle(head.col*Config.SPAN, head.row*Config.SPAN, Config.SPAN, Config.SPAN);
	}
	//�ж��Ƿ�Ե�ʳ�� true �Ե� false δ�Ե�
	public boolean isEat() {
	
		//�����ͷ���ڵľ�������
		
		//���ʳ�����ڵľ�������
		
		//�ж����������ڵľ�����������������Ե�������δ�Ե�
		if(getRect().intersects(food.getRect())) {
			//�Ե���
			food.repair();
			//�Ƿ�
			score++;
			Config.num++;
			return true;
		}
		
		return false;

	}

	public int getScore() {
		return score;
	}

	
	//�����ͷ
	private void addHead() {
		//�����½ڵ�
		Node node=null;
		//������ͷǰ���ķ���ͬ�������½ڵ㡣
		switch(head.dir) {
		case Config.U:
			//��ͷǰ���ķ���Ϊ�ϡ�ͷ������Ϊ1��

			node = new Node(head.row-1, head.col, head.dir);
			break;
		case Config.D:
			//��ͷǰ���ķ���Ϊ��
	
			node = new Node(head.row+1, head.col, head.dir);
	
			break;
		case Config.L:
			//��ͷǰ���ķ���Ϊ��
		
			node = new Node(head.row, head.col-1, head.dir);
		
			break;	
		case Config.R:
			//��ͷǰ���ķ���Ϊ��
			
			node = new Node(head.row, head.col+1, head.dir);
	
			break;
		default:
			break;
			
		
		}
		//�����½ڵ���ԭ�ڵ�Ĺ�ϵ
		node.next=head;
		head.pre=node;
		//�����½ڵ�Ϊ��ͷ
		head =node;
		
		
	
		
	}
//	�����ߵ��ƶ����� -����ͷ
	public void dirControl(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(a) {
	    	switch (arg0.getKeyCode()) {
			case KeyEvent.VK_UP:
				//���ϼ� ����ͷǰ���ķ�������Ϊ��(ǰ������Ϊ�� ��ֹ����ײ)
				if(!head.dir.equals(Config.D)) {
					//������ͷǰ������ �ϡ�
					head.dir =Config.U;	

//					System.out.println("��");
				}
				break;
			case KeyEvent.VK_DOWN:
			
				if(!head.dir.equals(Config.U)) {
					head.dir =Config.D;	
			
//					System.out.println("��");
				}
				
				break;
			case KeyEvent.VK_LEFT:
				
				if(!head.dir.equals(Config.R)) {
					head.dir =Config.L;

//					System.out.println("��");
					
				}
				
				
				break;
			case KeyEvent.VK_RIGHT:
				if(!head.dir.equals(Config.L)) {
					head.dir =Config.R;	

//					System.out.println("��");
				}
				
				break;

			default:
				break;
	    }
	    	  a=false;	
		}
		
		
	}
	
	

}
