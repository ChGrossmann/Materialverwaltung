/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.teko.pa4.materialverwaltung.ui;

import ch.teko.pa4.materialverwaltung.dao.MaterialverwaltungDao;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.VerticalLayout;
import ch.teko.pa4.materialverwaltung.beans.Article;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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

                List<Article> searchArticleList = new ArrayList<>();
                MaterialverwaltungDao dao = new MaterialverwaltungDao();
                searchArticleList = dao.searchArticle();

                String tempDir = System.getProperty("java.io.tmpdir");
                String FILE_NAME = tempDir + "/test.pdf";
                try {

                    Document document = new Document(PageSize.A4.rotate(), 5, 5, 5, 5);
                    PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));
                    document.open();
                    document.leftMargin();

                    PdfPTable table = new PdfPTable(16);
                    table.setWidthPercentage(100);

                    Font fTitle = new Font(FontFamily.COURIER, 8, Font.BOLD, GrayColor.BLACK);

                    table.addCell(createFontCell("Bahn",fTitle));
                    table.addCell(createFontCell("Linie",fTitle));
                    table.addCell(createFontCell("Station",fTitle));
                    table.addCell(createFontCell("System1",fTitle));
                    table.addCell(createFontCell("System2",fTitle));
                    table.addCell(createFontCell("System3",fTitle));
                    table.addCell(createFontCell("Bezeichnung",fTitle));
                    table.addCell(createFontCell("Typ",fTitle));
                    table.addCell(createFontCell("Beschreibung",fTitle));              
                    table.addCell(createFontCell("Artikelnr.",fTitle));
                    table.addCell(createFontCell("Anzahl",fTitle));
                    table.addCell(createFontCell("Gestell",fTitle));
                    table.addCell(createFontCell("Schiene",fTitle));
                    table.addCell(createFontCell("Schrank",fTitle));
                    table.addCell(createFontCell("Tablar",fTitle));
                    table.addCell(createFontCell("Box",fTitle));

                    Font fText = new Font(FontFamily.COURIER, 6, Font.NORMAL, GrayColor.BLACK);
                    for (Article p : searchArticleList) {

                        table.addCell(createFontCell(p.getBahn(),fText));
                        table.addCell(createFontCell(p.getLinie(),fText));
                        table.addCell(createFontCell(p.getStation(),fText));
                        table.addCell(createFontCell(p.getSystem1(),fText));
                        table.addCell(createFontCell(p.getSystem2(),fText));
                        table.addCell(createFontCell(p.getSystem3(),fText));
                        table.addCell(createFontCell(p.getBezeichnung(),fText));
                        table.addCell(createFontCell(p.getTyp(),fText));
                        table.addCell(createFontCell(p.getBeschreibung(),fText));
                        table.addCell(createFontCell(p.getArtNr(),fText));
                        table.addCell(createFontCell(String.valueOf(p.getAnzahl()),fText));
                        table.addCell(createFontCell(String.valueOf(p.getGestell()),fText));
                        table.addCell(createFontCell(String.valueOf(p.getSchiene()),fText));
                        table.addCell(createFontCell(String.valueOf(p.getSchrank()),fText));
                        table.addCell(createFontCell(String.valueOf(p.getTablar()),fText));
                        table.addCell(createFontCell(String.valueOf(p.getBox()),fText));
                    }

                    document.add(table);
                    document.close();

                    File myFile = new File(FILE_NAME);
                    Desktop.getDesktop().open(myFile);

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

    public PdfPCell createFontCell(String title, Font f) {
        PdfPCell cell = new PdfPCell(new Phrase(title, f));
        return cell;
    }
}
