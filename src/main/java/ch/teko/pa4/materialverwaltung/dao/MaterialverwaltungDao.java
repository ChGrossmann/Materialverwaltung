/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.teko.pa4.materialverwaltung.dao;

import ch.teko.pa4.materialverwaltung.DocumentToArticle;
import ch.teko.pa4.materialverwaltung.beans.Article;
import com.mongodb.client.MongoCursor;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author ch.grossmann
 */
public class MaterialverwaltungDao {

    DBConnection conn = new DBConnection();

    DocumentToArticle DtA = new DocumentToArticle();
    List<Article> searchArticle = new ArrayList<>();

    public Document addArticle(Article article) {

        conn.connection("Artikel");

        Document newArticle = new Document();

        newArticle.append("bahn", article.getBahn());
        newArticle.append("linie", article.getLinie());
        newArticle.append("station", article.getStation());
        newArticle.append("system1", article.getSystem1());
        newArticle.append("system2", article.getSystem2());
        newArticle.append("system3", article.getSystem3());
        newArticle.append("bezeichnung", article.getBezeichnung());
        newArticle.append("typ", article.getTyp());
        newArticle.append("beschreibung", article.getBeschreibung());
        newArticle.append("artNr", article.getArtNr());
        newArticle.append("anzahl", article.getAnzahl());
        newArticle.append("gestell", article.getGestell());
        newArticle.append("schiene", article.getSchiene());
        newArticle.append("schrank", article.getSchrank());
        newArticle.append("tablar", article.getTablar());
        newArticle.append("box", article.getBox());
        newArticle.append("bemerkung", article.getBemerkung());

        conn.mdbCollection.insertOne(newArticle);

        return newArticle;
    }

    public List<Article> searchArticle() {

        conn.connection("Artikel");

        MongoCursor<Document> listArticle = conn.mdbCollection.find().iterator();

        while (listArticle.hasNext()) {

            Article a = DtA.documentToAticle(listArticle.next());

            searchArticle.add(a);

        }

        return searchArticle;
    }

    public List<Article> searchArticle(Document artikel) {

        conn.connection("Artikel");

        MongoCursor<Document> listArticle = conn.mdbCollection.find(artikel).iterator();

        while (listArticle.hasNext()) {
            Article a = DtA.documentToAticle(listArticle.next());

            searchArticle.add(a);

        }

        return searchArticle;
    }


}
