package h_api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateClass {

	public static void main(String[] args) {

		Date today = new Date();    // 현재 날짜
		System.out.println(today);
		
		// 날짜 -> 문자열
		SimpleDateFormat sdf1 = new SimpleDateFormat("yy/MM/dd a hh:mm");
		SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss.SSS");   // 대문자 H는 24시간을 기준으로 한다. 대문자 SSS는 1/1000초(millisecond)를 나타낸다
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd(E) hh:mm:ss a");
		
		System.out.println(sdf1.format(today));
		System.out.println(sdf2.format(today));
		System.out.println(sdf3.format(today));
		System.out.println(sdf4.format(today));
		
		// 문자열 -> 날짜
		String str = "1987년 05월 01일";
		SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy년 MM월 dd일");
		try {
			Date dateStr = sdf5.parse(str);
			System.out.println(sdf5.format(dateStr));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Calendar cal = Calendar.getInstance(); // 객체 생성 안해도됨. 싱글톤 패턴.
		
		cal.setTime(new Date());
//		cal.set(2022, 2, 19);    // 월은 0부터 시작
		System.out.println(cal.getTime());  // Date 객체를 리턴해준다.
		
		// 날짜 계산
		cal.add(Calendar.YEAR, 1);
		cal.add(Calendar.MONTH, 2);
		cal.add(Calendar.DAY_OF_MONTH, -2);
		cal.add(Calendar.HOUR, 4);
		cal.add(Calendar.MINUTE, 30);
		cal.add(Calendar.SECOND, -53);
		cal.add(Calendar.DATE, 2);
		
		System.out.println(sdf3.format(cal.getTime()));
		
		int day = cal.get(Calendar.DAY_OF_WEEK);
		int week_count = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
		int day_count = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(day);
		System.out.println("이번 달은 " + week_count + "주로 되어 있습니다.");
		System.out.println("이번 달은 " + day_count + "일로 되어 있습니다.");
		
		
	}

}
