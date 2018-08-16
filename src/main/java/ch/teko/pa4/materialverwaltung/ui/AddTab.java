/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.teko.pa4.materialverwaltung.ui;

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
    
    final GridLayout addArticleLayout = new GridLayout(2,6);
    
    
    Label idLab = new Label("id");
    TextField dTxt = new TextField("");
    Label bahnLab = new Label("Bahn");
    TextField bahnTxt = new TextField("");
    Label linieLab = new Label("Linie");
    TextField linieTxt = new TextField("");
    Label stationLab = new Label("Station");
    TextField stationTxt = new TextField("");
    Label system1Lab = new Label("System I");
    TextField stem1Txt = new TextField("");
    Label system2Lab = new Label("System II");
    TextField ystem2Txt = new TextField("");
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
    
    
    
    addArticleLayout.addComponent(stationLab, 0, 0);
    addArticleLayout.addComponent(stationTxt, 1, 0);
    addArticleLayout.addComponent(elementLab, 0, 1);
    addArticleLayout.addComponent(elementTxt, 1, 1);
    addArticleLayout.addComponent(bezeichnungLab, 0, 2);
    addArticleLayout.addComponent(bezeichnungTxt, 1, 2);
    addArticleLayout.addComponent(anzahlLab, 0, 3);
    addArticleLayout.addComponent(anzahlTxt, 1, 3);
    addArticleLayout.addComponent(schrankLab, 0, 4);
    addArticleLayout.addComponent(schrankTxt, 1, 4);
    addArticleLayout.addComponent(tablarLab, 0, 5);
    addArticleLayout.addComponent(tablarTxt, 1, 5);
    
    
    
    final HorizontalLayout submitLayout = new HorizontalLayout();
    
    Button addBtn= new Button("Add");
    
    submitLayout.addComponent(addBtn);
    
    
    
    
    
    addLayout.addComponents(addArticleLayout, submitLayout);
    
    return addLayout;
    }
    
    
}
