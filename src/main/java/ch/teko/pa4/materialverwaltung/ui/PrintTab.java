/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.teko.pa4.materialverwaltung.ui;

import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.VerticalLayout;
import ch.teko.pa4.materialverwaltung.beans.Article;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ch.grossmann
 */
public class PrintTab {

    List<Article> searchArticleList = new ArrayList<>();

    public Component PrintTab() {

        final VerticalLayout printLayout = new VerticalLayout();

        FormLayout content = new FormLayout();

        Button loginBtn = new Button("Drucken");

        loginBtn.addClickListener(new Button.ClickListener() {
            private static final long serialVersionUID = 1L;

            @Override
            public void buttonClick(Button.ClickEvent event) {
//                MaterialverwaltungDao dao = new MaterialverwaltungDao();
//                Document newSearchDoc = new Document();
//                searchArticleList = dao.searchArticle();

                String tempDir = System.getProperty("java.io.tmpdir");
                String FILE_NAME = tempDir + "/test.pdf";
                try {
                    Document document = new Document(PageSize.A4);
                    PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));
                    document.open();

                    Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
                    Chunk chunk = new Chunk("Hello World", font);
                    document.add(chunk);
                    
                    
                    document.close();
                    
                    File myFile = new File(FILE_NAME);
                    Desktop.getDesktop().open(myFile);
                    
                    

                    
                    File pdfFile = new File(FILE_NAME);
                    Desktop.getDesktop().open(pdfFile);
                    //pdfFile.delete();
                    
                } catch (IOException ex) {
                    System.out.println("IOException: " + ex);
                } catch (DocumentException ex) {
                    System.out.println("DocumentException: " + ex);
                }

            }
        }
        );

        content.addComponent(loginBtn);
        printLayout.addComponents(content);

        return printLayout;
    }
}
