/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.teko.pa4.materialverwaltung.ui;

import ch.teko.pa4.materialverwaltung.beans.Article;
import ch.teko.pa4.materialverwaltung.dao.MaterialverwaltungDao;
import com.vaadin.event.ShortcutAction;
import com.vaadin.event.ShortcutListener;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.bson.Document;

/**
 * Hier werden die Elemente für die Suche von Artikeln erstellt Alle Textfelder
 * und der Suchen Button werden erstellt und in den entsprechenden Layouts
 * bereitgestellt.
 *
 * @author ch.grossmann, t.baechler
 */
public class SearchTab {

    List<Article> searchArticleList = new ArrayList<>();
    

    private String column;

    final VerticalLayout searchLayout = new VerticalLayout();
    final VerticalLayout contentLayout = new VerticalLayout();
    final HorizontalLayout filterLayout = new HorizontalLayout();
    final VerticalLayout textLayout = new VerticalLayout();
    final HorizontalLayout buttonLayout = new HorizontalLayout();

    Button linieBtn;
    Button stationBtn;
    Button bezeichnungBtn;
    Button typBtn;
    Button beschreibungBtn;
    Button artNrBtn;
    Button löschenBtn;

    TextField searchField = new TextField("Suchtext");

    public Component searchTab() {

        filterLayout.setMargin(true);
        filterLayout.addStyleName("border");

        linieBtn = new Button("Linie", (searchEvent) -> {

            column = "linie";

            linieBtn.setEnabled(false);
            stationBtn.setEnabled(true);
            bezeichnungBtn.setEnabled(true);
            typBtn.setEnabled(true);
            beschreibungBtn.setEnabled(true);
            artNrBtn.setEnabled(true);

        });

        stationBtn = new Button("Station", (searchEvent) -> {

            column = "station";
            linieBtn.setEnabled(true);
            stationBtn.setEnabled(false);
            bezeichnungBtn.setEnabled(true);
            typBtn.setEnabled(true);
            beschreibungBtn.setEnabled(true);
            artNrBtn.setEnabled(true);
        });

        bezeichnungBtn = new Button("Bezeichnung", (searchEvent) -> {

            column = "bezeichnung";
            linieBtn.setEnabled(true);
            stationBtn.setEnabled(true);
            bezeichnungBtn.setEnabled(false);
            typBtn.setEnabled(true);
            beschreibungBtn.setEnabled(true);
            artNrBtn.setEnabled(true);

        });

        typBtn = new Button("Typ", (searchEvent) -> {

            column = "typ";
            linieBtn.setEnabled(true);
            stationBtn.setEnabled(true);
            bezeichnungBtn.setEnabled(true);
            typBtn.setEnabled(false);
            beschreibungBtn.setEnabled(true);
            artNrBtn.setEnabled(true);

        });

        beschreibungBtn = new Button("Beschreibung", (searchEvent) -> {

            column = "beschreibung";
            linieBtn.setEnabled(true);
            stationBtn.setEnabled(true);
            bezeichnungBtn.setEnabled(true);
            typBtn.setEnabled(true);
            beschreibungBtn.setEnabled(false);
            artNrBtn.setEnabled(true);

        });

        artNrBtn = new Button("Artikelnummer", (searchEvent) -> {

            column = "artNr";
            linieBtn.setEnabled(true);
            stationBtn.setEnabled(true);
            bezeichnungBtn.setEnabled(true);
            typBtn.setEnabled(true);
            beschreibungBtn.setEnabled(true);
            artNrBtn.setEnabled(false);

        });

        löschenBtn = new Button("X", (searchEvent) -> {

            column = null;
            linieBtn.setEnabled(true);
            stationBtn.setEnabled(true);
            bezeichnungBtn.setEnabled(true);
            typBtn.setEnabled(true);
            beschreibungBtn.setEnabled(true);
            artNrBtn.setEnabled(true);

        });

        filterLayout.addComponents(linieBtn, stationBtn, bezeichnungBtn, typBtn, beschreibungBtn, artNrBtn, löschenBtn);

        Button searchBtn = new Button("Suchen", (searchEvent) -> {

            searchAction();

        });

        ShortcutListener shortcut = new ShortcutListener("Login", ShortcutAction.KeyCode.ENTER, null) {
            @Override
            public void handleAction(Object sender, Object target) {
                searchAction();

            }
        };

        searchBtn.addShortcutListener(shortcut);

        textLayout.setMargin(false);
        textLayout.addComponents(searchField, searchBtn);
        textLayout.setComponentAlignment(searchField, Alignment.TOP_LEFT);
        textLayout.setComponentAlignment(searchBtn, Alignment.TOP_LEFT);

        searchLayout.addComponents(filterLayout, textLayout, contentLayout);

        return searchLayout;

    }

