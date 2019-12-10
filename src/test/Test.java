package test;

import java.util.List;

import com.jt.dao.RankDao;
import com.jt.vo.RankVo;

public class Test {
	public static void main(String[] args) {
		RankDao rd=new RankDao();
		List <RankVo> ranks=rd.selectRanks(4);
		System.out.println(ranks.size());
		for (int i = 0; i <ranks.size(); i++) {
			System.out.println(ranks.get(i));
		}
		
	}

}
