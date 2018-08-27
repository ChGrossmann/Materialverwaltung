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
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author ch.grossmann
 */
public class SearchTab {

    List<Article> searchArticleList = new ArrayList<>();

    private String column;

    public Component searchTab() {

        final VerticalLayout searchLayout = new VerticalLayout();

        final HorizontalLayout filterLayout = new HorizontalLayout();
        final VerticalLayout contentLayout = new VerticalLayout();

        Button linieBtn = new Button("Linie", (searchEvent) -> {

            column = "linie";

        });

        Button stationBtn = new Button("Station", (searchEvent) -> {

            column = "station";

        });

        Button bezeichnungBtn = new Button("Bezeichnung", (searchEvent) -> {

            column = "bezeichnung";

        });

        Button typBtn = new Button("Typ", (searchEvent) -> {

            column = "typ";

        });

        Button beschreibungBtn = new Button("Beschreibung", (searchEvent) -> {

            column = "beschreibung";

        });
        Button artNrBtn = new Button("Artikelnummer", (searchEvent) -> {

            column = "artNr";

        });

        filterLayout.addComponents(linieBtn, stationBtn, bezeichnungBtn, typBtn, beschreibungBtn, artNrBtn);

        final HorizontalLayout textLayout = new HorizontalLayout();

        TextField searchField = new TextField("Suchtext");
        Button searchBtn = new Button("Suchen", (searchEvent) -> {

            /**
             * Das löscht das vorhergehende articleGrid
             */
            if (contentLayout.getComponentCount() != 0) {
                contentLayout.removeAllComponents();
            }

            MaterialverwaltungDao dao = new MaterialverwaltungDao();

            if (searchField.isEmpty()) {

                searchArticleList = dao.searchArticle();

            } else {

                Document newSearchDoc = new Document();

                newSearchDoc.append(column, searchField.getValue());

                searchArticleList = dao.searchArticle(newSearchDoc);

            }

            if (searchArticleList.isEmpty()) {
                Notification notif = new Notification("Es wurde kein entsprechender Artikel gefunden.");
                notif.setDelayMsec(3000);
                notif.show(Page.getCurrent());
            }
            Grid<Article> articleGrid = new Grid<>();
            articleGrid.setItems(searchArticleList);
            articleGrid.setSizeFull();
            articleGrid.addColumn(Article::getBahn).setCaption("Bahn");
            articleGrid.addColumn(Article::getLinie).setCaption("Linie");
            articleGrid.addColumn(Article::getStation).setCaption("Station");
            articleGrid.addColumn(Article::getSystem1).setCaption("System 1");
            articleGrid.addColumn(Article::getSystem2).setCaption("System 2");
            articleGrid.addColumn(Article::getSystem3).setCaption("System 3");
            articleGrid.addColumn(Article::getBezeichnung).setCaption("Bezeichnung");
            articleGrid.addColumn(Article::getTyp).setCaption("Typ");
            articleGrid.addColumn(Article::getBeschreibung).setCaption("Beschreibung");
            articleGrid.addColumn(Article::getArtNr).setCaption("Artikelnr.");
            articleGrid.addColumn(Article::getAnzahl).setCaption("Anzahl");
            articleGrid.addColumn(Article::getGestell).setCaption("Gestell");
            articleGrid.addColumn(Article::getSchiene).setCaption("Schiene");
            articleGrid.addColumn(Article::getSchrank).setCaption("Schrank");
            articleGrid.addColumn(Article::getTablar).setCaption("Tablar");
            articleGrid.addColumn(Article::getBox).setCaption("Box");
            articleGrid.addColumn(Article::getBemerkung).setCaption("Bemerkung");
            articleGrid.addColumn(Article::getBemerkung).setCaption("Leer").setId("Leer");
            articleGrid.getColumn("Leer").setHidden(true);
            contentLayout.setMargin(false);
            contentLayout.addComponents(articleGrid);
        });

        textLayout.addComponents(searchField, searchBtn);
        searchLayout.addComponents(filterLayout, textLayout, contentLayout);

        return searchLayout;
        

    }
}
