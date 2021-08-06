package com.manager.DB;

import java.util.Iterator;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;

public class db {
    public boolean add(String key, String value){
        try {
            MongoClient client = MongoClients.create("mongodb://localhost:27017");
            MongoDatabase database = client.getDatabase("test");
            MongoCollection<Document> doc = database.getCollection("testing");

            Document document = new Document("key", key)
                .append("value", value);

            doc.insertOne(document);
            return true;
        } catch (Exception e) {
            System.out.println("ERROR Occured Inserting Data..");
            return false;
        }
    }

    public boolean get(){
        try {
            MongoClient client = MongoClients.create("mongodb://localhost:27017");
            MongoDatabase database = client.getDatabase("test");
            MongoCollection<Document> doc = database.getCollection("testing");

            FindIterable<Document> iterDoc = doc.find();
            int i = 1;
            // Getting the iterator
            Iterator it = iterDoc.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
                i++;
		    }
            return true;
        } catch (Exception e) {
            System.out.println("ERROR Occured Retreiving Data..");
            return false;
        }
    }

    public boolean deleteAll() {
        try {
            MongoClient client = MongoClients.create("mongodb://localhost:27017");
            MongoDatabase database = client.getDatabase("test");
            MongoCollection<Document> doc = database.getCollection("testing");

            FindIterable<Document> iterDoc = doc.find();
            int i = 1;
            // Getting the iterator
            Iterator it = iterDoc.iterator();
            while (it.hasNext()) {
                doc.deleteOne((Bson) it);
		    }
            return true;
        } catch (Exception e) {
            System.out.println("ERROR Occured Deleting Data..");
            return false;
        }
    }
    
}
