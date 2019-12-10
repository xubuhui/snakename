package test;

import java.sql.*;


public class JDBCTest2 {
	
	public static void main(String[] args) {
		String url ="jdbc:mysql://localhost:3306/snakegame";
		
		String username="root";
		String password="root";
		String driverName = "com.mysql.jdbc.Driver";
		Connection connection=null;
		PreparedStatement pstmt =null;
		
		ResultSet rs=null;
		try {
			//注册驱动类Driver
			Class.forName(driverName);
			connection = DriverManager.getConnection(url,username,password);
//			System.out.println(connection);
			//占位符?
			String sql="Select * from user where id = ?";
			
//			3.通过connection获取preparedStatement,用于发送sql
		
			pstmt = connection.prepareStatement(sql);
			//4.发送sql之前，如果sql语句有占位符，需要给占位符赋值
			//parameterIndex:参数的索引（第几个问号）
			pstmt.setInt(1, 1);
			//发送sql语句，执行查询
			rs = pstmt.executeQuery();
			if(rs.next()) {
			int id=rs.getInt(1);
			String name =rs.getString(2);
			String pwd =rs.getString(3);
			System.out.println("id name pwd");
			System.out.println(id+"  "+name+" "+pwd);
			}else {
				System.out.println("无此用户！");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//7.释放资源
			try {
				if(rs!=null) {
					rs.close();	
				}
			}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
			}catch (SQLException e) {
				// TODO: handle exception
			}
			try {
				if(connection!=null) {
					connection.close();
				}
			}catch (SQLException e) {
				// TODO: handle exception
			}
			
			
		}
		
	}
	

}
