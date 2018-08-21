/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.teko.pa4.materialverwaltung.ui;

import ch.teko.pa4.materialverwaltung.beans.Article;
import ch.teko.pa4.materialverwaltung.dao.MaterialverwaltungDao;
import com.vaadin.server.Page;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author ch.grossmann
 */
public class EditTab {

    public Component editTab() {

        final VerticalLayout editLayout = new VerticalLayout();

        final GridLayout editArticleLayout = new GridLayout(2, 18);

        Label bahnLab = new Label("Bahn");
        TextField bahnTxt = new TextField("");
        Label linieLab = new Label("Linie");
        TextField linieTxt = new TextField("");
        Label stationLab = new Label("Station");
        TextField stationTxt = new TextField("");
        Label system1Lab = new Label("System I");
        TextField system1Txt = new TextField("");
        Label system2Lab = new Label("System II");
        TextField system2Txt = new TextField("");
        Label system3Lab = new Label("System III");
        TextField system3Txt = new TextField("");
        Label bezeichnungLab = new Label("Bezeichnung");
        TextField bezeichnungTxt = new TextField("");
        Label typLab = new Label("Typ");
        TextField typTxt = new TextField("");
        Label beschreibungLab = new Label("Beschreibung");
        TextField beschreibungTxt = new TextField("");
        Label artikelNrLab = new Label("Art. Nr.");
        TextField artikelNrTxt = new TextField("");
        Label anzahlLab = new Label("Anzahl");
        TextField anzahlTxt = new TextField("");
        Label gestellLab = new Label("Gestell");
        TextField gestellTxt = new TextField("");
        Label schieneLab = new Label("Schiene");
        TextField schieneTxt = new TextField("");
        Label schrankLab = new Label("Schrank");
        TextField schrankTxt = new TextField("");
        Label tablarLab = new Label("Tablar");
        TextField tablarTxt = new TextField("");
        Label boxLab = new Label("Box");
        TextField boxTxt = new TextField("");
        Label bemerkungLab = new Label("Bemerkung");
        TextField bemerkungTxt = new TextField("");

        editArticleLayout.addComponent(bahnLab, 0, 1);
        editArticleLayout.addComponent(bahnTxt, 1, 1);
        editArticleLayout.addComponent(linieLab, 0, 2);
        editArticleLayout.addComponent(linieTxt, 1, 2);
        editArticleLayout.addComponent(stationLab, 0, 3);
        editArticleLayout.addComponent(stationTxt, 1, 3);
        editArticleLayout.addComponent(system1Lab, 0, 4);
        editArticleLayout.addComponent(system1Txt, 1, 4);
        editArticleLayout.addComponent(system2Lab, 0, 5);
        editArticleLayout.addComponent(system2Txt, 1, 5);
        editArticleLayout.addComponent(system3Lab, 0, 6);
        editArticleLayout.addComponent(system3Txt, 1, 6);
        editArticleLayout.addComponent(bezeichnungLab, 0, 7);
        editArticleLayout.addComponent(bezeichnungTxt, 1, 7);
        editArticleLayout.addComponent(typLab, 0, 8);
        editArticleLayout.addComponent(typTxt, 1, 8);
        editArticleLayout.addComponent(beschreibungLab, 0, 9);
        editArticleLayout.addComponent(beschreibungTxt, 1, 9);
        editArticleLayout.addComponent(artikelNrLab, 0, 10);
        editArticleLayout.addComponent(artikelNrTxt, 1, 10);
        editArticleLayout.addComponent(anzahlLab, 0, 11);
        editArticleLayout.addComponent(anzahlTxt, 1, 11);
        editArticleLayout.addComponent(gestellLab, 0, 12);
        editArticleLayout.addComponent(gestellTxt, 1, 12);
        editArticleLayout.addComponent(schieneLab, 0, 13);
        editArticleLayout.addComponent(schieneTxt, 1, 13);
        editArticleLayout.addComponent(schrankLab, 0, 14);
        editArticleLayout.addComponent(schrankTxt, 1, 14);
        editArticleLayout.addComponent(tablarLab, 0, 15);
        editArticleLayout.addComponent(tablarTxt, 1, 15);
        editArticleLayout.addComponent(boxLab, 0, 16);
        editArticleLayout.addComponent(boxTxt, 1, 16);
        editArticleLayout.addComponent(bemerkungLab, 0, 17);
        editArticleLayout.addComponent(bemerkungTxt, 1, 17);

        final HorizontalLayout submitLayout = new HorizontalLayout();

        Button editBtn = new Button("Ändern", (editArticleEvent) -> {
            Article editArticle = new Article();
            MaterialverwaltungDao dao = new MaterialverwaltungDao();

            editArticle.setBahn(bahnTxt.getValue());
            editArticle.setLinie(linieTxt.getValue());
            editArticle.setStation(stationTxt.getValue());
            editArticle.setSystem1(system1Txt.getValue());
            editArticle.setSystem2(system2Txt.getValue());
            editArticle.setSystem3(system3Txt.getValue());
            editArticle.setBezeichnung(bezeichnungTxt.getValue());
            editArticle.setTyp(typTxt.getValue());
            editArticle.setBeschreibung(beschreibungTxt.getValue());
            editArticle.setArtNr(artikelNrTxt.getValue());
            editArticle.setAnzahl(Integer.parseInt(anzahlTxt.getValue()));
            editArticle.setGestell(gestellTxt.getValue());
            editArticle.setSchiene(Integer.parseInt(schieneTxt.getValue()));
            editArticle.setSchrank(schrankTxt.getValue());
            editArticle.setTablar(Integer.parseInt(tablarTxt.getValue()));
            editArticle.setBox(Integer.parseInt(boxTxt.getValue()));
            editArticle.setBemerkung(bemerkungTxt.getValue());

            dao.addArticle(editArticle);
            
            Notification notif = new Notification("Artikel wurde hinzugefügt.");
            notif.setDelayMsec(2000);
            notif.show(Page.getCurrent());

            
            bahnTxt.clear();
            linieTxt.clear();
            stationTxt.clear();
            system1Txt.clear();
            system2Txt.clear();
            system3Txt.clear();
            bezeichnungTxt.clear();
            typTxt.clear();
            beschreibungTxt.clear();
            artikelNrTxt.clear();
            anzahlTxt.clear();
            gestellTxt.clear();
            schieneTxt.clear();
            schrankTxt.clear();
            tablarTxt.clear();
            boxTxt.clear();
            bemerkungTxt.clear();
            
        });

        submitLayout.addComponent(editBtn);

        editLayout.addComponents(editArticleLayout, submitLayout);

        return editLayout;
    }

}
