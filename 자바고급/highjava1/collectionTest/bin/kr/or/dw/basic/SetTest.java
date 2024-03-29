package kr.or.dw.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

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
		
		HashSet<Integer> intSet = new HashSet<>();
		intSet.add(10);
		intSet.add(7);
		intSet.add(9);
		intSet.add(3);
		intSet.add(5);
		
		// set의 모든 데이터 합계 구하기
		/*
		 * Set의 데이터는 순서(index)가 없기 때문에 List 처럼 index로 데이터를 하나씩
		 * 불러올 수 없다.
		 * 그래서 데이터를 하나씩 얻기 위해서는 Iterator형 객체로 변환해서 사용해야한다.
		 * Set형의 데이터를 Iterator형 객체로 변환해주는 메서드는 ==> Iterator()
		 */
		// 순서가 없는 애들은 순서를 부여해서 가져옴
		
		Iterator<Integer> it = intSet.iterator();	// set데이터를 iterator로 변환하기
		
		// Iterator hasNext() 메서드 ==> Iterator 의 데이터를 가르키는 포인터의 다음번째의
		// 위치에 데이터가 있으면 true, false를 반환한다.
		
		int sum = 0;
		while(it.hasNext()) {
			// Iterator의 next() 메서드 ==> 포인터를 다음번째 위치로 이동한 후 그자리의 데이터를 반환한다.
			sum += it.next();
		}
		System.out.println("총 합계 : " + sum);
		
		// 우리반 학생들 중 번호를 이용하여 추첨하는 프로그램을 작성해보자.
		// 번호는 1번부터 25번까지 있고, 추첨할 인원은 3명이다.
		// 당첨자를 출력해봅시다.
		
		// 배열식
		int[] numArr = new int[3];
		for(int i = 0; i < numArr.length; i ++) {
			numArr[i] = (int)(Math.random()*25) + 1;
		}
		System.out.println(Arrays.toString(numArr));
		
		//Set
		HashSet<Integer> numSet = new HashSet<>();
		TreeSet<Integer> treeNumSet = new TreeSet<>();
		
		while(numSet.size() < 3) {
			int num = (int)(Math.random()*25) + 1;
			numSet.add(num);
			treeNumSet.add(num);
		}
		System.out.println("당첨자 : " + numSet);
		System.out.println("당첨자 : " + treeNumSet);
		
		// Set유형의 자료를 List형으로 변환하기
		ArrayList<Integer> testList = new ArrayList<>(numSet);
		
		System.out.println("List 데이터 출력 : " + testList);
				
	}

}
