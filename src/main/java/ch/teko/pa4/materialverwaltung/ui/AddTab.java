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
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author ch.grossmann
 */
public class AddTab {
    
    
    
    
    public Component addTab(){
    
    final VerticalLayout addLayout = new VerticalLayout();
    
    final GridLayout addArticleLayout = new GridLayout(2,18);
    
    
    Label idLab = new Label("id");
    TextField idTxt = new TextField("");
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
    
    
    
    addArticleLayout.addComponent(idLab, 0, 0);
    addArticleLayout.addComponent(idTxt, 1, 0);
    addArticleLayout.addComponent(bahnLab, 0, 1);
    addArticleLayout.addComponent(bahnTxt, 1, 1);
    addArticleLayout.addComponent(linieLab, 0, 2);
    addArticleLayout.addComponent(linieTxt, 1, 2);
    addArticleLayout.addComponent(stationLab, 0, 3);
    addArticleLayout.addComponent(stationTxt, 1, 3);
    addArticleLayout.addComponent(system1Lab, 0, 4);
    addArticleLayout.addComponent(system1Txt, 1, 4);
    addArticleLayout.addComponent(system2Lab, 0, 5);
    addArticleLayout.addComponent(system2Txt, 1, 5);
    addArticleLayout.addComponent(system3Lab, 0, 6);
    addArticleLayout.addComponent(system3Txt, 1, 6);
    addArticleLayout.addComponent(bezeichnungLab, 0, 7);
    addArticleLayout.addComponent(bezeichnungTxt, 1, 7);
    addArticleLayout.addComponent(typLab, 0, 8);
    addArticleLayout.addComponent(typTxt, 1, 8);
    addArticleLayout.addComponent(beschreibungLab, 0, 9);
    addArticleLayout.addComponent(beschreibungTxt, 1, 9);
    addArticleLayout.addComponent(artikelNrLab, 0, 10);
    addArticleLayout.addComponent(artikelNrTxt, 1, 10);
    addArticleLayout.addComponent(anzahlLab, 0, 11);
    addArticleLayout.addComponent(anzahlTxt, 1, 11);
    addArticleLayout.addComponent(gestellLab, 0, 12);
    addArticleLayout.addComponent(gestellTxt, 1, 12);
    addArticleLayout.addComponent(schieneLab, 0, 13);
    addArticleLayout.addComponent(schieneTxt, 1, 13);
    addArticleLayout.addComponent(schrankLab, 0, 14);
    addArticleLayout.addComponent(schrankTxt, 1, 14);
    addArticleLayout.addComponent(tablarLab, 0, 15);
    addArticleLayout.addComponent(tablarTxt, 1, 15);
    addArticleLayout.addComponent(boxLab, 0, 16);
    addArticleLayout.addComponent(boxTxt, 1, 16);
    addArticleLayout.addComponent(bemerkungLab, 0, 17);
    addArticleLayout.addComponent(bemerkungTxt, 1, 17);
    
    
    
    final HorizontalLayout submitLayout = new HorizontalLayout();
    
    Button addBtn= new Button("Add", (addArticleEvent) -> {
      Article addArticle = new Article();
      MaterialverwaltungDao dao = new MaterialverwaltungDao();
      
      addArticle.setId( Integer.parseInt(idTxt.getValue()));  
      addArticle.setBahn(bahnTxt.getValue());  ;
      addArticle.setLinie(linieTxt.getValue());  ;
      addArticle.setStation(stationTxt.getValue())  ;
      addArticle.setSystem1(system1Txt.getValue())  ;
      addArticle.setSystem2(system2Txt.getValue())  ;
      addArticle.setSystem3(system3Txt.getValue());  ;
      addArticle.setBezeichnung(bezeichnungTxt.getValue())  ;
      addArticle.setTyp(typTxt.getValue());  ;
      addArticle.setBeschreibung(beschreibungTxt.getValue());  ;
      addArticle.setArtNr(artikelNrTxt.getValue());  ;
      addArticle.setAnzahl(Integer.parseInt(anzahlTxt.getValue()));  ;
      addArticle.setGestell(gestellTxt.getValue());  ;
      addArticle.setSchiene(Integer.parseInt(schieneTxt.getValue()));  ;
      addArticle.setSchrank(schrankTxt.getValue());  ;
      addArticle.setTablar(Integer.parseInt(tablarTxt.getValue()));  ;
      addArticle.setBox(Integer.parseInt(boxTxt.getValue()));  ;
      addArticle.setBemerkung(bemerkungTxt.getValue());  ;

      dao.addArticle(addArticle);
      
    });
    
    
    
    submitLayout.addComponent(addBtn);
    
    
    
    
    
    addLayout.addComponents(addArticleLayout, submitLayout);
    
    return addLayout;
    }
    
    
}
