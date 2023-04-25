package i_collection;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Board_p {
	Scanner sc = new Scanner(System.in);
	
	ArrayList<HashMap<String, String>> table = new ArrayList<>();
	HashMap<String, String> post = new HashMap<>();
	Date today = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd a hh:mm");
	String day = sdf.format(today);
	int count = 0;
	
	public static void main(String[] args) {
		
		new Board_p().start();

	}

	
	void start() {
		boardP : while (true) {
			show();
			int input = Integer.parseInt(sc.nextLine());
			switch(input) {
			case 1 :
				boardCheck();
				break;
			case 2 :
				newPost();
				break;
			case 3 :
				System.out.println("게시판을 종료합니다.");
				break boardP;
			default :
				break;
			}
		}
	}
	
	
	private void newPost() {
		
		System.out.println("제목을 입력해 주세요.");
		String input = sc.nextLine();
		post.put("제목", input);
		
		System.out.println("내용을 입력해 주세요.");
		input = sc.nextLine();
		post.put("내용", input);
		
		System.out.println("작성자를 입력해 주세요.");
		input = sc.nextLine();
		post.put("작성자", input);
		
		post.put("작성일", day);
		
		count++;
		post.put("글번호", String.valueOf(count));
		
		table.add(post);
		post = new HashMap<>();
		System.out.println("글 작성을 완료하였습니다.");
	}


	private void boardCheck() {
		if(table.get(0) == null) {
			System.out.println("조회할 글이 없습니다.");
		}
		System.out.println("조회할 글을 선택해 주세요.");
		int input2 = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < table.size(); i++) {
			if(input2 == Integer.parseInt(table.get(i).get("글번호"))) {
				System.out.println("내용 : " + table.get(i).get("내용"));
				System.out.print("작성자 : " + table.get(i).get("작성자") + "\t");
				System.out.print("작성일 : " + table.get(i).get("작성일"));
			
				System.out.println("1. 수정\t2. 삭제\t3. 뒤로가기");
				int input1 = Integer.parseInt(sc.nextLine());
				switch(input1) {
				case 1 :
					System.out.println("수정 전 내용 : " + table.get(i).get("내용"));
					post.remove("내용");
					System.out.println("수정할 내용을 입력해주세요.");
					String modify = sc.nextLine();
					post.put("제목", table.get(i).get("제목"));
					post.put("내용", modify);
					post.put("작성자", table.get(i).get("작성자"));
					post.put("작성일", day);
					post.put("글번호", table.get(i).get("글번호"));
					table.set(i, post);
					post = new HashMap<>();
					System.out.println("수정이 완료 되었습니다.");
					break;
				case 2 :
					System.out.println("정말 삭제하시겠습니까?\t1. 삭제\t2. 뒤로가기");
					input1 = Integer.parseInt(sc.nextLine());
					if (input1 == 1) {
						table.remove(i);
					}else {
						break;
					}
					break;
				case 3 :
					break;
				default :
					break;
				}

			} 
		}
	}


	void show() {
		System.out.println("--------------------------------------------------------------------");
		System.out.println("글번호\t제목\t작성자\t작성일");
		System.out.println("--------------------------------------------------------------------");
		for(int i = 0; i < table.size(); i++) {
			System.out.print(table.get(i).get("글번호") + "\t");
			System.out.print(table.get(i).get("제목") + "\t");
			System.out.print(table.get(i).get("작성자") + "\t");
			System.out.print(table.get(i).get("작성일"));
			System.out.println();
		}
		System.out.println("--------------------------------------------------------------------");
		System.out.println("1. 글 조회\t2. 글 작성\t3. 종료");
		System.out.println("--------------------------------------------------------------------");
	}
	
	
	
}
