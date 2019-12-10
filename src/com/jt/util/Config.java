package com.jt.util;

import com.jt.po.User;

public class Config {
	
	public static final int ROWS =22;//行
	public static final int COLS =35;//列
	public static final int SPAN =20;//间距
	//定义方向的常量
	public static final String U= "u";//上
	public static final String D= "d";//下
	public static final String L= "l";//左
	public static final String R= "r";//右
	
	public static boolean isLive= true;//蛇死亡标识
//	public static String btn = "0"; //0正常 1暂停 2 继续  3重新
	public static boolean pause = false; //暂停是否按下
	public static User user = null; //User对象
	public static int num = 0; //吃到的食物
	


}
