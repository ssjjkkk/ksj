package kr.or.dw.member.dao;

import java.util.List;

import kr.or.dw.vo.MemberVO;

/**
 * @author admin
 * 실제 DB와 연결해서 SQL문을 수행하여 결과를 작성하고
 * Service에 전달하는 Dao의 Interface
 */
public interface IMemberDao {
	
	/**
	 * 전체 회원 정보를 DB에서 가져와 List에 담아서 반환하는 메서드
	 * 
	 * @return 회원정보(MemberVO)가 저장될 List 객체
	 */
	public List<MemberVO> getAllMember();

}
