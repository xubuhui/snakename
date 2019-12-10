package com.jt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jt.util.DBUtil;
import com.jt.vo.RankVo;


/**
 * ��rank���������
 * @author xgq
 *
 */
public class RankDao {
	
	//��ѯ����
	//��������
	//����ֵ��List��RankVo��
	public List<RankVo> selectRanks(int count){
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<RankVo> ranks=null;
		
		//��ȡ����Connection
		connection = DBUtil.getConnection();
		//sql
		String sql ="select username,score,time from user u,rank r"
				+ " where u.id=r.userId order by score desc limit ?";
		ranks=new ArrayList<RankVo>();
		
		try {
			//��ȡPreparedStatement
			pstmt= connection.prepareStatement(sql);
			//�������sql����ռλ������Ҫռλ����ֵ
			pstmt.setInt(1, count);
			//ִ�в�ѯ�õ������
			rs= pstmt.executeQuery();
			//��������
			while(rs.next()) {
				String username = rs.getString(1);
				int score = rs.getInt(2);
				String date = rs.getString(3);
				RankVo rank=new RankVo(username, score, date);
				ranks.add(rank);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.releaseDB(rs, pstmt, connection);
		}
		//�ͷ���Դ
		//����
		return ranks;
		
	}
	
	

}
