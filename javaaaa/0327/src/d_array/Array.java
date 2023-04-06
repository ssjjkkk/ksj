package d_array;

import java.util.Arrays;
import java.util.Scanner;

public class Array {

	public static void main(String[] args) {
		
		/*
		 * << 배열 >>
		 *  - 여러개의 값을 하나의 변수에 저장해서 사용하는 것이다.
		 *  - 참조형 타입이다.
		 *  - 인덱스로 값을 구분한다.
		 *  - 길이를 변경할 수 없다.
		 */
		
		int[] array;		// 배열의 주소를 저장할 공간이 만들어진다.
		array = new int[5];	// 배열이 생성되고 그 주소가 저장된다.
		
//		int[] array2 = new int[5];
		
//		array = new int[] {1, 2, 3, 4, 5};
//		array = {1, 2, 3, 4, 5};	// 이 방법은 변수의 선언과 초기화를 동시에 해야한다.
		int[] array2 = {1, 2, 3, 4, 5};
		
//		System.out.println(array2[0]);
//		System.out.println(array2[1]);
//		System.out.println(array2[2]);
//		System.out.println(array2[3]);
//		System.out.println(array2[4]);
		
//		int sum = 0;
//		for(int i = 0; i < array2.length; i++) {
//			sum += array2[i];
//		}
//		System.out.println("합계 : " + sum);
		
//		int[] arrayx;
//		arrayx = new int[10];
//		
//		for(int i = 0; i < arrayx.length; i++) {
//			arrayx[i] = (int)(Math.random() * 100) + 1;
//		}
//		
//		System.out.println(Arrays.toString(arrayx));
		
		// 위에서 만든 임의의 숫자 10개 배열에서 최대값과 최소값을 구해주세요.
		
//		int max = arrayx[0];
//		int min = arrayx[0];
//		for(int i = 0; i < arrayx.length; i++) {
//			if(max < arrayx[i]) {
//				max = arrayx[i];
//			}
//			if(min > arrayx[i]) {
//				min = arrayx[i];
//			}
//		}
//		System.out.println("최대값 : " + max + " / 최소값 : " + min);
		
		
		// 1 ~ 10 까지의 숫자를 배열 x에 랜덤하게 배치하세요.
//		int[] x = new int[10];
//		for(int i = 0; i < x.length; i++) {
//			x[i] = (int)(Math.random() * 10);
//			for(int j = 0; j < i; j++) {
//				if(x[i] == x[j]) {
//					i--;
//				}
//			}
//		}
//		System.out.println(Arrays.toString(x));
		
//		int[] x = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//		
//		int temp = 0;
//		for(int i = 0; i < x.length; i++) {
//			int r = (int)(Math.random() * x.length);
//			temp = x[i];
//			x[i] = x[r];
//			x[r] = temp;
//			System.out.println("랜덤숫자 : " + r);
//			System.out.println(Arrays.toString(x));
//		}
//		System.out.println(Arrays.toString(x));
		
		// 0 ~ 9 사이의 랜덤값을 500번 생성하고, 각 숫자가 생성된 횟수를 배열에 담아 출력해주세요.
		
//		int[] ax = new int[10];	// {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
//		for(int i = 0; i < 500; i++) {
//			int a = (int)(Math.random() * ax.length);
//			ax[a] += 1;
//		}
//		System.out.println(Arrays.toString(ax));
		
		
		// 위 문제의 최소값, 최대값, 반복횟수를 입력받아 각 숫자가 생성된 횟수를 출력해주세요.
		
//		Scanner s = new Scanner(System.in);
//		System.out.println("최소값을 입력해주세요 > ");
//		int inputMin = Integer.parseInt(s.nextLine());
//		System.out.println("최대값을 입력해주세요 > ");
//		int inputMax = Integer.parseInt(s.nextLine());
//		System.out.println("반복횟수을 입력해주세요 > ");
//		int repet = Integer.parseInt(s.nextLine());
//		
//		int arrLength = inputMax - inputMin + 1;
//		int[] ax = new int[arrLength];
//		for(int i = 0; i < repet; i++) {
//			int a = (int)(Math.random() * arrLength + inputMin);
//			ax[a-inputMin] += 1;
//		}
//		System.out.println(Arrays.toString(ax));
		
		
		/*
		 * 거스름돈에 동전의 단위마다  몇개의 동전이 필요한지 출력해주세요.
		 * 거스름돈 : -> random() ==> 5000원 아래 ==> 4500원, 4750원
		 * 500원 : 5개
		 * 100원 : 3개
		 * 50원 : 1개
		 * 10원 : 1개
		 */
		
		int money = (int)(Math.random() * 500) * 10;	// 10원 단위로 절삭
		int[] coin = {500, 100, 50, 10};
		int[] res = new int[4];
		
		int remain = money;
		for(int i = 0; i < coin.length; i++) {
			res[i] = (int)remain/coin[i];	// 필요한 동전의 갯수가 순서대로 res 배열에 추가됨
			remain = remain - res[i] * coin[i];
			if(remain == 0) break;
		}
		System.out.println("거스름돈 : " + money);
		System.out.println("500원 : " + res[0] + "개, 100원 : " + res[1] + "개, 50원 : " + res[2] + "개, 10원 : " + res[3] + "개");
		
		
		
		
		
		

	}

}
