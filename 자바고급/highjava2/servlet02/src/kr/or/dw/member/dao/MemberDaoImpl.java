package kr.or.dw.member.dao;

import java.sql.SQLException;
import java.util.List;
import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.dw.util.BuildSqlMapClient;
import kr.or.dw.vo.MemberVO;

public class MemberDaoImpl implements IMemberDao {
	
	private static MemberDaoImpl dao;
	private SqlMapClient smc;	// ibatis 용 SqlMapClient 객체 변수 선언
	
	private MemberDaoImpl() {
		smc = BuildSqlMapClient.getSqlMapClient();
	}
	
	public static MemberDaoImpl getInstance() {
		if(dao == null) {
			dao = new MemberDaoImpl();
		}
		return dao;
	}

	@Override
	public List<MemberVO> getAllMember() {
		// SQL문을 실행을 하고 결과를 받아서 service에 넘겨준다.
		List<MemberVO> memList = null;
		try {
			memList = smc.queryForList("mymember.getAllMember");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memList;
	}

}
