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
	
	//定义需要的组件属性
	Image bg_login;//背景图片
	JLabel lbl_username,lbl_password,lbl_repassword;//用户名，密码，确认密码
	JTextField tf_username;//用户名
	JPasswordField pf_password;//密码框
	JPasswordField pf_repassword;//确认密码框
	JButton btn_reg;
	RegFrame regFrame;
	
	public RegPanel(RegFrame regFrame) {
		this.regFrame=regFrame;
		//调用初始化面板信息的方法
		initPanel();
		//初始化组件信息
		initComponents();
		//添加组件
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
	//初始化组件
	private void initComponents() {
		// TODO Auto-generated method stub
		bg_login =ImageUtil.getImage("img/bg_login.jpg");
		//初始化文本，文本框，密码款，按钮
		lbl_username=new JLabel("用户    名");
		lbl_password =new JLabel("密	        码");
		lbl_repassword =new JLabel("确认密码");
		tf_username =new JTextField(16);//设置文本框宽度
		pf_password =new JPasswordField(16);
		pf_repassword =new JPasswordField(16);
		btn_reg =new JButton("注册");
		
		//设置上述组件位置
		lbl_username.setBounds(430,200,70,50);
		lbl_password.setBounds(430,250,70,50);
		lbl_repassword.setBounds(430,300,70,50);
		
		tf_username.setBounds(500,215,100,20);
		pf_password.setBounds(500,265,100,20);
		pf_repassword.setBounds(500,315,100,20);
		
		btn_reg.setBounds(510,355,60,30);
		
		//给按钮设置单击接听
		
		btn_reg.addActionListener(this);
		
		
		
	}
	//初始化面板信息
	private void initPanel() {
		// 设置面板的位置
		this.setBounds(0,0,715,500);
		
//		this.setBackground(Color.green);
		
		this.setLayout(null);
		
		
		
	}
	
	//重写paintComponent方法
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		//设置背景色
		g.drawImage(bg_login, 0, 0, this);
		
	}
	//按钮单击调用方法
	@Override
	public void actionPerformed(ActionEvent e) {
		//获取用户名文本框的值
		String username = tf_username.getText();
		String password = new String(pf_password.getPassword());
		String repassword = new String(pf_repassword.getPassword());
		if(username.trim().equals("")||username==null) {
			JOptionPane.showMessageDialog(this, "用户名为空");
			
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
								JOptionPane.showMessageDialog(this, "注册成功");
								regFrame.dispose();
							}
							
							}catch (Exception e2) {
								// TODO: handle exception
								e2.printStackTrace();
							}finally {
								pstmt2.close();
							}
						
					}else {
						JOptionPane.showMessageDialog(this, "该用户已注册");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally {
					//7.释放资源
					DBUtil.releaseDB(rs, pstmt, connection);
				
				}

			}else {
				JOptionPane.showMessageDialog(this, "两次输入的密码不一样");
			}
		}

	
				
		
	}
	

}

