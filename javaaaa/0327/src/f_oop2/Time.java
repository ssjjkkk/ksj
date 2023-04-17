package f_oop2;

public class Time {

	private int hour;
	private int minute;
	private int second;
	
//	public int hour;
//	public int minute;
//	public int second;
	
	String getTime() {
		return hour + ":" + minute + ":" + second;
	}
	
	public void setTime(int hour, int minute, int second) {
		if(hour > 0 && hour < 24) {
			this.hour = hour;
		}else if (hour >= 24) {
			this.hour = hour - 24;
		}
		if(minute > 0 && minute < 60) {
			this.minute = minute;
		}else if (minute >= 60) {
			this.minute = minute - 60;
			this.hour += minute/60;
		}
		if(second > 0 && second < 60) {
			this.second = second;
		}else if (second >= 60) {
			this.second = second - 60;
			this.minute += second/60; 
		}
		
	}
	
	public int getHour() {
		return hour;
	}
	
	public int getMinute() {
		return minute;
	}
	
	public int getSecond() {
		return second;
	}
	
	public void setHour(int hour) {
		if(hour > 0 && hour < 24) {
			this.hour = hour;
		}else if (hour >= 24) {
			this.hour = hour - 24;
		}
		
	}
	
	public void setMinute(int minute) {
		if(minute > 0 && minute < 60) {
			this.minute = minute;
		}else if (minute >= 60) {
			this.minute = minute - 60;
			this.hour += minute/60;
		}
		
	}
	
	public void setSecond(int second) {
		if(second > 0 && second < 60) {
			this.second = second;
		}else if (second >= 60) {
			this.second = second - 60;
			this.minute += second/60;
		}
	}
	
	void clock() {
		while(true) {
			System.out.println(getTime());
			stop(1000);
			setSecond(second + 1);
		}
	}
	
	private void stop(int interval) {
		try {
			Thread.sleep(interval);  // 1/1000 milliseconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}

