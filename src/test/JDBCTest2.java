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
			//ע��������Driver
			Class.forName(driverName);
			connection = DriverManager.getConnection(url,username,password);
//			System.out.println(connection);
			//ռλ��?
			String sql="Select * from user where id = ?";
			
//			3.ͨ��connection��ȡpreparedStatement,���ڷ���sql
		
			pstmt = connection.prepareStatement(sql);
			//4.����sql֮ǰ�����sql�����ռλ������Ҫ��ռλ����ֵ
			//parameterIndex:�������������ڼ����ʺţ�
			pstmt.setInt(1, 1);
			//����sql��䣬ִ�в�ѯ
			rs = pstmt.executeQuery();
			if(rs.next()) {
			int id=rs.getInt(1);
			String name =rs.getString(2);
			String pwd =rs.getString(3);
			System.out.println("id name pwd");
			System.out.println(id+"  "+name+" "+pwd);
			}else {
				System.out.println("�޴��û���");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//7.�ͷ���Դ
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