    /**
     * Die searchAction wird durch den Suchen Button ausgelöst und unterscheidet
     * von einer leeren Suche über alles und einer mit Filter.
     * Das bestehende Grid wird gelöscht falls vorhanden.
     * Die Buttons Ändern und Löschen sind nur ersichtlich wenn man als admin eingeloggt ist.
     */
    private void searchAction() {

        /**
         * Das löscht das vorhergehende articleGrid
         */
        if (contentLayout.getComponentCount() != 0) {
            contentLayout.removeAllComponents();
            buttonLayout.removeAllComponents();
        }

        MaterialverwaltungDao dao = new MaterialverwaltungDao();

        /**
         * Falls kein Suchtext übergeben wird werden alle Artikel ausgelesen.
         */
        if (searchField.isEmpty()) {

            searchArticleList = dao.searchArticle();

        } else if (column == null) {

            Notification notif = new Notification("Bitte einen Filter wählen.");
            notif.setDelayMsec(3000);
            notif.show(Page.getCurrent());

        } else {

            Document newSearchDoc = new Document();

            newSearchDoc.append(column, searchField.getValue());

            searchArticleList = dao.searchArticle(newSearchDoc);

        }

        /**
         * Falls kein Artikel gefunden wurde erscheint ein Hinweistext, andernfalls wird eine Tabelle erstellt und alle Artikel darin dargestellt.
         */
        if (searchArticleList.isEmpty()) {
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

        /**
         * Wird nur ausgeführt wenn man als admin angemeldet ist.
         */
        if (VaadinSession.getCurrent().getAttribute("userfunction").toString().equals("Admin")) {

            
            Button editBtn = new Button("Ändern", (editEvent) -> {

                Set<Article> editArticle = articelGrid.getSelectedItems();

                if (editArticle.isEmpty()) {
                    Notification notif = new Notification("Bitte einen Artikel wählen.");
                    notif.setDelayMsec(2000);
                    notif.show(Page.getCurrent());

                } else {

                    List<Article> e = new ArrayList<>(editArticle);

                    Article a = e.get(0);

                    if (contentLayout.getComponentCount() != 0) {
                        contentLayout.removeAllComponents();
                        buttonLayout.removeAllComponents();
                    }

                    contentLayout.addComponent(new EditTab().editTab(a.getId(), a.getBahn(), a.getLinie(),
                            a.getStation(), a.getSystem1(), a.getSystem2(), a.getSystem3(),
                            a.getBezeichnung(), a.getTyp(), a.getBeschreibung(), a.getArtNr(),
                            a.getAnzahl(), a.getGestell(), a.getSchiene(), a.getSchrank(),
                            a.getTablar(), a.getBox(), a.getBemerkung()));
                }
            });

            
            Button deleteBtn = new Button("Löschen", (deleteEvent) -> {

                Set<Article> deleteArticle = articelGrid.getSelectedItems();

                if (deleteArticle.isEmpty()) {
                    Notification notif = new Notification("Bitte einen Artikel wählen.");
                    notif.setDelayMsec(2000);
                    notif.show(Page.getCurrent());
                } else {

                    List<Article> a = new ArrayList<>(deleteArticle);

                    long check = dao.deleteArticle(a.get(0).getId());

                    if (check != 0) {
                        Notification notif = new Notification("Der Artikel wurde gelöscht.");
                        notif.setDelayMsec(3000);
                        notif.show(Page.getCurrent());
                    }

                    searchAction();
                }
            });

            buttonLayout.addComponents(editBtn, deleteBtn);
            contentLayout.addComponents(articelGrid, buttonLayout);
        } else {
            contentLayout.addComponents(articelGrid);
        }

    }

    

}
