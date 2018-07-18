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
    
    
    Label stationLab = new Label("Station");
    TextField stationTxt = new TextField("Searchtext");
    Label elementLab = new Label("Element");
    TextField elementTxt = new TextField("Searchtext");
    Label bezeichnungLab = new Label("Bezeichnung");
    TextField bezeichnungTxt = new TextField("Searchtext");
    Label anzahlLab = new Label("Anzahl");
    TextField anzahlTxt = new TextField("Searchtext");
    Label schrankLab = new Label("Schrank");
    TextField schrankTxt = new TextField("Searchtext");
    Label tablarLab = new Label("Tablar");
    TextField tablarTxt = new TextField("Searchtext");
    
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
