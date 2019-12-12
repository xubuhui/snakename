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
	
	//������Ҫ���������
	Image bg_login;//����ͼƬ
	JLabel lbl_username,lbl_passord,lbl_gh,lbl_theme,lbl;//�û���������,github
	JTextField tf_username;//�û���
	JPasswordField pf_password;//�����
	JButton btn_login;
	JButton btn_reg;
	LoginFrame LoginFrame;
	Font font=new Font("����",Font.BOLD,80);
	Font f = new Font("����",Font.BOLD,48); 
	
	public LoginPanel(LoginFrame loginFrame) {
		this.LoginFrame=loginFrame;
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
		this.add(lbl_passord);
		this.add(lbl_gh);
		this.add(lbl_theme);
		this.add(tf_username);
		this.add(pf_password);
		this.add(btn_login);
		this.add(btn_reg);
		
	}
	//��ʼ�����
	private void initComponents() {
		// TODO Auto-generated method stub
		bg_login =ImageUtil.getImage("img/bg4.jpg");
		//��ʼ���ı����ı���������ť
		lbl_username=new JLabel("�û���");
		lbl_passord =new JLabel("��    ��");
		lbl_username.setForeground(Color.white);
		lbl_passord.setForeground(Color.white);
		lbl_gh =new JLabel("ǰ��Github");
		lbl_gh.setForeground(Color.cyan);
		lbl_theme =new JLabel("̰���ߴ���ս");
		lbl_theme.setFont(f);
		lbl_theme.setForeground(Color.white);
		
		tf_username =new JTextField(16);//�����ı�����
		pf_password =new JPasswordField(16);
		btn_login =new JButton("��½");
		btn_reg =new JButton("ע��");
		
		//�����������λ��
		lbl_username.setBounds(450,200,50,50);
		lbl_passord.setBounds(450,250,50,50);
		lbl_gh.setBounds(630,1,70,40);
		lbl_theme.setBounds(100,50,400,100);
		
		tf_username.setBounds(500,215,100,20);
		pf_password.setBounds(500,265,100,20);
		
		btn_login.setBounds(480,300,60,30);
		btn_reg.setBounds(550,300,60,30);
		
		//����ť���õ�������
		
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
	
		if(e.getSource()==btn_login) {
			//��ȡ�û����ı����ֵ
			String username = tf_username.getText();
			String password = new String(pf_password.getPassword());
			// ����UserDao��login��String username,String password��;
			UserDao userDao=new UserDao();
			User user = userDao.login(username, password);
			if(user!=null) {
				//���û���Ϣ
				Config.user=user;
				
				if(user.getUsername().equals("root")) {
					JOptionPane.showMessageDialog(this, "��ӭ����Ա"+user.getUsername()+"����!");
				}else {
					JOptionPane.showMessageDialog(this, user.getUsername()+"��½�ɹ���");
				}
				UserDao.insertTime();
				//�رմ���
				LoginFrame.dispose();
				//����Ϸ����Ĵ���
				new SnakeFrame();
			}else {
				tf_username.setText("");
				pf_password.setText("");
				JOptionPane.showMessageDialog(this, "��¼ʧ��");
			}
		}
		
		if(e.getSource()==btn_reg) {
			new RegFrame();
		}
		
	}
	

}

