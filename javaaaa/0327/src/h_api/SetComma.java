package h_api;

import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Arrays;

public class SetComma {

	public static void main(String[] args) {
		
		// 숫자를 입력받아서 3자리마다 콤마(,)를 붙여 출력해 주세요.
		// 10000000 ==> 1,000,000
		
		System.out.println("숫자를 입력해 주세요.");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String rpl = input.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
		
		System.out.println(rpl);
		
		char[] inputArray = new char[input.length()];
		for(int i = 0; i < input.length(); i++) {
			inputArray[i] = input.charAt(i);
		}
		
//		int count = 0;
//		String rev = "";
		// 방법 1
//		for(int i = input.length()-1; i >= 0; i--) {
//			rev += input.charAt(i);
//			count++;
//			if(count%3 == 0 && count < input.length()) {
//				rev += ",";
//			}
//		}
//		
//		for(int i = rev.length()-1; i >= 0; i--) {
//			System.out.print(rev.charAt(i));
//		}
		
		// 방법 2
//		for(int i = input.length()-1; i >= 0; i--) {
//			rev = input.charAt(i) + rev;
//			count++;
//			if(count%3 == 0 && count < input.length()) {
//				rev = "," + rev;
//			}
//		}
//		System.out.println(rev);
//		StringBuffer str = new StringBuffer("");
//		//방법3
//		for(int i = 0; i < input.length(); i++) {
//			count++;
//			if((input.length() - i) % 3 == 0 && i !=0) {
//				str.append(",");
//			}
//			str.append(input.charAt(i));
//		}
//		System.out.println(str);
		
		NumberFormat nf = NumberFormat.getInstance();
		String str = nf.format(Integer.parseInt(input));
		System.out.println(str);
		
		
		
	}

}
