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
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
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
//                MaterialverwaltungDao dao = new MaterialverwaltungDao();
//                Document newSearchDoc = new Document();
//                searchArticleList = dao.searchArticle();

                List<Article> searchArticleList = new ArrayList<>();
                MaterialverwaltungDao dao = new MaterialverwaltungDao();
                searchArticleList = dao.searchArticle();

                String tempDir = System.getProperty("java.io.tmpdir");
                String FILE_NAME = tempDir + "/test.pdf";
                try {

                    Document document = new Document(PageSize.A4.rotate(),5,5,5,5);
                    PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));
                    document.open();
                    document.leftMargin();

                    //Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
                    //PdfPTable table = new PdfPTable(searchArticleList.size());
                    PdfPTable table = new PdfPTable(17);

                    PdfPCell cell = new PdfPCell();
                    
                    cell.setPaddingTop(0f);
                    cell.setPaddingLeft(0f);

                    table.addCell("Bahn");
                    table.addCell("Linie");
                    table.addCell("Station");
                    table.addCell("System1");
                    table.addCell("System2");
                    table.addCell("System3");
                    table.addCell("Bezeichnung");
                    table.addCell("Typ");
                    table.addCell("Beschreibung");
                    table.addCell("Artikelnr.");
                    table.addCell("Anzahl");
                    table.addCell("Gestell");
                    table.addCell("Schiene");
                    table.addCell("Schrank");
                    table.addCell("Tablar");
                    table.addCell("Box");
                    //table.addCell("Bemerkung");

                    for (Article p : searchArticleList) {

                        //Chunk chunk = new Chunk(p.getLinie(), font);
                        //document.add(chunk);
                        table.addCell(p.getBahn());
                        table.addCell(p.getLinie());
                        table.addCell(p.getStation());
                        table.addCell(p.getSystem1());
                        table.addCell(p.getSystem2());
                        table.addCell(p.getSystem3());
                        table.addCell(p.getBezeichnung());
                        table.addCell(p.getTyp());
                        table.addCell(p.getBeschreibung());
                        table.addCell(p.getArtNr());
                        table.addCell(String.valueOf(p.getAnzahl()));
                        table.addCell(String.valueOf(p.getGestell()));
                        table.addCell(String.valueOf(p.getSchiene()));
                        table.addCell(String.valueOf(p.getSchrank()));
                        table.addCell(String.valueOf(p.getTablar()));
                        table.addCell(String.valueOf(p.getBox()));
                        //table.addCell(p.getBemerkung());
                    }
                    table.addCell(cell);
                    table.setComplete(true);
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
}
