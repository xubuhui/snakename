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
 * 对rank表操作的类
 * @author xgq
 *
 */
public class RankDao {
	
	//查询排行
	//参数几条
	//返回值：List《RankVo》
	public List<RankVo> selectRanks(int count){
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<RankVo> ranks=null;
		
		//获取连接Connection
		connection = DBUtil.getConnection();
		//sql
		String sql ="select username,score,time from user u,rank r"
				+ " where u.id=r.userId order by score desc limit ?";
		ranks=new ArrayList<RankVo>();
		
		try {
			//获取PreparedStatement
			pstmt= connection.prepareStatement(sql);
			//如果存在sql中有占位符，需要占位符赋值
			pstmt.setInt(1, count);
			//执行查询得到结果集
			rs= pstmt.executeQuery();
			//处理结果集
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
		//释放资源
		//返回
		return ranks;
		
	}
	
	

}
