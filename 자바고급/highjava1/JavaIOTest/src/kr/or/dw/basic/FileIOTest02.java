package kr.or.dw.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOTest02 {

	public static void main(String[] args) {
		// 파일에 데이터를 출력하는 예제
		
		try {
			// 파일 출력용 스트림 객체 생성
			// 파일이 없으면 새로 만들고, 있으면 그 내용을 덮어쓰기 한다.
			File file = new File("C:\\Users\\admin\\Documents\\out.txt");
			FileOutputStream fout = new FileOutputStream(file);
			
			for(char ch = 'A'; ch <= 'Z'; ch++) {
				fout.write(ch);	// ch 변수의 데이터를 파일로 출력한다.
			}
			System.out.println("================ 출력 작업 완료 ================");
			
			fout.close();
			
			// 저장된 파일 내용을 읽어 출력하기
			FileInputStream fin = new FileInputStream(file);
			int c;
			System.out.println(file.getName() + " 파일에서 읽어온 내용 : ");
			while((c = fin.read()) != -1) {
				System.out.print((char)c);
			}
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
