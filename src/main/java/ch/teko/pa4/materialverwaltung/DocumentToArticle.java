/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.teko.pa4.materialverwaltung;

import ch.teko.pa4.materialverwaltung.beans.Article;
import org.bson.Document;

/**
 *Hier wird aus einem Document ein Artikel Bean abgefüllt.
 * @author ch.grossmann, t.baechler
 */
public class DocumentToArticle {

    /**
     * Liest ein Document aus und füllt es in en Artikel Bean ab.
     * @param doc
     * @return 
     */
    public Article documentToAticle(Document doc) {
        
        Article article = new Article();

        article.setId(doc.get("_id").toString());
        article.setBahn(doc.get("bahn").toString());
        article.setLinie(doc.get("linie").toString());
        article.setStation(doc.get("station").toString());
        article.setSystem1(doc.get("system1").toString());
        article.setSystem2(doc.get("system2").toString());
        article.setSystem3(doc.get("system3").toString());
        article.setBezeichnung(doc.get("bezeichnung").toString());
        article.setTyp(doc.get("typ").toString());
        article.setBeschreibung(doc.get("beschreibung").toString());
        article.setArtNr(doc.get("artNr").toString());
        article.setAnzahl(doc.getInteger("anzahl"));
        article.setGestell(doc.get("gestell").toString());
        article.setSchiene(doc.getInteger("schiene"));
        article.setSchrank(doc.get("schrank").toString());
        article.setTablar(doc.getInteger("tablar"));
        article.setBox(doc.getInteger("box"));
        article.setBemerkung(doc.get("bemerkung").toString());

        return article;
    }

}
