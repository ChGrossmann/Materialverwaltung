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
 *
 * @author ch.grossmann
 */
public class MaterialverwaltungDao {

    DBConnection conn = new DBConnection();

    DocumentToArticle DtA = new DocumentToArticle();
    ArticleToDocument AtD = new ArticleToDocument();
    List<Article> searchArticle = new ArrayList<>();

    public Document addArticle(Article article) {

        conn.connection("Artikel");

        Document newArticle = AtD.articleToDocument(article);;

        

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

    public long deleteArticle(String id) {

        conn.connection("Artikel");

        DeleteResult delCount = conn.mdbCollection.deleteOne(new Document("_id", new ObjectId(id)));

        return delCount.getDeletedCount();

    }

    public void editArticle(Article oldArticle, Article newArticle) {

        conn.connection("Artikel");

        DeleteResult delCount = conn.mdbCollection.deleteOne(new Document("_id", new ObjectId(oldArticle.getId())));

        if (delCount.getDeletedCount() != 0) {

            Document newArticleDoc = AtD.articleToDocument(newArticle);

            conn.mdbCollection.insertOne(newArticleDoc);
        }

    }

}
