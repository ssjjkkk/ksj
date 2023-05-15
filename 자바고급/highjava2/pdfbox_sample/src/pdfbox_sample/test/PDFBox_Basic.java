package pdfbox_sample.test;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.print.attribute.standard.DocumentName;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDDictionaryWrapper;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class PDFBox_Basic {
	
	public static void main(String arg[]) throws IOException {
		PDDocument testDocument = new PDDocument();	// PDDocument클래스를 이용 PDF문서 개체 생성
		
		testDocument.save("C:/others/TEST1.pdf");	// 지정한 경로에 문서 저장 save()메서드 이용
													// 파일이름이 같을시 덮어씌어짐. 파일명 조심
		System.out.println("PDF파일이 만들어졌습니다.");
		
		File file = new File("c:/others/TEST1.pdf");	// File 개체를 이용	
		testDocument = PDDocument.load(file);		// load()메서드 이용 문서 로드 (File 객체를 매개변수로 사용)
													// (정적 메서드로 클래스이름으로 사용 가능)
		System.out.println("PDF loaded");
		
		// 페이지가 없을 경우(빈 문서) PDF문서를 열 때 오류가 난다.
		
		PDPage testPage = new PDPage();				// PDPage클래스를 이용 빈 페이지 만들기
		
		// 문서에 만든 페이지를 추가해야 한다.
		testDocument.addPage(testPage);				// addPage()메서드 이용 문서에 페이지 추가
													// ==> PDPage 객체를 매개변수로 전달
		testDocument.addPage(testPage);
		
		testDocument.save(file);					// 저장. save()메서드에 파일 객체 담기 가능
		
		System.out.println("PDF파일이 수정되었습니다.");
		
		testDocument.close(); 						// PDF문서 객체 닫기
		
		// 페이지제거 ==> 페이지 제거를 위해 페이지의 수를 알아야 한다.
		testDocument = PDDocument.load(file);		// 기존 문서 로드
		System.out.println("PDF loaded");
		
		int numOfPages = testDocument.getNumberOfPages();	// getNumberOfPages() PDF문서 페이지를 반환
		System.out.println(numOfPages);
		
		testDocument.removePage(0);	// removePage()메서드이용 삭제할 페이지의 인덱스를 입력 (인덱스는 0부터 시작)
									// 마지막 페이지를 삭제하려면 numOfpages-1
		testDocument.save(file);
		
		System.out.println("PDF파일 페이지 삭제");
		
		testDocument.close();
		
		// PDF 파일 속성 설정, 검색
		testDocument = PDDocument.load(file);
		// PDDocumentInformation 객체 생성 (PDF파일의 속성을 get, set 할 수 있다.)
		PDDocumentInformation PDDInfo = testDocument.getDocumentInformation();
		
		PDDInfo.setAuthor("테스트");					// 문서의 작성자를 설정
		System.out.println(PDDInfo.getAuthor());	// 작성자를 반환
		
		PDDInfo.setTitle("제목테스트");					// 제목 설정
		System.out.println(PDDInfo.getTitle());		// 제목 반환
		
		PDDInfo.setCreator("테스트생성자");				// 생성자 설정
		System.out.println(PDDInfo.getCreator());	// 생성자 반환
		
		PDDInfo.setSubject("테스트주제");				// 주제 설정
		System.out.println(PDDInfo.getSubject());	// 주제 반환
		
		// setCreationDate 생성날짜에는 날짜 데이터를 파라미터로 받는다.
		Calendar date = new GregorianCalendar();	// 날짜 데이터 생성 (그레고리언 달령형)
		date.set(2023, 05, 12);
		
		PDDInfo.setCreationDate(date);				// 생성일자 설정		
		System.out.println(PDDInfo.getCreationDate()); // 생성일자 반환
		date.set(2023, 01, 01);
		PDDInfo.setModificationDate(date);			// 생성일자 수정
		System.out.println("수정 후 : " + PDDInfo.getCreationDate());
		
		PDDInfo.setKeywords("테스트키워드");			// 키워드 설정
		System.out.println(PDDInfo.getKeywords()); 	// 키워드 출력
		
		System.out.println("문서속성 설정 완료");
		
		testDocument.save(file);
		testDocument.close();
		
		// 문서에 텍스트 추가하기
		testDocument = PDDocument.load(file);
		PDPage page = testDocument.getPage(0);		// getPage()메서드를 사용하여 페이지 가져오기
		PDPageContentStream contentStream = new PDPageContentStream(testDocument, page);
		// PDPageContentStream 클래스를 이용하여 다양한 종류의 데이터요소 삽입 가능, pdf문서와 페이지의 객체를 전달
		
		// 텍스트입력의 시작,끝 점 안에서 텍스트위 위치 및 글꼴 등을 설정 후 텍스트를 삽입한다.
		contentStream.beginText(); 				// 텍스트 입력의 시작점
		
		contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);	// 폰트타입과 사이즈를 설정
		contentStream.newLineAtOffset(25, 500);		 		// 페이지의 콘텐츠 스트림 위치를 설정 (어디부터 쓰여질지)
		
		String text = "TEST PDF BOX BOX BOX BOX BOX BOX BOX BOX BOX BOX BOX BOX BOX BOX BOX BOX BOX"; // 추가할 문자열
		contentStream.showText(text); 			// 텍스트 삽입 (문자열 형식만 가능)
		
		contentStream.endText();				// 텍스트 입력의 끝
		
		System.out.println("문자 입력완료");
		
		contentStream.close(); 					// 컨텐츠스트림 닫기
		testDocument.save(file);
		testDocument.close();
		
		// 위의 방식으로 텍스트를 추가하면  PDF문서에서 1줄을 초과하면 뒤의 내용은 나오지 않는다.
		// 여러 줄을 추가하려면 setLeading()메서드를 사용하여 행간을 설정하고 각 줄을 마친 후
		// newline() 메서드를 사용하여 새 줄로 이동해야 한다.
		testDocument = PDDocument.load(file);
		PDPage page2 = testDocument.getPage(0);
		PDPageContentStream contentStream2 = new PDPageContentStream(testDocument, page2);
		
		contentStream2.beginText(); 				// 텍스트 입력의 시작점
		
		contentStream2.setFont(PDType1Font.TIMES_ROMAN, 12);	// 폰트타입과 사이즈를 설정
		contentStream2.newLineAtOffset(25, 500);		 		// 페이지의 콘텐츠 스트림 위치를 설정 (어디부터 쓰여질지)
		
		String text2 = "TEST TEST TEST TEST TEST TEST TEST TEST"; // 추가할 문자열
		String text3 = "PDF PDF PDF PDF PDF PDF PDF PDF PDF PDF PDF";
		String text4 = "O O O O O O O O O O O O O O O O O O O O O O";
		
		contentStream2.setLeading(14.5f); 		// 텍스트의 행간을 설정
		contentStream2.showText(text2); 			// 텍스트 삽입 (문자열 형식만 가능)
		contentStream2.newLine(); 				// 줄 바꿈
		contentStream2.showText(text3);
		contentStream2.newLine();
		contentStream2.showText(text4);
		contentStream2.newLine();
				
		contentStream2.endText();				// 텍스트 입력의 끝
		
		System.out.println("문자 여러줄 입력완료");
		
		contentStream2.close(); 					// 컨텐츠스트림 닫기
	
		testDocument.save(file);
		testDocument.close();
		
	}
	
}
