package i_collection;

import java.util.ArrayList;

public class Score {

	public static void main(String[] args) {
		
		// 학생 이름
		ArrayList<String> names = new ArrayList<>();
		names.add("관리자");
		names.add("운영자");
		names.add("개발자");
		names.add("사용자");
		names.add("이용자");
		
		// 과목명
		ArrayList<String> subjects = new ArrayList<>();
		subjects.add("국어");
		subjects.add("영어");
		subjects.add("수학");
		subjects.add("사회");
		subjects.add("과학");
		subjects.add("Java");
		subjects.add("Oracle");
		
		// 점수 난수 발생
		ArrayList<ArrayList<Integer>> scores = new ArrayList<>();
		for(int i = 0; i < names.size(); i++) {
			ArrayList<Integer> score = new ArrayList<>();
			for(int j = 0; j < subjects.size(); j++) {
				score.add((int)(Math.random() * 101));
			}
			scores.add(score);
		}
		
		// 학생별 합계, 평균
		ArrayList<Integer> names_sum = new ArrayList<>();
		ArrayList<Double> names_avg = new ArrayList<>();
		for(int i = 0; i < names.size(); i++) {
			int sum = 0;
			for(int j = 0; j < subjects.size(); j++) {
				sum += scores.get(i).get(j);
			}
			names_sum.add(sum);
			names_avg.add(Math.round((double)sum/subjects.size() * 100) / 100d);
		}

		// 석차
		ArrayList<Integer> rank = new ArrayList<>();
		for(int i = 0; i < names.size(); i++) {
			rank.add(1);
			for(int j = 0; j < names.size(); j++) {
				if(names_sum.get(i) < names_sum.get(j)) {
					rank.set(i, rank.get(i) + 1);
				}
			}
		}
		System.out.println(names);
		System.out.println(subjects);
		System.out.println(names_sum);
		System.out.println(names_avg);
		System.out.println(rank);
		
		// 정렬부
		int temp = 0;
		String temp1 = "";
		double temp2 = 0;
		ArrayList<ArrayList<Integer>> temps = new ArrayList<>();
		ArrayList<Integer> temp3 = new ArrayList<>();
//		ArrayList<Double> temp4 = new ArrayList<>();
//		ArrayList<String> temp5 = new ArrayList<>();
		for(int i = 0; i < names.size() - 1; i++) {
			int min = i;
			for(int j = i + 1; j < names.size(); j++) {
				if(names_sum.get(j) > names_sum.get(min)) {
					min = j;
				}
			}
			temp1 = names.get(i);
			names.set(i, names.get(min));
			names.set(min, temp1);
			
			temp = names_sum.get(i);
			names_sum.set(i, names_sum.get(min));
			names_sum.set(min, temp);
			
			temp2 = names_avg.get(i);
			names_avg.set(i, names_avg.get(min));
			names_avg.set(min, temp2);
			
			temp = rank.get(i);
			rank.set(i, rank.get(min));
			rank.set(min, temp);
		}
		
		// 목차 출력부
		for(int i = 0; i < subjects.size(); i++) {
			System.out.print("\t" + subjects.get(i));
		}
		System.out.print("\t합계\t평균\t석차\n");
		// 이름 , 점수 출력부
		for(int i = 0; i < names.size(); i++) {
			System.out.print(names.get(i) + "\t");
			for(int j = 0; j < subjects.size(); j ++) {
				System.out.print(scores.get(i).get(j) + "\t");
			}
			System.out.println(names_sum.get(i) + "\t" + names_avg.get(i) + "\t" + rank.get(i));
		}
		// 과목 합계, 평균 리스트 생성
		ArrayList<Integer> sub_sum = new ArrayList<>();
		ArrayList<Double> sub_avg = new ArrayList<>();
		for(int i = 0; i < subjects.size(); i ++) {
			int sum = 0;
			double avg = 0;
			for(int j = 0; j < names.size(); j ++) {
				sum += scores.get(j).get(i);
			}
			sub_sum.add(sum);
			avg = Math.round((double)sum/names.size() * 100) / 100d;
			sub_avg.add(avg);
		}
		
		// 과목 합계, 평균 출력부
		System.out.print("과목합계\t");
		for(int i = 0; i < subjects.size(); i++) {
			System.out.print(sub_sum.get(i) + "\t");
		}
		System.out.println("");
		System.out.print("과목평균\t");
		for(int i = 0; i < subjects.size(); i++) {
			System.out.print(sub_avg.get(i) + "\t");
		}
		
		
		
		
		System.out.println("");
		System.out.println("");
		System.out.println(names);
		System.out.println(subjects);
		System.out.println(names_sum);
		System.out.println(names_avg);
		System.out.println(rank);		
		

	}

}
