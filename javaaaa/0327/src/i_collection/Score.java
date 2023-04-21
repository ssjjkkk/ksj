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
		System.out.println(names);
		System.out.println(subjects);
		System.out.println(names_sum);
		System.out.println(names_avg);
		System.out.println(rank);		
		

	}

}
