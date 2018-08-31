/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.teko.pa4.materialverwaltung.ui;

import ch.teko.pa4.materialverwaltung.beans.Article;
import ch.teko.pa4.materialverwaltung.dao.MaterialverwaltungDao;
import com.vaadin.annotations.Theme;
import com.vaadin.server.Page;
import com.vaadin.server.Sizeable;
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
        
        filterLayout.addStyleName("filterBorder");
        

        
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
            if(contentLayout.getComponentCount() != 0){
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

            if(searchArticleList.isEmpty()){
                Notification notif = new Notification("Es wurde kein entsprechender Artikel gefunden.");
                notif.setDelayMsec(3000);
                notif.show(Page.getCurrent());
            }
            Grid<Article> articelGrid = new Grid<>();
            articelGrid.setItems(searchArticleList);
            articelGrid.setWidth("100%");
            articelGrid.setHeight("100%");
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

            contentLayout.setMargin(false);
            contentLayout.addComponents(articelGrid);

            
        });
        

            
        

        textLayout.addComponents(searchField, searchBtn);

       
        
        searchLayout.addComponents(filterLayout, textLayout, contentLayout);

        return searchLayout;
    }
}
