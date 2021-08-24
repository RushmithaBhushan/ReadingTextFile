package com.example.springboot.web;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class ReadingFile {

	public static void main(String[] args) {
		
		try {
			File f = new File("C:\\Users\\rushm\\eclipse-workspace\\reading-writing-textfile\\src\\main\\resources\\sampleText");
			BufferedReader sc = new BufferedReader(new FileReader(f));
			StringBuffer sb = new StringBuffer();
			String line;  
			while((line=sc.readLine())!=null)  
			{  
			sb.append(line);    
			sb.append("\n");      
			}  
			sc.close(); 
			Document doc = new Document();
			try {
				PdfWriter.getInstance(doc, new FileOutputStream("samplePdf.pdf"));
				doc.open();
				Paragraph c = new Paragraph(sb.toString());
				doc.add(c);
				doc.close();
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
