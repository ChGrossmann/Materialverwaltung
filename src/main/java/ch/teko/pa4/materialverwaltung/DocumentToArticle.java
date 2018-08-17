/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.teko.pa4.materialverwaltung;

import ch.teko.pa4.materialverwaltung.beans.Article;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author ch.grossmann
 */
public class DocumentToArticle {
    
    public Article documentToBill(Document doc){
    //Bean Bill abfüllen
        Article article = new Article();
        
        article.setBahn(doc.get("bemerkung").toString());
        article.setLinie(doc.get("bemerkung").toString());
        article.setStation(doc.get("bemerkung").toString());
        article.setSystem1(doc.get("bemerkung").toString());
        article.setSystem2(doc.get("bemerkung").toString());
        article.setSystem3(doc.get("bemerkung").toString());
        article.setBezeichnung(doc.get("bemerkung").toString());
        article.setTyp(doc.get("bemerkung").toString());
        article.setBeschreibung(doc.get("bemerkung").toString());
        article.setArtNr(doc.get("bemerkung").toString());
        article.setAnzahl(doc.getInteger("rechnungsnummer"));
        article.setGestell(doc.get("bemerkung").toString());
        article.setSchiene(doc.getInteger("rechnungsnummer"));
        article.setSchrank(doc.get("bemerkung").toString());
        article.setTablar(doc.getInteger("rechnungsnummer"));
        article.setBox(doc.getInteger("rechnungsnummer"));
        article.setBemerkung(doc.get("bemerkung").toString());

        

        
        
        
        return article;
    }
    
}
