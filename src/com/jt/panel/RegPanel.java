package com.jt.panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.jt.dao.UserDao;
import com.jt.frame.LoginFrame;
import com.jt.frame.RegFrame;
import com.jt.frame.SnakeFrame;
import com.jt.po.User;
import com.jt.util.DBUtil;
import com.jt.util.ImageUtil;

public class RegPanel extends JPanel implements ActionListener{
	
	//������Ҫ���������
	Image bg_login;//����ͼƬ
	JLabel lbl_username,lbl_password,lbl_repassword;//�û��������룬ȷ������
	JTextField tf_username;//�û���
	JPasswordField pf_password;//�����
	JPasswordField pf_repassword;//ȷ�������
	JButton btn_reg;
	RegFrame regFrame;
	
	public RegPanel(RegFrame regFrame) {
		this.regFrame=regFrame;
		//���ó�ʼ�������Ϣ�ķ���
		initPanel();
		//��ʼ�������Ϣ
		initComponents();
		//������
		addComponents();
	}
	
	private void addComponents() {
		// TODO Auto-generated method stub
		this.add(lbl_username);
		this.add(lbl_password);
		this.add(lbl_repassword);
		this.add(tf_username);
		this.add(pf_password);
		this.add(pf_repassword);
		this.add(btn_reg);
		
	}
	//��ʼ�����
	private void initComponents() {
		// TODO Auto-generated method stub
		bg_login =ImageUtil.getImage("img/bg_login.jpg");
		//��ʼ���ı����ı���������ť
		lbl_username=new JLabel("�û�    ��");
		lbl_password =new JLabel("��	        ��");
		lbl_repassword =new JLabel("ȷ������");
		tf_username =new JTextField(16);//�����ı�����
		pf_password =new JPasswordField(16);
		pf_repassword =new JPasswordField(16);
		btn_reg =new JButton("ע��");
		
		//�����������λ��
		lbl_username.setBounds(430,200,70,50);
		lbl_password.setBounds(430,250,70,50);
		lbl_repassword.setBounds(430,300,70,50);
		
		tf_username.setBounds(500,215,100,20);
		pf_password.setBounds(500,265,100,20);
		pf_repassword.setBounds(500,315,100,20);
		
		btn_reg.setBounds(510,355,60,30);
		
		//����ť���õ�������
		
		btn_reg.addActionListener(this);
		
		
		
	}
	//��ʼ�������Ϣ
	private void initPanel() {
		// ��������λ��
		this.setBounds(0,0,715,500);
		
//		this.setBackground(Color.green);
		
		this.setLayout(null);
		
		
		
	}
	
	//��дpaintComponent����
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		//���ñ���ɫ
		g.drawImage(bg_login, 0, 0, this);
		
	}
	//��ť�������÷���
	@Override
	public void actionPerformed(ActionEvent e) {
		//��ȡ�û����ı����ֵ
		String username = tf_username.getText();
		String password = new String(pf_password.getPassword());
		String repassword = new String(pf_repassword.getPassword());
		if(username.trim().equals("")||username==null) {
			JOptionPane.showMessageDialog(this, "�û���Ϊ��");
			
		}else {
			if(password.equals(repassword)) {
				
				Connection connection = null;
				PreparedStatement pstmt = null;
				PreparedStatement pstmt2 = null;
				ResultSet rs= null ;
				int rs2 ;
				User user=null;
				
				connection = DBUtil.getConnection();
				String sql="select * from user where username = ?";

				try {
					pstmt = connection.prepareStatement(sql);

					pstmt.setString(1, username);

					rs = pstmt.executeQuery();
					if(!rs.next()) {
						String sql2="INSERT INTO user ( username, password ) VALUES (?,? )";
						try {
							pstmt2 = connection.prepareStatement(sql2);
							pstmt2.setString(1, username);
							pstmt2.setString(2, password);
							rs2=pstmt2.executeUpdate();
							if(rs2>0) {
//								System.out.println(rs2);
								JOptionPane.showMessageDialog(this, "ע��ɹ�");
								regFrame.dispose();
							}
							
							}catch (Exception e2) {
								// TODO: handle exception
								e2.printStackTrace();
							}finally {
								pstmt2.close();
							}
						
					}else {
						JOptionPane.showMessageDialog(this, "���û���ע��");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally {
					//7.�ͷ���Դ
					DBUtil.releaseDB(rs, pstmt, connection);
				
				}

			}else {
				JOptionPane.showMessageDialog(this, "������������벻һ��");
			}
		}

	
				
		
	}
	

}

