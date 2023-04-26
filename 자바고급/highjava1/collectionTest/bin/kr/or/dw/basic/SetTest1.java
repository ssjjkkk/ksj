package kr.or.dw.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SetTest1 {

	private static class Phone {
		String name, address, phoneNumber;
		int age;

		public Phone(String name, String address, int age, String phoneNumber) {
			this.name = name;
			this.address = address;
			this.age = age;
			this.phoneNumber = phoneNumber;
		}

		@Override
		public String toString() {
			return String.format("%s\t%s\t%s\t%s", name, phoneNumber, age, address);
		}
	}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Phone> phoneBook = new HashMap<>();

        while (true) {
            System.out.println("다음 메뉴를 선택하세요.\n1. 전화번호 등록\n2. 전화번호 수정\n3. 전화번호 삭제\n4. 전화번호 검색\n5. 전화번호 전체 출력\n0. 프로그램 종료\n----------------");
            System.out.print("번호입력 >> ");

            int menu = sc.nextInt();

            switch (menu) {
                case 1:
                    System.out.println("\n새롭게 등록할 전화번호 정보를 입력하세요.\n이름 >> ");
                    String name = sc.next();
                    System.out.print("전화번호 >> ");
                    String phoneNumber = sc.next();
                    System.out.print("나이 >> ");
                    int age = sc.nextInt();
                    System.out.print("주소 >> ");
                    String address = sc.next();

                    if (phoneBook.containsKey(name)) {
                        System.out.println("'" + name + "'은 이미 등록된 사람입니다.");
                    } else {
                        phoneBook.put(name, new Phone(name, address, age, phoneNumber));
                        System.out.println("'" + name + "' 전화번호 등록 완료!!");
                    }
                    break;

    case 2:
        System.out.println("전화번호를 수정할 사람의 이름을 입력하세요.\n이름 >> ");
        name = sc.next();

        if (phoneBook.containsKey(name)) {
            System.out.println("'" + name + "'님의 수정할 전화번호 정보를 입력하세요.\n전화번호 >> ");
            phoneNumber = sc.next();
            System.out.print("나이 >> ");
            age = sc.nextInt();
            System.out.print("주소 >> ");
            address = sc.next();

            phoneBook.put(name, new Phone(name, address, age, phoneNumber));
            System.out.println("'" + name + "'님의 전화번호 수정 완료!!");
        } else {
            System.out.println("'" + name + "'님은 등록되어 있지 않습니다.");
        }
        break;

    case 3:
        System.out.println("전화번호를 삭제할 사람의 이름을 입력하세요.\n이름 >> ");
        name = sc.next();

        if (phoneBook.containsKey(name)) {
            phoneBook.remove(name);
            System.out.println("'" + name + "'님의 전화번호 삭제 완료!!");
        } else {
            System.out.println("'" + name + "'님은 등록되어 있지 않습니다.");
        }
        break;

    case 4:
        System.out.println("\n전화번호를 검색할 사람의 이름을 입력하세요.\n이름 >> ");
        name = sc.next();

        if (phoneBook.containsKey(name)) {
            System.out.println("'" + name + "'님의 전화번호 정보입니다.\n" + phoneBook.get(name));
        } else {
            System.out.println("'" + name + "'님은 등록되어 있지 않습니다.");
        }
        break;

    case 5:
        System.out.println("\n전화번호부 전체 정보입니다.");
        phoneBook.forEach((key, value) -> System.out.println(value));
        break;

    case 0:
        System.out.println("프로그램을 종료합니다.");
        sc.close();
        System.exit(0);
        break;

    default:
        System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
        break;
            }
            
        }
    }
}