package pdfbox_sample.test;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFBox_Read {

	public static void main(String[] args) throws IOException {
		
		File file = new File("c:/others/TEST1.pdf");
		PDDocument testDocument = PDDocument.load(file);
		
		// PDF문서에서 텍스트 추출
		// PDFBOX의 주요 기능. PDFTextStripper 클래스의 getText()메서드를 이용하여 모든 텍스트 추출 가능
		
		PDFTextStripper pdfStriper = new PDFTextStripper();	// 인스턴스화
		String text = pdfStriper.getText(testDocument);		// PDF문서 페이지내용 검색, 텍스트를 String 객체형식으로 반환
		
		System.out.println(text);
		
		testDocument.close();

	}

}
