package pdfbox_sample.test;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;

public class PDFBox_Encrypting {

	public static void main(String[] args) throws IOException {
		
		// StandardProtectionPolicy, AccessPermission 클래스를 사용하여 PDF 문서를 암호화할 수 있다.
		// AccessPermission 클래스는 액세스 권한을 할당하여 PDF 문서를 보호하는 데 사용된다.
		
		File file = new File("c:/others/TEST1.pdf");
		PDDocument testDocument = PDDocument.load(file);
		
		// AccessPermission 클래스
		// 엑세스 권한을 할당하여 PDF문서를 보호
		// 문서 인쇄
		// 문서 내용 수정
		// 문서 내용 복사 또는 추출
		// 주석 추가 또는 수정
		// 대화형 양식 필드 채우기
		// 시각 장애인의 접근성을 위해 텍스트 및 그래픽 추출
		// 문서 취합
		// 품질 저하로 인쇄 등을 수행하지 못하도록 제한할 수 있다.
		AccessPermission ap = new AccessPermission(); 	// 클래스 인스턴스화
		
		// StandardProtectionPolicy 클래스는 문서에 암호 기반 보호를 추가한다.
		StandardProtectionPolicy spp = new StandardProtectionPolicy("1523", "1523", ap);
		// 오너암호, 사용자암호, AccessPermission객체를 전달
		
		spp.setEncryptionKeyLength(128);	// 암호화 키 길이 설정
		
		spp.setPermissions(ap);				// 권한 설정
		
		testDocument.protect(spp);			// 문서 보호
		
		testDocument.save("c:/others/TEST1.pdf");
		testDocument.close();
		
		
		
		
	}

}
