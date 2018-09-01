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
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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

                //As file
//                URL loc = this.class.getclassLoader().getResource("250.csv");
//                File f = new File(loc.getPath());
//                //As Stream
//                InputStream loc = this.class.getclassLoader().getResourceAsStream("250.csv");
//                InputStreamReader in = new InputStreamReader(loc);

                String home = System.getProperty("user.home");
                String FILE_NAME = home + "/test.pdf";
                try {
                    Document document = new Document(PageSize.A4);
                    PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));
                    document.open();

                    Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
                    Chunk chunk = new Chunk("Hello World", font);
                    document.add(chunk);
                    document.close();

                } catch (Exception ex) {
                    System.out.println(ex);
                }

            }
        }
        );

        content.addComponent(loginBtn);
        printLayout.addComponents(content);

        return printLayout;
    }
}
