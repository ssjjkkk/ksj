package d_array;

import java.util.Arrays;

public class Sort {

	public static void main(String[] args) {
		
		int[] arr = new int[10];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 100) + 1;
		}
		System.out.println("┏━━━━━━┓");
		System.out.println("┃정렬연습┃");
		System.out.println("┗━━━━━━┛");
		System.out.println(Arrays.toString(arr));
		
		// 석차구하기
		// 처음에는 다 1등으로 시작해서 비교
//		int[] arr2 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};	// 등수를 저장할 배열
//		for(int i = 0; i < arr.length; i++) {
//			for(int j = 0; j < arr.length; j++) {
//				if(arr[j] > arr[i]) arr2[i]++;
//			}
//		}
//		System.out.println(Arrays.toString(arr2));
		
		
		// 선택정렬
//		System.out.println("┏━━━━━━┓");
//		System.out.println("┃선택정렬┃");
//		System.out.println("┗━━━━━━┛");
//		int temp = 0;
//		for(int i = 0; i < arr.length-1; i++) {
//			int minIdx = i;
//			for(int j = i + 1; j < arr.length; j++) {
//				if(arr[j] < arr[minIdx]) {
//					minIdx = j;
//				}
//			}
//			temp = arr[i];
//			arr[i] = arr[minIdx];
//			arr[minIdx] = temp;
//			System.out.println(Arrays.toString(arr));
//		}
		
		// 삽입정렬
//		System.out.println("┏━━━━━━┓");
//		System.out.println("┃삽입정렬┃");
//		System.out.println("┗━━━━━━┛");
//		for(int i = 1; i < arr.length; i++) {
//			for(int j = i; j >= 1; j--) {	// 비교 횟수
//				if(arr[j] < arr[j - 1]) {
//					int tmp = arr[j];
//					arr[j] = arr[j - 1];
//					arr[j - 1] = tmp; 
//				}else {
//					break;
//				}
//			}
//			System.out.println(Arrays.toString(arr));
//		}
		
		// 버블정렬
		System.out.println("┏━━━━━━┓");
		System.out.println("┃버블정렬┃");
		System.out.println("┗━━━━━━┛");
		for(int i = 0; i < arr.length; i++) {
			boolean changed = false;
			for(int j = 0; j < arr.length - 1 - i; j++) {
				if(arr[j] > arr[j + 1]) {
					int tmp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = tmp;
					changed = true;
				}
			}
			if(!changed) break;
			System.out.println(Arrays.toString(arr));
		}

	}

}
