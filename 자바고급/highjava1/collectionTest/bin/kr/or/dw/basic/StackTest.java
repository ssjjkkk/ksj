package kr.or.dw.basic;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		
		Browser b = new Browser();
		
		b.goURL("1. 네이버");
		b.goURL("2. 구글");
		b.goURL("3. 다음");
		b.goURL("4. 야후");
		
		b.history();
		
		System.out.println("뒤로가기 후...");
		b.goBack();
		b.history();
		
		System.out.println("뒤로가기 후...");
		b.goBack();
		b.history();
		
		System.out.println("앞으로가기 후...");
		b.goForward();
		b.history();
		
		System.out.println("새로운 사이트 접속 후...");
		b.goURL("5. 네이트");
		b.clear();
		b.history();
		
	}

}

class Browser {
	private Stack<String> back;		// 이번 방문 내역이 저장될 스택 변수
	private Stack<String> forward;	// 다음 방문 내역이 저장될 스택 변수
	private String currentURL;		// 현재페이지
	
	// 생성자
	public Browser() {
		this.back = new Stack<>();
		this.forward = new Stack<>();
		this.currentURL = "";
	}
	
	// 새로운 사이트 접속 후 앞으로가기 목록 제거
	public void clear() {
		while(!forward.empty()) {
			forward.pop();
		}
		
	}

	// 앞으로가기
	public void goForward() {
		if(!forward.empty()) {
			back.push(currentURL);
			currentURL = forward.pop();
		}
		
	}
	
	// 뒤로가기
	public void goBack() {
		if(!back.empty()) {
			forward.push(currentURL);	// 현재 페이지를 forward 스택에 추가
			currentURL = back.pop();	// back 스택에서 1개의 데이터를 꺼내와 현재 페이지로 설정한다.
		}
		
	}

	// 방문 기록을 확인하는 메서드
	public void history() {
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("\t방\t문\t기\t록");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("back : " + back);
		System.out.println("현재 페이지 : " + currentURL);
		System.out.println("forward : " + forward);
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println();
	}

	// 사이트를 방문하는 메서드 ==> 매개변수에 방문할 URL을 넣는다.
	public void goURL(String url) {
		if(currentURL != null && !"".equals(currentURL)) {
			back.push(currentURL); // 현재 페이지를 back스택 변수에 추가한다.
		}
		currentURL = url;	// 새로운 현재 페이지로 변경
	}
	
	
}