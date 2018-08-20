/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.teko.pa4.materialverwaltung.ui;

import ch.teko.pa4.materialverwaltung.beans.Article;
import ch.teko.pa4.materialverwaltung.dao.MaterialverwaltungDao;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import java.util.ArrayList;
import java.util.Arrays;
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

        Button articleBtn = new Button("Bezeichnung", (searchEvent) -> {

            column = "bezeichnung";

        });
        Button stationBtn = new Button("Station", (searchEvent) -> {

            column = "station";

        });
        Button elementBtn = new Button("Typ", (searchEvent) -> {

            column = "typ";

        });

        filterLayout.addComponents(articleBtn, stationBtn, elementBtn);

        final HorizontalLayout textLayout = new HorizontalLayout();

        TextField searchField = new TextField("Searchtext");
        Button searchBtn = new Button("Search", (searchEvent) -> {

            Grid<Article> articelGrid = new Grid<>();
            contentLayout.removeComponent(articelGrid);

            MaterialverwaltungDao dao = new MaterialverwaltungDao();

            if (searchField.isEmpty()) {

                searchArticleList = dao.searchArticle();

            } else {

                Document newSearchDoc = new Document();

                newSearchDoc.append(column, searchField);

                searchArticleList = dao.searchArticle(newSearchDoc);

            }

            articelGrid.setItems(searchArticleList);
            articelGrid.setSizeFull();
            articelGrid.addColumn(Article::getBahn).setCaption("Bahn");
            articelGrid.addColumn(Article::getLinie).setCaption("Linie");
            articelGrid.addColumn(Article::getStation).setCaption("Station");
            articelGrid.addColumn(Article::getSystem1).setCaption("System 1");
            articelGrid.addColumn(Article::getSystem2).setCaption("System 2");
            articelGrid.addColumn(Article::getSystem3).setCaption("System 3");
            articelGrid.addColumn(Article::getBezeichnung).setCaption("Bezeichnung");
            articelGrid.addColumn(Article::getTyp).setCaption("Typ");
            articelGrid.addColumn(Article::getBeschreibung).setCaption("Beschreibung");
            articelGrid.addColumn(Article::getArtNr).setCaption("Artikelnr.");
            articelGrid.addColumn(Article::getAnzahl).setCaption("Anzahl");
            articelGrid.addColumn(Article::getGestell).setCaption("Gestell");
            articelGrid.addColumn(Article::getSchiene).setCaption("Schiene");
            articelGrid.addColumn(Article::getSchrank).setCaption("Schrank");
            articelGrid.addColumn(Article::getTablar).setCaption("Tablar");
            articelGrid.addColumn(Article::getBox).setCaption("Box");
            articelGrid.addColumn(Article::getBemerkung).setCaption("Bemerkung");

            contentLayout.addComponents(articelGrid);

        });

        textLayout.addComponents(searchField, searchBtn);

//        List<Article> articleArray = Arrays.asList(
//                new Article("SBB", "Zürich", "EBI", "rStw", "Domino 67N", 
//                        "Relaissatz", "WRS", "501", "Weichenrelaissatz", "34542-89", 
//                        3, "301", 4, ".", 0, 0, "Die Bemerkung 1"),
//                new Article("SBB", "Bern", "ENT", "eStw", "SIMIS C", "Karte", 
//                        "ANRES", "501", "Weichenrelaissatz", "34542-89", 3, "301", 
//                        4, ".", 0, 0, "Die Bemerkung 2"),
//                new Article("SBB", "Seetal", "HIK", "eStw", "Elektra 2", 
//                        "Karte", "WEB", "501", "Weichenrelaissatz", "34542-89", 
//                        3, "301", 4, ".", 0, 0, "Die Bemerkung 3")
//        );
        searchLayout.addComponents(filterLayout, textLayout, contentLayout);

        return searchLayout;
    }
}
