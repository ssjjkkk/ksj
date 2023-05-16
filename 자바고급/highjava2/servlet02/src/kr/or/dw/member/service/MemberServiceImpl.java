package kr.or.dw.member.service;

import java.util.List;

import kr.or.dw.member.dao.IMemberDao;
import kr.or.dw.member.dao.MemberDaoImpl;
import kr.or.dw.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {
	// Dao 객체 변수 생성
	private IMemberDao dao;
	private static MemberServiceImpl service;
	
	public static MemberServiceImpl getInstance() {
		if(service == null) {
			service = new MemberServiceImpl();
		}
		return service;
	}
	
	// 생성자
	private MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
	}
	
	@Override
	public List<MemberVO> getAllMember() {
		return dao.getAllMember();
	}
	
	
}
