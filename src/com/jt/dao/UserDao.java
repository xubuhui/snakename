package com.jt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.jt.po.User;
import com.jt.util.DBUtil;

/**
 * user表操作类
 * @author xgq
 *
 */

public class UserDao {
	//根据用户名密码查询用户
	//参数：
	//返回值：

	static User user=null;
	

	public User login(String username,String password) {
		
		//1.获取连接
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null ;
		connection = DBUtil.getConnection();
		
		//2.sql
		String sql="select * from user where username = ? and password = ?";
		//3.PreparedStatement
		try {
			pstmt = connection.prepareStatement(sql);
			//4.占位符赋值
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			//5.执行查询，得到结果集
			rs = pstmt.executeQuery();
			if(rs.next()) {
				//有数据
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String pwd = rs.getString(3);
				user =new User(id,name,pwd);
				
			}
			
			//6.操作结果集
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//7.释放资源
			DBUtil.releaseDB(rs, pstmt, connection);
		}
		//8.返回
		return user;
	
	}
	
	//添加用户
	//参数：用户名，密码
//	public int regist(String username,String password) {
//		
//		return 0;
//	}
	public static int insertTime() {
		Connection connection =null;
		PreparedStatement pstmt = null;
		int rs1=0;
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
		connection = DBUtil.getConnection();
		String sql="update user set lasttime = ? where id = ?";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1,formatter.format(new Date(System.currentTimeMillis())));
			pstmt.setInt(2,user.getId());
			rs1 = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return rs1;
		
	}
	
	public static int insertData(int score,int userId) {
		Connection connection =null;
		PreparedStatement pstmt = null;
		int rs2=0;
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
		connection = DBUtil.getConnection();
		String sql="INSERT INTO rank (score, time,userId) VALUES (?, ?,?)";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, score);
			pstmt.setString(2,formatter.format(new Date(System.currentTimeMillis())));
			pstmt.setInt(3, userId);
			rs2 = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return rs2;
	}


}



