package com.jt.po;
/**
 * user表对应的实体类
 * @author xgq
 *实体类中的属性对应表中的字段-》表中的一个记录，就可以用一个对象表示
 */
public class User {
	
	private int id;// 对表中的id字段
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
