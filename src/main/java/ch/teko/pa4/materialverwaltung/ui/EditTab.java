/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.teko.pa4.materialverwaltung.ui;

import ch.teko.pa4.materialverwaltung.beans.Article;
import ch.teko.pa4.materialverwaltung.dao.MaterialverwaltungDao;
import com.vaadin.server.Page;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author ch.grossmann
 */
public class EditTab {


    public Component editTab(String id, String setBahn, String setLinie, String setStation,
            String setSystem1, String setSystem2, String setSystem3, String setBezeichnung,
            String setTyp, String setBeschreibung, String setArtikelNr, int setAnzahl,
            String setGestell, int setSchiene, String setSchrank, int setTablar,
            int setBox, String setBemerkung) {

        Article oldArticle = new Article();

        oldArticle.setId(id);


        final VerticalLayout addLayout = new VerticalLayout();

        Label bahnLab = new Label("Bahn");
        bahnLab.setWidth(null);
        TextField bahnTxt = new TextField("");
        bahnTxt.setPlaceholder(setBahn);
        bahnTxt.setValue(setBahn);
        bahnTxt.setWidth(null);

        Label linieLab = new Label("Linie");
        linieLab.setWidth(null);
        TextField linieTxt = new TextField("");
        linieTxt.setPlaceholder(setLinie);
        linieTxt.setValue(setLinie);
        linieTxt.setWidth(null);

        Label stationLab = new Label("Station");
        stationLab.setWidth(null);
        TextField stationTxt = new TextField("");
        stationTxt.setPlaceholder(setStation);
        stationTxt.setValue(setStation);
        stationTxt.setWidth(null);

        Label system1Lab = new Label("System I");
        TextField system1Txt = new TextField("");
        system1Txt.setPlaceholder(setStation);
        system1Txt.setValue(setStation);

        Label system2Lab = new Label("System II");
        TextField system2Txt = new TextField("");
        system2Txt.setPlaceholder(setSystem2);
        system2Txt.setValue(setSystem2);

        Label system3Lab = new Label("System III");
        TextField system3Txt = new TextField("");
        system3Txt.setPlaceholder(setSystem3);
        system3Txt.setValue(setSystem3);

        Label bezeichnungLab = new Label("Bezeichnung");
        TextField bezeichnungTxt = new TextField("");
        bezeichnungTxt.setPlaceholder(setBezeichnung);
        bezeichnungTxt.setValue(setBezeichnung);

        Label typLab = new Label("Typ");
        TextField typTxt = new TextField("");
        typTxt.setPlaceholder(setTyp);
        typTxt.setValue(setTyp);

        Label beschreibungLab = new Label("Beschreibung");
        TextField beschreibungTxt = new TextField("");
        beschreibungTxt.setPlaceholder(setBeschreibung);
        beschreibungTxt.setValue(setBeschreibung);

        Label artikelNrLab = new Label("Art. Nr.");
        TextField artikelNrTxt = new TextField("");
        artikelNrTxt.setPlaceholder(setArtikelNr);
        artikelNrTxt.setValue(setArtikelNr);

        Label anzahlLab = new Label("Anzahl");
        TextField anzahlTxt = new TextField("");
        anzahlTxt.setPlaceholder(Integer.toString(setAnzahl));
        anzahlTxt.setValue(Integer.toString(setAnzahl));

        Label gestellLab = new Label("Gestell");
        TextField gestellTxt = new TextField("");
        gestellTxt.setPlaceholder(setGestell);
        gestellTxt.setValue(setGestell);

        Label schieneLab = new Label("Schiene");
        TextField schieneTxt = new TextField("");
        schieneTxt.setPlaceholder(Integer.toString(setSchiene));
        schieneTxt.setValue(Integer.toString(setSchiene));

        Label schrankLab = new Label("Schrank");
        TextField schrankTxt = new TextField("");
        schrankTxt.setPlaceholder(setSchrank);
        schrankTxt.setValue(setSchrank);

        Label tablarLab = new Label("Tablar");
        TextField tablarTxt = new TextField("");
        tablarTxt.setPlaceholder(Integer.toString(setTablar));
        tablarTxt.setValue(Integer.toString(setTablar));

        Label boxLab = new Label("Box");
        TextField boxTxt = new TextField("");
        boxTxt.setPlaceholder(Integer.toString(setBox));
        boxTxt.setValue(Integer.toString(setBox));

        Label bemerkungLab = new Label("Bemerkung");
        TextArea bemerkungTxt = new TextArea("");
        bemerkungTxt.setPlaceholder(setBemerkung);
        bemerkungTxt.setValue(setBemerkung);
        bemerkungTxt.setRows(3);
        bemerkungTxt.setWidth("350px");
        bemerkungTxt.setHeight("100px");

        final GridLayout box1 = new GridLayout(2, 3);

        box1.setWidth("350px");
        box1.setHeight("300px");
        box1.setMargin(true);
        box1.addComponent(bahnLab, 0, 0);
        box1.addComponent(bahnTxt, 1, 0);
        box1.addComponent(linieLab, 0, 1);
        box1.addComponent(linieTxt, 1, 1);
        box1.addComponent(stationLab, 0, 2);
        box1.addComponent(stationTxt, 1, 2);

        box1.setComponentAlignment(bahnLab, Alignment.MIDDLE_LEFT);
        box1.setComponentAlignment(linieLab, Alignment.MIDDLE_LEFT);
        box1.setComponentAlignment(stationLab, Alignment.MIDDLE_LEFT);

        box1.setStyleName("border");

        final GridLayout box2 = new GridLayout(2, 3);

        box2.setWidth("350px");
        box2.setHeight("300px");
        box2.setMargin(true);
        box2.addComponent(system1Lab, 0, 0);
        box2.addComponent(system1Txt, 1, 0);
        box2.addComponent(system2Lab, 0, 1);
        box2.addComponent(system2Txt, 1, 1);
        box2.addComponent(system3Lab, 0, 2);
        box2.addComponent(system3Txt, 1, 2);

        box2.setComponentAlignment(system1Lab, Alignment.MIDDLE_LEFT);
        box2.setComponentAlignment(system2Lab, Alignment.MIDDLE_LEFT);
        box2.setComponentAlignment(system3Lab, Alignment.MIDDLE_LEFT);

        box2.setStyleName("border");

        final GridLayout box3 = new GridLayout(2, 5);

        box3.setWidth("350px");
        box3.setHeight("500px");
        box3.setMargin(true);
        box3.addComponent(bezeichnungLab, 0, 0);
        box3.addComponent(bezeichnungTxt, 1, 0);
        box3.addComponent(typLab, 0, 1);
        box3.addComponent(typTxt, 1, 1);
        box3.addComponent(beschreibungLab, 0, 2);
        box3.addComponent(beschreibungTxt, 1, 2);
        box3.addComponent(artikelNrLab, 0, 3);
        box3.addComponent(artikelNrTxt, 1, 3);
        box3.addComponent(anzahlLab, 0, 4);
        box3.addComponent(anzahlTxt, 1, 4);

        box3.setComponentAlignment(bezeichnungLab, Alignment.MIDDLE_LEFT);
        box3.setComponentAlignment(typLab, Alignment.MIDDLE_LEFT);
        box3.setComponentAlignment(beschreibungLab, Alignment.MIDDLE_LEFT);
        box3.setComponentAlignment(artikelNrLab, Alignment.MIDDLE_LEFT);
        box3.setComponentAlignment(anzahlLab, Alignment.MIDDLE_LEFT);

        box3.setStyleName("border");

        final GridLayout box4 = new GridLayout(2, 5);

        box4.setWidth("350px");
        box4.setHeight("500px");
        box4.setMargin(true);
        box4.addComponent(gestellLab, 0, 0);
        box4.addComponent(gestellTxt, 1, 0);
        box4.addComponent(schieneLab, 0, 1);
        box4.addComponent(schieneTxt, 1, 1);
        box4.addComponent(schrankLab, 0, 2);
        box4.addComponent(schrankTxt, 1, 2);
        box4.addComponent(tablarLab, 0, 3);
        box4.addComponent(tablarTxt, 1, 3);
        box4.addComponent(boxLab, 0, 4);
        box4.addComponent(boxTxt, 1, 4);

        box4.setComponentAlignment(gestellLab, Alignment.MIDDLE_LEFT);
        box4.setComponentAlignment(schieneLab, Alignment.MIDDLE_LEFT);
        box4.setComponentAlignment(schrankLab, Alignment.MIDDLE_LEFT);
        box4.setComponentAlignment(tablarLab, Alignment.MIDDLE_LEFT);
        box4.setComponentAlignment(boxLab, Alignment.MIDDLE_LEFT);

        box4.setStyleName("border");

        final GridLayout box5 = new GridLayout(2, 1);

        box5.setWidth("720px");
        box5.setHeight("220px");
        box5.setMargin(true);
        box5.addComponent(bemerkungLab, 0, 0);
        box5.addComponent(bemerkungTxt, 1, 0);

        box5.setComponentAlignment(bemerkungLab, Alignment.MIDDLE_LEFT);
        box5.setComponentAlignment(bemerkungTxt, Alignment.TOP_CENTER);

        box5.setStyleName("border");

        Label lab1 = new Label(" ");
        lab1.setWidth("20px");
        Label lab2 = new Label(" ");
        lab2.setHeight("20px");
        Label lab3 = new Label(" ");
        lab3.setWidth("20px");
        Label lab4 = new Label(" ");
        lab4.setHeight("20px");

        final GridLayout editArticleLayout = new GridLayout(3, 5);

        editArticleLayout.addComponent(box1, 0, 0);
        editArticleLayout.addComponent(lab1, 1, 0);
        editArticleLayout.addComponent(box2, 2, 0);
        editArticleLayout.addComponent(lab2, 0, 1, 2, 1);
        editArticleLayout.addComponent(box3, 0, 2);
        editArticleLayout.addComponent(lab3, 1, 2);
        editArticleLayout.addComponent(box4, 2, 2);
        editArticleLayout.addComponent(lab4, 0, 3, 2, 3);
        editArticleLayout.addComponent(box5, 0, 4, 2, 4);

        final HorizontalLayout submitLayout = new HorizontalLayout();

        Button editBtn = new Button("Ändern", (addArticleEvent) -> {

            Article newArticle = new Article();
            MaterialverwaltungDao dao = new MaterialverwaltungDao();

            newArticle.setBahn(bahnTxt.getValue());
            newArticle.setLinie(linieTxt.getValue());
            newArticle.setStation(stationTxt.getValue());
            newArticle.setSystem1(system1Txt.getValue());
            newArticle.setSystem2(system2Txt.getValue());
            newArticle.setSystem3(system3Txt.getValue());
            newArticle.setBezeichnung(bezeichnungTxt.getValue());
            newArticle.setTyp(typTxt.getValue());
            newArticle.setBeschreibung(beschreibungTxt.getValue());
            newArticle.setArtNr(artikelNrTxt.getValue());
            newArticle.setAnzahl(Integer.parseInt(anzahlTxt.getValue()));
            newArticle.setGestell(gestellTxt.getValue());
            newArticle.setSchiene(Integer.parseInt(schieneTxt.getValue()));
            newArticle.setSchrank(schrankTxt.getValue());
            newArticle.setTablar(Integer.parseInt(tablarTxt.getValue()));
            newArticle.setBox(Integer.parseInt(boxTxt.getValue()));
            newArticle.setBemerkung(bemerkungTxt.getValue());

            dao.editArticle(oldArticle, newArticle);

            Notification notif = new Notification("Artikel wurde geändert.");
            notif.setDelayMsec(2000);
            notif.show(Page.getCurrent());

        });

        submitLayout.addComponent(editBtn);

        addLayout.addComponents(editArticleLayout, submitLayout);

        return addLayout;
    }

}
