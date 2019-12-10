package com.jt.vo;
/**
 * 游戏排行的视图类
 * @author xgq
 *
 */
public class RankVo {
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	private String username;
	
	private int score;
	
	private String date;

	public RankVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RankVo(String username, int score, String date) {
		super();
		this.username = username;
		this.score = score;
		this.date = date;
	}

	@Override
	public String toString() {
		return "RankVo [username=" + username + ", score=" + score + ", date=" + date + "]";
	}
	

}
