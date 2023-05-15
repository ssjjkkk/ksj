package pdfbox_sample.test;

import java.awt.Color;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class PDFBox_Table {
	
	public static void main(String[] args) throws IOException {
		PDDocument document = new PDDocument();
	    PDPage firstPage = new PDPage();
	    document.addPage(firstPage);
	    
	    int pageHeight = (int) firstPage.getTrimBox().getHeight();
	    int pageWidth = (int) firstPage.getTrimBox().getWidth();
	    PDPageContentStream contentStream = new PDPageContentStream(document, firstPage);
	    contentStream.setStrokingColor(Color.DARK_GRAY);
	    contentStream.setLineWidth(1);
	    
	    int initX = 50;
	    int initY = pageHeight-50;
	    
	    int cellHeight = 30;
	    int cellWidth = 100;
	    
	    int colCount = 5;
	    int rowCount = 10;
	    
	    for(int i = 1; i<=rowCount; i++) 
	    {
	    	for(int j=1; j<=colCount; j++)
	    	{
	    		contentStream.addRect(initX, initY, cellWidth, -cellHeight);
	    		
	    		contentStream.beginText();
	    		contentStream.newLineAtOffset(initX+10, initY-cellHeight+10);
	    		contentStream.setFont(PDType1Font.TIMES_ROMAN, 18);
	    		contentStream.showText("Hello");
	    		contentStream.endText();
	    		initX+=cellWidth;
	    	}
	    	initX = 50;
	    	initY -= cellHeight;
	    }
	     
	    contentStream.stroke();
	    contentStream.close();
	    
	    document.save("c:\\others\\myPDF.pdf");
	    document.close();
	    System.out.println("PDF Created");
	}
}
