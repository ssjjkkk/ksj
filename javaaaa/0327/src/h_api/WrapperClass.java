package h_api;

public class WrapperClass {

	public static void main(String[] args) {
		
		/*
		 * Wrapper 클래스 : 기본형 타입을 객체로 사용해야 할 때 대신 사용하는 클래스
		 * - boolean	: Boolean
		 * - char		: Character
		 * - byte		: Byte
		 * - short		: Byte
		 * - int		: Integer
		 * - long		: Long
		 * - float		: Float
		 * - double		: Double
		 */
		
		int a = 20;
		Integer iw = new Integer(20);
		
		System.out.println(Integer.TYPE + " / " + Integer.SIZE + "bit");
		
		System.out.println(Integer.MIN_VALUE + " ~ " + Integer.MAX_VALUE);
		
		int b = Integer.parseInt("30");
		
		int c = iw;		// 기본형에도 저장할 수 있다. (자동 형변환)
						// 언박싱 : wrapper 클래스가 기본형 타입으로 자동 변환
		
	}

}
