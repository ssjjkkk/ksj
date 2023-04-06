package e_oop;

import java.util.Scanner;

public class TV {
	
	static boolean power; // 전원 : 켰다, 껏다
	int channel; // 채널 : 숫자를 직접 누르는 방법, 채널 버튼으로 올리고 내리는 방법
	int volume; // 음량 올리는 방법, 내리는 방법
	static String what;
	Scanner s = new Scanner(System.in);
	
	void power() {
		String onOff = s.nextLine();
		if (onOff.equals("on")) {
			power = true;
			System.out.println("전원이 켜졌습니다. 현재 채널 : " + channel + "번 / 현재 음량 : " + volume);
		}else if (onOff.equals("off")) {
			power = false;
			System.out.println("전원이 꺼졌습니다. 감사합니다.");
		}
	}
	void powerOff() {
		System.out.println("전원이 꺼졌습니다. 감사합니다.");
	}
	void channelDirect() {
		System.out.println(what + " 번 채널 입니다.");
		channel = Integer.parseInt(what);
	}
	void channelUpAndDown() {
		String chUpAndDown = what;
		if(chUpAndDown.equals("chup")) {
			channel++;
			System.out.println(channel + " 번 입니다.");
		}else if(chUpAndDown.equals("chdown")) {
			channel--;
			System.out.println(channel + " 번 입니다.");
		}
	}
	void volumeUpAndDown() {
		String volumeUpAndDown = what;
		if(volumeUpAndDown.equals("volup")) {
			volume++;
			System.out.println("현재음량 " + volume + " 입니다.");
		}else if(volumeUpAndDown.equals("voldown")) {
			volume--;
			System.out.println("현재음량 " + volume + " 입니다.");
		}
	}
	

	public static void main(String[] args) {
		
		TV tv = new TV();
		Scanner sc = new Scanner(System.in);
		System.out.println("전원 켜기 : on / 전원 끄기 : off / 채널 변경 : 숫자입력  or chup or chdown / 음량 변경 : volup or voldown");
		tv.power();
		while(power) {
			what = sc.nextLine();
			if(what.equals("chup")||what.equals("chdown")) {
				tv.channelUpAndDown();
			}else if (what.equals("volup")||what.equals("voldown")) {
				tv.volumeUpAndDown();
			}else if (what.equals("off")) {
				tv.powerOff();
				break;
			} else {
				tv.channelDirect();
			}
		}
	}

	
}
