/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.teko.pa4.materialverwaltung.ui;

import ch.teko.pa4.materialverwaltung.beans.Article;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ch.grossmann
 */
public class SearchTab {

    public Component searchTab() {

        

        final VerticalLayout searchLayout = new VerticalLayout();

        final HorizontalLayout filterLayout = new HorizontalLayout();

        Button article = new Button("Article");
        Button station = new Button("Station");
        Button element = new Button("Bezeichnung");

        filterLayout.addComponents(article, station, element);

        final HorizontalLayout textLayout = new HorizontalLayout();

        TextField searchField = new TextField("Searchtext");
        Button searchBtn = new Button("Search");

        textLayout.addComponents(searchField, searchBtn);

        final VerticalLayout contentLayout = new VerticalLayout();

        
        List<Article> articleArray = Arrays.asList(
                new Article(1, "SBB", "Zürich", "EBI", "rStw", "Domino 67N", 
                        "Relaissatz", "WRS", "501", "Weichenrelaissatz", "34542-89", 
                        3, "301", 4, ".", 0, 0, "Die Bemerkung 1"),
                new Article(2, "SBB", "Bern", "ENT", "eStw", "SIMIS C", "Karte", 
                        "ANRES", "501", "Weichenrelaissatz", "34542-89", 3, "301", 
                        4, ".", 0, 0, "Die Bemerkung 2"),
                new Article(2, "SBB", "Seetal", "HIK", "eStw", "Elektra 2", 
                        "Karte", "WEB", "501", "Weichenrelaissatz", "34542-89", 
                        3, "301", 4, ".", 0, 0, "Die Bemerkung 3")
        );
        
        
        Grid<Article> articelGrid = new Grid<>();
        articelGrid.setItems(articleArray);
        articelGrid.setWidth("1000");
        articelGrid.addColumn(Article::getStation).setCaption("Station");
        articelGrid.addColumn(Article::getBezeichnung).setCaption("Bezeichnung");
        articelGrid.addColumn(Article::getAnzahl).setCaption("Anzahl");
        articelGrid.addColumn(Article::getSchrank).setCaption("Schrank");
        articelGrid.addColumn(Article::getTablar).setCaption("Tablar");
        

        contentLayout.addComponents(articelGrid);

        searchLayout.addComponents(filterLayout, textLayout, contentLayout);

        return searchLayout;
    }
}
