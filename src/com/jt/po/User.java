package com.jt.po;
/**
 * user���Ӧ��ʵ����
 * @author xgq
 *ʵ�����е����Զ�Ӧ���е��ֶ�-�����е�һ����¼���Ϳ�����һ�������ʾ
 */
public class User {
	
	private int id;// �Ա��е�id�ֶ�
	private String username;
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	
	

}
