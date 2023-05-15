package kr.or.dw.member.service;

import java.util.List;

import kr.or.dw.vo.MemberVO;

/*
 * Service 객체는 Dao에 설정된 메서드를 원하는 작업에 맞게 호출하여 결과를 받아오고,
 * 받아온 결과 자료를 Controller 에게 보내주는 역할을 한다.
 * 보통 DAO의 메서드와 메서드명을 같게한다.
 */

public interface IMemberService {
	
	/**
	 * 전체 회원 정보를 DB에서 가져와 List에 담아서 반환하는 메서드
	 * 
	 * @return 회원정보(MemberVO)가 저장될 List 객체
	 */
	public List<MemberVO> getAllMember();
	
}
