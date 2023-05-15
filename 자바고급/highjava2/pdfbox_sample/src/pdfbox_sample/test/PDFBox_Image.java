package pdfbox_sample.test;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class PDFBox_Image {

	public static void main(String[] args) throws IOException {
		
		// PDFBox 이미지 삽입
		// PDImageXObject, PDPageContentStream 클래스의 createFromFile(), drawImage() 메서드를 사용하여 이미지를 PDF 문서에 삽입할 수 있다 .
		
		File file = new File("c:/others/TEST1.pdf");
		PDDocument testDocument = PDDocument.load(file);
		
		PDPage page = testDocument.getPage(0);		// 페이지 선택
		
		// PDImageXObject는 이미지 삽입, 높이 설정, 너비 설정 등과 같은 이미지와 관련된 작업을 수행하는 메서드를 제공한다.
		// createFromFile() 메소드를 사용. 이미지의 경로와 이미지를 추가해야 하는 문서 개체를 전달.
		PDImageXObject pdImage = PDImageXObject.createFromFile("C:/ksj-main/img/test1.jpg", testDocument);
		
		PDPageContentStream contentStream = new PDPageContentStream(testDocument, page);	// 콘텐츠 스트림
		
		// 이미지객체, 너비, 높이 를 입력
		contentStream.drawImage(pdImage, 70, 250); // drawImage() 이미지 삽입 메서드
		
		contentStream.close();
		testDocument.save(file);
		testDocument.close();

	}

}
