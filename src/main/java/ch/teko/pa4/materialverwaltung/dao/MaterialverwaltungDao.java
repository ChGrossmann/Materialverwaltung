/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.teko.pa4.materialverwaltung.dao;

import ch.teko.pa4.materialverwaltung.DocumentToArticle;
import ch.teko.pa4.materialverwaltung.beans.Article;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
 
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
    
    public long deleteArticle(String id){
        
        conn.connection("Artikel");
        
        DeleteResult delCount =  conn.mdbCollection.deleteOne(new Document("_id", new ObjectId(id)));
        
        return delCount.getDeletedCount();
        
    }
    
    public long editArticle(Article oldArticle, Article newArticle){
        
        conn.connection("Artikel");
        
        Document newArticleDoc = new Document();

        newArticleDoc.append("_id", new ObjectId(newArticle.getId()));
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
        
        
        Document oldArticleDoc = new Document();
        
        oldArticleDoc.append("_id", new ObjectId(oldArticle.getId()));
//        oldArticleDoc.append("bahn", oldArticle.getBahn());
//        oldArticleDoc.append("linie", oldArticle.getLinie());
//        oldArticleDoc.append("station", oldArticle.getStation());
//        oldArticleDoc.append("system1", oldArticle.getSystem1());
//        oldArticleDoc.append("system2", oldArticle.getSystem2());
//        oldArticleDoc.append("system3", oldArticle.getSystem3());
//        oldArticleDoc.append("bezeichnung", oldArticle.getBezeichnung());
//        oldArticleDoc.append("typ", oldArticle.getTyp());
//        oldArticleDoc.append("beschreibung", oldArticle.getBeschreibung());
//        oldArticleDoc.append("artNr", oldArticle.getArtNr());
//        oldArticleDoc.append("anzahl", oldArticle.getAnzahl());
//        oldArticleDoc.append("gestell", oldArticle.getGestell());
//        oldArticleDoc.append("schiene", oldArticle.getSchiene());
//        oldArticleDoc.append("schrank", oldArticle.getSchrank());
//        oldArticleDoc.append("tablar", oldArticle.getTablar());
//        oldArticleDoc.append("box", oldArticle.getBox());
//        oldArticleDoc.append("bemerkung", oldArticle.getBemerkung());
        
        UpdateResult editArticle =  conn.mdbCollection.updateOne(eq(oldArticleDoc),new Document("$set", newArticleDoc));
        
        long editCount = editArticle.getModifiedCount();
        
        return editCount;
    }


}
