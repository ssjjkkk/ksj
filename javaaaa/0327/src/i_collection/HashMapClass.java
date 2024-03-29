package i_collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;


public class HashMapClass {

	public static void main(String[] args) {
		/*
		 * Object put(Object key, Object value) : 지정된 키와 값을 저장한다.
		 * Object remove(Object key) : 지정된 키로 저장된 값을 제거한다.
		 * Object get(Object key) : 지정된 키의 값(없으면 null)을 반환한다.
		 * Set keySet() : 저장된 모든 키를 Set으로 반환한다.
		 */
		
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("a", 10);
		map.put("b", "홍길동");
		map.put("c", new Date());
		
		System.out.println(map);
		
		map.put("b", "이순신");
		System.out.println(map);	// 키값이 동일하기 때문에 value를 덮어쓴다.
		
		map.remove("a");
		System.out.println(map);
		
		Object value = map.get("b");
		System.out.println(value);
		
		Set<String> keys = map.keySet();	// 저장된 모든 키 반환
		System.out.println(keys);		
		for(String key : keys) {
			System.out.println("key 값 : " + key + " / value : " + map.get(key));
		}
		
		int[] a = new int[10];
		for(int i = 0; i < a.length; i++) {
			a[i] += i; 
		}
		for(int i : a) {
			System.out.print(i + 1 + "\t"); 
		}
		System.out.println();
		
		map.put("array", a);
		int[] bb = (int[]) map.get("array");
		System.out.println(bb[bb.length - 1]);
		
		// 회원 테이블
		// 이름, 연봉, 주소, 이메일, 아이디, 차종, 전화번호...
		/*
		 * 이름 : 관리자					name
		 * 아이디 : admin					id
		 * 비밀번호 : admin123				pwd
		 * 전화번호 : 010-1234-5678			phone
		 * 연봉 : 8500만원					sal
		 * 차종 : GV80					car
		 */
		HashMap<String, String> user = new HashMap<>();
		user.put("name", "관리자");
		user.put("id", "admin");
		user.put("pwd", "admin123");
		user.put("phone", "010-1234-5678");
		user.put("sal", "8500");
		user.put("car", "GV80");
		
		Set<String> uk = user.keySet();
		
		for(String key : uk) {
			System.out.println(key + " : " + user.get(key));
		}
		
		ArrayList<HashMap<String, String>> table = new ArrayList<>();
		table.add(user);
		table.add(user);
		System.out.println(table.get(0).get("name"));
		
		
		
		

	}

}
