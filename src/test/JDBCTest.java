package test;

import java.sql.*;
//�޸�

public class JDBCTest {
	
	public static void main(String[] args) {
		String url ="jdbc:mysql://localhost:3306/snakegame";
		
		String username="root";
		String password="root";
		String driverName = "com.mysql.jdbc.Driver";
		Connection connection=null;
		PreparedStatement pstmt =null;
		
		int rs;
		try {
			//ע��������Driver
			Class.forName(driverName);
			connection = DriverManager.getConnection(url,username,password);
//			System.out.println(connection);
			//ռλ��?
			String sql="update user set username =? where id = ?";
			
//			3.ͨ��connection��ȡpreparedStatement,���ڷ���sql
		
			pstmt = connection.prepareStatement(sql);
			//4.����sql֮ǰ�����sql�����ռλ������Ҫ��ռλ����ֵ
			//parameterIndex:�������������ڼ����ʺţ�
			pstmt.setString(1, "������");
			pstmt.setInt(2, 1);
			//����sql��䣬ִ�в�ѯ
			rs = pstmt.executeUpdate();
			if(rs>0) {
		
				System.out.println("�޸ĳɹ�");
			}else {
				System.out.println("�޴��û���");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//7.�ͷ���Դ
		
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
