package g_exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Finally {

	public static void main(String[] args) {
		/*
		 * finally
		 * - 필요에 따라 try-catch 뒤에 finally를 추가할 수 있다.
		 * - finally 는 예외의 발생 여부와 상관없이 가장 마지막에 수행된다.
		 * 
		 * 자동 자원 반환
		 * - try(변수 선언;변수 선언) {} catch(Exception e) {}
		 * - 사용 후 반환이 필요한 객체를 try의 ()안에서 선언하면 try 블럭 종료시 자동으로 반환된다.
		 */
		
		FileInputStream fis = null;      // 파일 읽기
		
		try {
			fis = new FileInputStream("C:\\Users\\admin\\Documents\\file.txt");
			int data = 0;
			byte[] buf = new byte[fis.available()];
			
			while((data = fis.read(buf, 0, buf.length)) != -1) {    // 전체 읽기
				System.out.println(new String(buf, 0, data));
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			System.out.println("반드시 실행되는 finally 구문");
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// 예외 발생 : try -> catch -> finally
		// 예외 미발생 : try -> finally
		
		try(FileOutputStream fos = new FileOutputStream("C:\\Users\\admin\\Documents\\file.txt")) {
			String str = "아무노래나 일단 틀어";
			
			byte[] bytes = str.getBytes();
			
			for(int i = 0; i < bytes.length; i++) {
				fos.write(bytes[i]);
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		

	}

}
