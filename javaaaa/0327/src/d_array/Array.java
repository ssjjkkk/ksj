package d_array;

import java.util.Arrays;
import java.util.Scanner;

public class Array {

	public static void main(String[] args) {
		
		/*
		 * << 배열 >>
		 * - 여러개의 값을 하나의 변수에 저장해서 사용하는 것이다.
		 * - 참조형 타입이다.
		 * - 인덱스로 값을 구분한다.
		 * - 길이를 변경할 수 없다.
		 */
		
		int[] array; // 배열의 주소를 저장할 공간이 만들어진다.
		array = new int[5]; // 배열이 생성되고 그 주소가 저장된다.
		
//		int[] array2 = new int[5];
		
		array = new int[] {1, 2, 3, 4, 5};
//		array = {1, 2, 3, 4, 5}; // 이 방법은 변수의 선언과 초기화를 동시에 해야한다.
		int[] array2 = {1, 2, 3, 4, 5};
		
//		System.out.println(array[0]);
//		System.out.println(array2[3]);
//		
//		int sum = 0;
//		for (int i = 0; i < array2.length; i++) {
//			sum += array2[i];
//			System.out.println(array2[i]);
//		}
//		System.out.println("합계 : " + sum);
		
//		int[] arrayx;
//		arrayx = new int[10];
//		for(int i = 0; i < arrayx.length; i++) {
//			arrayx[i] = (int)(Math.random() * 100 + 1);
//		}
//		System.out.println(Arrays.toString(arrayx));
//		
//		// 위에서 만든 임의의 숫자 10개  배열에서 최대값과 최소값을 구해주세요.
//		int max = arrayx[0];
//		int min = arrayx[0];
//		for(int i = 0; i < arrayx.length; i++) {			
//			if (max < arrayx[i]) {
//				max = arrayx[i];
//			}
//			if (min > arrayx[i]) {
//				min = arrayx[i];
//			}
//		}
//		System.out.println(max);
//		System.out.println(min);
		
		// 1 ~ 10 까지의 숫자를 배열 x에 랜덤하게 배치하세요
		
//		int[] x;
//		x = new int[10];
//		for(int i = 0; i < x.length; i++) {
//			x[i] = (int)(Math.random() * 10 + 1);
//			for(int j = 0; j < i; j++) {
//				if (x[i] == x[j]) {
//					i--;
//					break;
//				}
//			}
//			 
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
//			System.out.print("랜덤숫자 : " + r);
//			System.out.println(Arrays.toString(x));
//		}
//		System.out.println(Arrays.toString(x));
	
		// 1 ~ 10사이의 랜덤값을 500번 생성하고, 각 숫자가 생성된 횟수를 배열에 담아 출력해주세요.
		
		
//		int[] ax = new int[10];
//				
//		for(int i = 0; i < 500; i++) {
//			int a = (int)(Math.random() * 10/*ax.length*/);
//			ax[a] += 1;
//		}
//		
//		System.out.println(Arrays.toString(ax));
		
		
		// 위 문제의 랜덤한 숫자의 (최소값, 최대값, 반복횟수)를 입력받아 각 숫자가 생성된 횟수를 출력해주세요.
		
		Scanner s = new Scanner(System.in);
		System.out.println("랜덤숫자의 최소값을 입력 해주세요.");
		int ranMin = Integer.parseInt(s.nextLine()); 
		System.out.println("랜덤숫자의 최대값을 입력 해주세요.");
		int ranMax = Integer.parseInt(s.nextLine());
		System.out.println("랜덤숫자의 생성 횟수를 입력 해주세요.");
		int ranNum = Integer.parseInt(s.nextLine());
		
		int[] ax = new int[ranMax];
		
		for(int i = 0; i < ranNum; i++) {
			int a = (int)(Math.random() * ranMax);
			ax[a] += 1;
		}

		System.out.println(Arrays.toString(ax));
		
		
		
		

			
		
		
		
		
		

	}

}
