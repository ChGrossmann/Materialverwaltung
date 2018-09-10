/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.teko.pa4.materialverwaltung.dao;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *Baut die Verbindung zur Datenbank auf.
 * DB Name : Materialverwaltung. 
 * MongoDB
 * @author t.baechler, ch.grossmann
 */
public class DBConnection {
    
   
    public MongoDatabase db;
    public MongoCollection<Document> mdbCollection;
    
    
    /**
     * connection erwartet ein Parameter für den Namen der Collection.
     * @param collection 
     */
       public void connection(String collection){
        // Verbindung zu localhost, Port: 27017
        MongoClient client = MongoClients.create();

       /**
        * Die Db Materialverwaltung
        */
        db = client.getDatabase("Materialverwaltung");
        
        /**
         * Die Collection nach Parameter
         */
        mdbCollection = db.getCollection(collection);
                

        

    }
    
}
