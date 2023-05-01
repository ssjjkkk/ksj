package kr.or.dw.basic;

import javax.swing.JOptionPane;

public class ThreadTest07 {
	
	/*
	 * 컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오.
	 * 
	 * 컴퓨터의 가위 바위 보는 난수를 이용해서 구하고
	 * 사용자의 가위 바위 보는 showInputDialog() 를 이용해서 입력받는다.
	 * 
	 * 입력시간은 5초로 제한하고, 카운트 다운을 진행한다.
	 * 5초안에 입력이 없으면 게임에 진것으로 처리한다.
	 * 
	 * 5초안에 입력이 완료되면 승패를 구해서 출력한다.
	 * 결과 예시)
	 * -- 결 과 --
	 * 컴퓨터 : 가위
	 * 사용자 : 바위
	 * 	<승!!>
	 */
	
	public static GameThread gt = new GameThread();
	
	public static void main(String[] args) {

		CountDownThread1 cdt = new CountDownThread1();
		gt.start();
		cdt.start();

	}

}

class GameThread extends Thread {
	
	public static boolean inputCheck1;
	@Override
	public void run() {
		System.out.println("가위, 바위, 보 게임");
		String str = JOptionPane.showInputDialog("가위, 바위, 보 중 하나를 5초 안에 내주세요.");
		inputCheck1 = true;
		
		String[] comData = {"가위", "바위", "보"}; 
		int com = (int)(Math.random()*3);
		System.out.println("나 : " + str);
		System.out.println("컴 : " + comData[com]);

		if(comData[com].equals("가위")) {
			if(str.equals("가위")) {
				System.out.println("무승부");
				return;
			} else if (str.equals("바위")) {
				System.out.println("승리");
				return;
			} else if (str.equals("보")) {
				System.out.println("패배");
				return;
			} else {
				System.out.println("패배");
				return;
			}
		} else if (comData[com].equals("바위")) {
			if(str.equals("가위")) {
				System.out.println("패배");
				return;
			} else if (str.equals("바위")) {
				System.out.println("무승부");
				return;
			} else if (str.equals("보")) {
				System.out.println("승리");
				return;
			} else {
				System.out.println("패배");
				return;
			}
		} else if (comData[com].equals("보")) {
			if(str.equals("가위")) {
				System.out.println("승리");
				return;
			} else if (str.equals("바위")) {
				System.out.println("패배");
				return;
			} else if (str.equals("보")) {
				System.out.println("무승부");
				return;
			} else {
				System.out.println("패배");
				return;
			}
		}
		
	}
	
	
}

class CountDownThread1 extends Thread {
	
	@Override
	public void run() {
		for(int i = 5; i >=0; i--) {
			System.out.println(i);
			
			if(GameThread.inputCheck1 == true) {
				return;
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		try {
			ThreadTest07.gt.sleep(100);
			ThreadTest07.gt.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("지정된 시간이 경과되었습니다. 패배하였습니다.");
		
	}
}




