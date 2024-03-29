package kr.or.dw.basic;

import javax.swing.JOptionPane;

public class ThreadTest06 {
	
	public static DataInputThread dit = new DataInputThread();

	public static void main(String[] args) {
		
		CountDownThread cdt = new CountDownThread();
		
		dit.start();
		cdt.start();
		
	}

}

// 데이터를 입력하는 쓰레드
class DataInputThread extends Thread {
	// 입력 여부를 확인하기 위한 변수 선언 : 쓰레드에서 공통으로 사용할 변수
	
	public static boolean inputCheck;
	
	@Override
	public void run() {
		// 사용자로부터 데이터 입력 받기
		String str = JOptionPane.showInputDialog("아무노래나 일단 입력해");
		inputCheck = true;
		System.out.println("입력값 : " + str);
	}
	
}

// 카운트 다운을 진행하는 쓰레드
class CountDownThread extends Thread {

	@Override
	public void run() {
		for(int i = 10; i >=0; i--) {
			System.out.println(i);
			
			// 입력이 완료되었는지 여부를 검사해서 입력이 완료되면 쓰레드를 종료시킨다.
			if(DataInputThread.inputCheck == true) {
				return; // run() 메서드가 종료되면 쓰레드도 종료된다.
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			ThreadTest06.dit.sleep(10);
			ThreadTest06.dit.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("지정된 시간이 경과되었습니다. 프로그램을 종료합니다.");
	}
	
	
}