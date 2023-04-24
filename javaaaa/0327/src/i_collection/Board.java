package i_collection;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Board {

	public static void main(String[] args) {
		/*
		 * ArrayList와 HashMap을 사용해 게시판 테이블을 만들고,
		 * 조회, 등록, 수정, 삭제가 가능한 게시판을 만들어주세요.
		 * 글번호(PX), 글제목, 내용, 작성자, 날짜
		 */
		
		ArrayList<Integer> num = new ArrayList<>(); // 글번호
		ArrayList<HashMap<String, String>> table = new ArrayList<>();
		HashMap<String, String> boardWritting = new HashMap<>();
		int count = 0;
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd a hh:mm");
		String day = sdf.format(today);
		Scanner sc = new Scanner(System.in);
		
		
		board : while(true) {
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.println("번호\t제목\t작성자\t작성일");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			
			for(int i = 0; i < table.size(); i ++) {
//				System.out.print(num.get(i) + "\t");
				System.out.print(i+1 + "\t");
				if(table.get(i) != null) {
					System.out.print(table.get(i).get("제목") + "\t");
					System.out.print(table.get(i).get("작성자") + "\t");
					System.out.print(table.get(i).get("작성일"));
				}
				System.out.println();
			}
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.println("1. 조회\t2. 글작성\t3. 종료");
			
			int input = Integer.parseInt(sc.nextLine());
			switch (input) {
			// 조회 및 수정, 삭제부
			case 1:
				System.out.println("조회할 글의 번호를 입력하세요>");
				input = Integer.parseInt(sc.nextLine());
				if(table.get(0) == null) {
					System.out.println("조회할 글이 없습니다.");
				}else {
					System.out.println("조회내용 : " + table.get(input - 1).get("내용"));
					System.out.println("1. 수정\t2. 삭제\t3. 뒤로가기");
					int input2 = Integer.parseInt(sc.nextLine());
					// 수정부
					if (input2 == 1) {
						System.out.println("수정 전 내용 : " + table.get(input - 1).get("내용"));
						boardWritting.remove("내용");
						System.out.println("수정할 내용을 입력해주세요>");
						String modify = sc.nextLine();
						boardWritting.put("제목", table.get(input-1).get("제목"));
						boardWritting.put("내용", modify);
						boardWritting.put("작성자", table.get(input-1).get("작성자"));
						boardWritting.put("작성일", day);
						table.set(input - 1, boardWritting);
					}else if (input2 == 2) {
						ArrayList<HashMap<String, String>> temp = new ArrayList<>();
						System.out.println("현재 글을 삭제하시겠습니까? 1. 예\t2. 아니오");
						int input3 = Integer.parseInt(sc.nextLine());
						if (input3 == 1) {
							for(int i = input; i < table.size(); i++) {
								temp.add(table.get(i));
							}
							for(int i = table.size() - 1; i >= input -1; i--) {
								table.remove(i);
							}
							for(int i = 0; i < temp.size(); i++) {
								table.add(temp.get(i));
							}
							
						}else {
							break;
						}
					}else {
						break;
					}
				}
				break;
				
			//새 글 작성부
			case 2:
				System.out.println("제목을 입력하세요>");
				String inputStr = sc.nextLine();
				boardWritting.put("제목", inputStr);
				
				System.out.println("내용을 입력하세요>");
				inputStr = sc.nextLine();
				boardWritting.put("내용", inputStr);
				
				System.out.println("작성자를 입력하세요>");
				inputStr = sc.nextLine();
				boardWritting.put("작성자", inputStr);
				
				boardWritting.put("작성일", day);
				
				int before = table.size();
				table.add(boardWritting);
				int after = table.size();
				if (before != after) {
					count++;
				}
				num.add(count);
				System.out.println("글 작성을 완료했습니다.");
				boardWritting = new HashMap<>();
				break;
				
			case 3:
				System.out.println("게시판을 종료합니다.");
//				System.exit(3);
				break board;
				
			default:
				break;
			}
		}
		
		
		
		
		
		

	}

}
