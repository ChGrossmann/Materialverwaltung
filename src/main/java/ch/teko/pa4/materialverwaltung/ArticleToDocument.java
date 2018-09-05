/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.teko.pa4.materialverwaltung;

import ch.teko.pa4.materialverwaltung.beans.Article;
import org.bson.Document;

/**
 *
 * @author ch.grossmann
 */
public class ArticleToDocument {
    
    public Document articleToDocument(Article newArticle){
        
        Document newArticleDoc = new Document();
        
        newArticleDoc.append("bahn", newArticle.getBahn());
            newArticleDoc.append("linie", newArticle.getLinie());
            newArticleDoc.append("station", newArticle.getStation());
            newArticleDoc.append("system1", newArticle.getSystem1());
            newArticleDoc.append("system2", newArticle.getSystem2());
            newArticleDoc.append("system3", newArticle.getSystem3());
            newArticleDoc.append("bezeichnung", newArticle.getBezeichnung());
            newArticleDoc.append("typ", newArticle.getTyp());
            newArticleDoc.append("beschreibung", newArticle.getBeschreibung());
            newArticleDoc.append("artNr", newArticle.getArtNr());
            newArticleDoc.append("anzahl", newArticle.getAnzahl());
            newArticleDoc.append("gestell", newArticle.getGestell());
            newArticleDoc.append("schiene", newArticle.getSchiene());
            newArticleDoc.append("schrank", newArticle.getSchrank());
            newArticleDoc.append("tablar", newArticle.getTablar());
            newArticleDoc.append("box", newArticle.getBox());
            newArticleDoc.append("bemerkung", newArticle.getBemerkung());
        
        return newArticleDoc;
    }
    
}
