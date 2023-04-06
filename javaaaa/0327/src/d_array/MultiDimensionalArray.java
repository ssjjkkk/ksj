package d_array;

import java.util.Arrays;

public class MultiDimensionalArray {

	public static void main(String[] args) {
		
		/*
		 * << 다차원 배열 >>
		 *  - 배열안에 배열이 저장되어 있는 형태이다.
		 */
		
		int[][] numbers = new int[2][3];	// 2칸짜리 배열안에 각 칸마다 3칸짜리 배열이 생성된다.
		int numbers2[][] = new int[][] { {1,2,3}, {4,5,6} };	// 값의 개수로 배열의 길이가 정해진다.
		
		int[][] numbers3 = new int[3][];	// 가변배열
		// numbers3 배열의 각각 인덱스에(0, 1, 2) 크기가 3, 4, 10 인 배열들을 생성해보세요.
		numbers3[0] = new int[3];	// numbers3 ==> { { , , } ,  ,  }
		numbers3[1] = new int[4];	// { { , , } , { , , , } ,  }
		numbers3[2] = new int[10];	// { { , , } , { , , , } , { , , , , , , , , , } }
		
//		numbers[0] = 10;	// 1차원에 값을 저장할 수 없다.
		numbers3[0][0] = 10;
		numbers3[0][1] = 20;
		numbers3[1][0] = 100;
		
//		System.out.println(Arrays.deepToString(numbers3));
		
		// numbers 배열에 1 ~ 100 의 숫자중 임의의 숫자를 저장해주세요.
		// numbers ==> 2x3 배열
		/*numbers[0][0];
		numbers[0][1];
		numbers[0][2];
		numbers[1][0];
		numbers[1][1];
		numbers[1][2];*/
		
//		for(int i = 0; i < numbers.length; i++) {
//			for(int j = 0; j < numbers[i].length; j++) {
//				numbers[i][j] = (int)(Math.random() * 100 + 1);
//			}
//		}
//		System.out.println(Arrays.deepToString(numbers));
		
		// 1차원의 길이는 3이고 2차원의 길이는 5인 배열을 만들고,
		// 모든 인덱스에 1 ~ 100 사이의 랜덤한 값을 저장하세요.
		// 그리고 2차원 배열에 들어간 값들의 합과 평균을 저장할 배열을 각각 만들어 출력해주세요.
		
		int[][] scores = new int[3][5];
		int[] sum = new int[scores.length];
		double[] avg = new double[scores.length];
		
		for(int i = 0; i < scores.length; i++) {
			for(int j = 0; j < scores[i].length; j++) {
				scores[i][j] = (int)(Math.random() * 100 + 1);
				sum[i] += scores[i][j];
			}
			avg[i] = sum[i]/(double)scores[i].length;
		}
		System.out.println("3X5 배열 : " + Arrays.deepToString(scores));
		System.out.println("합계 배열 : " + Arrays.toString(sum));
		System.out.println("평균 배열 : " + Arrays.toString(avg));
		
		
		

	}

}
