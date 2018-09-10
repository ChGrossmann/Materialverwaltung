/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.teko.pa4.materialverwaltung.beans;

/**
 *Vorbereitetes Bean für unsere Artikel in der Datenbank.
 * @author t.baechler, ch.grossmann
 */
public class Article {

    private String id;
    private String bahn;
    private String linie;
    private String station;
    private String system1;
    private String system2;
    private String system3;
    private String bezeichnung;
    private String typ;
    private String beschreibung;
    private String artNr;
    private int anzahl;
    private String gestell;
    private int schiene;
    private String schrank;
    private int tablar;
    private int box;
    private String bemerkung;

    public Article() {
    }

    public Article(String id) {

        this.id = id;
    }

    public Article(String id, String bahn, String linie, String station,
            String system1, String system2, String system3, String bezeichnung,
            String typ, String beschreibung, String artNr, int anzahl,
            String gestell, int schiene, String schrank, int tablar, int box,
            String bemerkung) {

        this.bahn = bahn;
        this.linie = linie;
        this.station = station;
        this.system1 = system1;
        this.system2 = system2;
        this.system3 = system3;
        this.bezeichnung = bezeichnung;
        this.typ = typ;
        this.beschreibung = beschreibung;
        this.artNr = artNr;
        this.anzahl = anzahl;
        this.gestell = gestell;
        this.schiene = schiene;
        this.schrank = schrank;
        this.tablar = tablar;
        this.box = box;
        this.bemerkung = bemerkung;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBahn() {
        return bahn;
    }

    public void setBahn(String bahn) {
        this.bahn = bahn;
    }

    public String getLinie() {
        return linie;
    }

    public void setLinie(String linie) {
        this.linie = linie;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getSystem1() {
        return system1;
    }

    public void setSystem1(String system1) {
        this.system1 = system1;
    }

    public String getSystem2() {
        return system2;
    }

    public void setSystem2(String system2) {
        this.system2 = system2;
    }

    public String getSystem3() {
        return system3;
    }

    public void setSystem3(String system3) {
        this.system3 = system3;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getArtNr() {
        return artNr;
    }

    public void setArtNr(String artNr) {
        this.artNr = artNr;
    }

    public int getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }

    public String getGestell() {
        return gestell;
    }

    public void setGestell(String gestell) {
        this.gestell = gestell;
    }

    public int getSchiene() {
        return schiene;
    }

    public void setSchiene(int schine) {
        this.schiene = schine;
    }

    public String getSchrank() {
        return schrank;
    }

    public void setSchrank(String schrank) {
        this.schrank = schrank;
    }

    public int getTablar() {
        return tablar;
    }

    public void setTablar(int tablar) {
        this.tablar = tablar;
    }

    public int getBox() {
        return box;
    }

    public void setBox(int box) {
        this.box = box;
    }

    public String getBemerkung() {
        return bemerkung;
    }

    public void setBemerkung(String bemerkung) {
        this.bemerkung = bemerkung;
    }

}
