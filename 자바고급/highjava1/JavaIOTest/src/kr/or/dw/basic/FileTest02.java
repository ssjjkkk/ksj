package kr.or.dw.basic;

import java.io.File;

public class FileTest02 {

	public static void main(String[] args) {
		File f1 = new File("C:/Users/admin/Documents/test.txt");
		System.out.println(f1.getName() + " 의 크기" + f1.length());
		System.out.println("path : " + f1.getPath());
		System.out.println("absolutePath : " + f1.getAbsolutePath());
		System.out.println();
		
		File f2 = new File(".");	// 현재 디렉토리
		System.out.println("path : " + f2.getPath());
		System.out.println("absolutePath : " + f2.getAbsolutePath());
		
		if(f1.isFile()) {
			System.out.println(f1.getName() + "은 파일입니다.");
		}else if(f1.isDirectory()) {
			System.out.println(f1.getName() + "은 디렉토리(폴더) 입니다.");
		}else {
			System.out.println(f1.getName() + "은 뭔가요...?!");
		}
		
		
	}

}
