package kr.or.dw.basic;

import java.util.HashSet;

public class SetTest {
	/*
	 * set의 특징 (List 와 비교)
	 * 1. List
	 *  - 데이터의 순서(index)가 있다.
	 *  - 중복되는 데이터를 저장할 수 있다.
	 * 2. Set
	 *  - 데이터의 순서(index)가 없다.
	 *  - 중복되는 데이터를 저장할 수 없다.
	 */
	public static void main(String[] args) {
		
		HashSet hs1 = new HashSet();
		
		// 데이터 추가 : add()메서드 이용
		hs1.add("DD");
		hs1.add("AA");
		hs1.add("WW");
		hs1.add(2);
		hs1.add("바보");
		hs1.add(1);
		
		System.out.println("Set의 길이 : " + hs1.size());
		System.out.println("Set의 데이터 : " + hs1);
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		// Set에 중복되는 데이터를 추가하면 false를 반환하고 데이터는 추가되지 않는다.
		boolean isAdd = hs1.add("BB");
		System.out.println("중복되지 않을 때 : " + isAdd);
		System.out.println("Set의 데이터 : " + hs1);
		isAdd = hs1.add("WW");
		System.out.println("중복될 때 : " + isAdd);
		System.out.println("Set의 데이터 : " + hs1);
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		// Set의 데이터를 수정하려면 수정하는 명령이 따로 없기 때문에 해당 자료를 삭제한 후 추가해 주는 방법을 사용한다.
		hs1.remove("AA");
		// 삭제하기 : remove(삭제할 데이터) ==> 삭제성공 (true), 삭제실패 (false)
		// 전체삭제 : clear()
		System.out.println("Set의 데이터 : " + hs1);
		
		
		
	}

}
