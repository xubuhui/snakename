package com.jt.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

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
import com.jt.util.Config;
import com.jt.util.ImageUtil;

public class LoginPanel extends JPanel implements ActionListener{
	
	//定义需要的组件属性
	Image bg_login;//背景图片
	JLabel lbl_username,lbl_passord,lbl_gh,lbl_theme,lbl;//用户名，密码,github
	JTextField tf_username;//用户名
	JPasswordField pf_password;//密码框
	JButton btn_login;
	JButton btn_reg;
	LoginFrame LoginFrame;
	Font font=new Font("黑体",Font.BOLD,80);
	Font f = new Font("黑体",Font.BOLD,48); 
	
	public LoginPanel(LoginFrame loginFrame) {
		this.LoginFrame=loginFrame;
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
		this.add(lbl_passord);
		this.add(lbl_gh);
		this.add(lbl_theme);
		this.add(tf_username);
		this.add(pf_password);
		this.add(btn_login);
		this.add(btn_reg);
		
	}
	//初始化组件
	private void initComponents() {
		// TODO Auto-generated method stub
		bg_login =ImageUtil.getImage("img/bg4.jpg");
		//初始化文本，文本框，密码款，按钮
		lbl_username=new JLabel("用户名");
		lbl_passord =new JLabel("密    码");
		lbl_username.setForeground(Color.white);
		lbl_passord.setForeground(Color.white);
		lbl_gh =new JLabel("前往Github");
		lbl_gh.setForeground(Color.cyan);
		lbl_theme =new JLabel("贪吃蛇大作战");
		lbl_theme.setFont(f);
		lbl_theme.setForeground(Color.white);
		
		tf_username =new JTextField(16);//设置文本框宽度
		pf_password =new JPasswordField(16);
		btn_login =new JButton("登陆");
		btn_reg =new JButton("注册");
		
		//设置上述组件位置
		lbl_username.setBounds(450,200,50,50);
		lbl_passord.setBounds(450,250,50,50);
		lbl_gh.setBounds(630,1,70,40);
		lbl_theme.setBounds(100,50,400,100);
		
		tf_username.setBounds(500,215,100,20);
		pf_password.setBounds(500,265,100,20);
		
		btn_login.setBounds(480,300,60,30);
		btn_reg.setBounds(550,300,60,30);
		
		//给按钮设置单击接听
		
		btn_login.addActionListener(this);
		btn_reg.addActionListener(this);
		lbl_gh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				 try {
					Runtime.getRuntime().exec(
							 "cmd   /c   start   https://github.com/xubuhui/snakename");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
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
	
		if(e.getSource()==btn_login) {
			//获取用户名文本框的值
			String username = tf_username.getText();
			String password = new String(pf_password.getPassword());
			// 调用UserDao的login（String username,String password）;
			UserDao userDao=new UserDao();
			User user = userDao.login(username, password);
			if(user!=null) {
				//存用户信息
				Config.user=user;
				
				if(user.getUsername().equals("root")) {
					JOptionPane.showMessageDialog(this, "欢迎管理员"+user.getUsername()+"回来!");
				}else {
					JOptionPane.showMessageDialog(this, user.getUsername()+"登陆成功！");
				}
				UserDao.insertTime();
				//关闭窗体
				LoginFrame.dispose();
				//打开游戏界面的窗体
				new SnakeFrame();
			}else {
				tf_username.setText("");
				pf_password.setText("");
				JOptionPane.showMessageDialog(this, "登录失败");
			}
		}
		
		if(e.getSource()==btn_reg) {
			new RegFrame();
		}
		
	}
	

}

