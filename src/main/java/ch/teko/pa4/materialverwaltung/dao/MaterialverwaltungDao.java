/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.teko.pa4.materialverwaltung.dao;

import ch.teko.pa4.materialverwaltung.ArticleToDocument;
import ch.teko.pa4.materialverwaltung.DocumentToArticle;
import ch.teko.pa4.materialverwaltung.beans.Article;
import com.mongodb.client.MongoCursor;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;
import com.mongodb.client.result.DeleteResult;

/**
 *Methoden für den Datentransfer zwischen Applikation und Datenbank.
 * @author ch.grossmann, t.baechler
 */
public class MaterialverwaltungDao {

    DBConnection conn = new DBConnection();

    DocumentToArticle DtA = new DocumentToArticle();
    ArticleToDocument AtD = new ArticleToDocument();
    List<Article> searchArticle = new ArrayList<>();

    /**
     * Hiermit wird ein Artikel Bean in ein Document umgewandelt um es in die DB einzulesen.
     * @param article
     * @return 
     */
    public Document addArticle(Article article) {

        conn.connection("Artikel");

        Document newArticle = AtD.articleToDocument(article);;

        

        conn.mdbCollection.insertOne(newArticle);

        return newArticle;
    }

    /**
     * Hiermit wird die Datenbank durchsucht ohne Parameter.
     * Es werden alle gefundenen Einträge in ein Artikel Bean abgefüllt und in einer Liste zurück gegeben.
     * @return 
     */
    public List<Article> searchArticle() {

        conn.connection("Artikel");

        MongoCursor<Document> listArticle = conn.mdbCollection.find().iterator();

        while (listArticle.hasNext()) {

            Article a = DtA.documentToAticle(listArticle.next());

            searchArticle.add(a);

        }

        return searchArticle;
    }

    /**
     * Hiermit wird die Datenbank durchsucht mit Parameter.
     * Es werden alle gefundenen Einträge in ein Artikel Bean abgefüllt und in einer Liste zurück gegeben.
     * @param artikel
     * @return 
     */
    public List<Article> searchArticle(Document artikel) {

        conn.connection("Artikel");

        MongoCursor<Document> listArticle = conn.mdbCollection.find(artikel).iterator();

        while (listArticle.hasNext()) {
            Article a = DtA.documentToAticle(listArticle.next());

            searchArticle.add(a);

        }

        return searchArticle;
    }

    /**
     * Hiermit wird via übergebene id des Eintrags in der DB den entsprechenden Eintrag gelöscht.
     * Es wird ein Zähler zurückgegeben ob etwas gelöscht wurde.
     * @param id
     * @return 
     */
    public long deleteArticle(String id) {

        conn.connection("Artikel");

        /**
         * Gibt die Anzahl an gelöschten Einträgen wieder.
         */
        DeleteResult delCount = conn.mdbCollection.deleteOne(new Document("_id", new ObjectId(id)));

        return delCount.getDeletedCount();

    }

    /**
     * Hiermit wird der alte Artikel gelöscht und ein neuer an seiner Stelle in die Datenbank eingelesen.
     * Der alte Artikel wird mit Hilfe der id in der Datenbank gesucht und gelöscht.
     * Der neue Artikel wird in ein Document umgewandelt un in die DB geschrieben.
     * @param oldArticle
     * @param newArticle 
     */
    public void editArticle(Article oldArticle, Article newArticle) {

        conn.connection("Artikel");

        DeleteResult delCount = conn.mdbCollection.deleteOne(new Document("_id", new ObjectId(oldArticle.getId())));

        if (delCount.getDeletedCount() != 0) {

            Document newArticleDoc = AtD.articleToDocument(newArticle);

            conn.mdbCollection.insertOne(newArticleDoc);
        }

    }

}
