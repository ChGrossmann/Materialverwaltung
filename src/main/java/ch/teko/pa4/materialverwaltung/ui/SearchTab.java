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

    public Component searchTab() {

       
        

        final VerticalLayout searchLayout = new VerticalLayout();

        final HorizontalLayout filterLayout = new HorizontalLayout();

        Button articleBtn = new Button("Article");
        Button stationBtn = new Button("Station");
        Button elementBtn = new Button("Bezeichnung");

        filterLayout.addComponents(articleBtn, stationBtn, elementBtn);

        final HorizontalLayout textLayout = new HorizontalLayout();

        TextField searchField = new TextField("Searchtext");
        Button searchBtn = new Button("Search", (searchEvent) -> {
            
            MaterialverwaltungDao dao = new MaterialverwaltungDao();
            
            if(searchField != null){
                Document newSearchDoc = new Document();
                
                newSearchDoc.append(key, this);
            }else{
                
               List<Article> searchArticleList = new ArrayList<>();
               searchArticleList = dao.searchArticle();
                
            }
        });

        textLayout.addComponents(searchField, searchBtn);

        final VerticalLayout contentLayout = new VerticalLayout();

        
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
        
        
        Grid<Article> articelGrid = new Grid<>();
        articelGrid.setItems(searchArticleList);
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
