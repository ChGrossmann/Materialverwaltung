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

        List<Article> articleArray = Arrays.asList(
                new Article("LZ", "Sicherung", "C13", "3", "A3", "4"),
                new Article("GTS", "Sicherung", "C13", "3", "A3", "4"),
                new Article("EBI", "Sicherung", "C13", "3", "A3", "4")
        );

        final VerticalLayout searchLayout = new VerticalLayout();

        final HorizontalLayout filterLayout = new HorizontalLayout();

        Button article = new Button("Article");
        Button station = new Button("Station");
        Button element = new Button("Element");

        filterLayout.addComponents(article, station, element);

        final HorizontalLayout textLayout = new HorizontalLayout();

        TextField searchField = new TextField("Searchtext");
        Button searchBtn = new Button("Search");

        textLayout.addComponents(searchField, searchBtn);

        final VerticalLayout contentLayout = new VerticalLayout();

        Grid<Article> articelGrid = new Grid<>();
        articelGrid.setItems(articleArray);
        articelGrid.addColumn(Article::getStation).setCaption("Station");
        articelGrid.addColumn(Article::getBezeichnung).setCaption("Bezeichnung");
        articelGrid.addColumn(Article::getElement).setCaption("Element");
        articelGrid.addColumn(Article::getAnzahl).setCaption("Anzahl");
        articelGrid.addColumn(Article::getSchrank).setCaption("Schrank");
        articelGrid.addColumn(Article::getTablar).setCaption("Tablar");
        

        contentLayout.addComponents(articelGrid);

        searchLayout.addComponents(filterLayout, textLayout, contentLayout);

        return searchLayout;
    }
}
