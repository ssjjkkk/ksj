package kr.or.dw.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileIOTest01 {

	public static void main(String[] args) {
		try {
		// 파일 자료 읽기 예제
		
		// 읽어올 파일을 매개변수로 받는 FileInputStream 객체 생성
		
		// 방법1
		// FileInputStream fin = new FileInputStream("파일의 경로");
		
		// 방법2
			File file = new File("C:\\Users\\admin\\Documents\\file.txt");
			FileInputStream fin = new FileInputStream(file);
			InputStreamReader in = new InputStreamReader(fin, "utf-8"); 
			
			int c; // 읽어온 데이터를 저장할 변수
			
			while((c = in.read()) != -1) {
				System.out.print((char)c);
				
			}
			in.close();
			fin.close();
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("입출력 오류입니다.");
			e.printStackTrace();
		}
		
		
		
		

	}

}
