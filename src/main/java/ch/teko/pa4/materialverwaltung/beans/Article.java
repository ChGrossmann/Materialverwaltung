/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.teko.pa4.materialverwaltung.beans;

/**
 *
 * @author tbaec
 */
public class Article {
    
    
    
    private String station;
    private String bezeichnung;
    private String element;
    private String anzahl;
    private String schrank;
    private String tablar;

    public Article(String station, String bezeichnung, String element, String anzahl, String schrank, String tablar) {
        this.station = station;
        this.bezeichnung = bezeichnung;
        this.element = element;
        this.anzahl = anzahl;
        this.schrank = schrank;
        this.tablar = tablar;
    }
    
    
    
    
    
    

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public String getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(String anzahl) {
        this.anzahl = anzahl;
    }

    public String getSchrank() {
        return schrank;
    }

    public void setSchrank(String schrank) {
        this.schrank = schrank;
    }

    public String getTablar() {
        return tablar;
    }

    public void setTablar(String tablar) {
        this.tablar = tablar;
    }
    
    
    
}
