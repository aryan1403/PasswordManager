package com.manager.DB;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

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

            for (Document d : doc.find()) {
                System.out.println(d.toJson());
                
            }
            return true;
        } catch (Exception e) {
            System.out.println("ERROR Occured Retreiving Data..");
            return false;
        }
    }

    public boolean delete(String key) {
        try {
            MongoClient client = MongoClients.create("mongodb://localhost:27017");
            MongoDatabase database = client.getDatabase("test");
            MongoCollection<Document> doc = database.getCollection("testing");

            for(Document d : doc.find()){
                doc.deleteOne(Filters.eq("key", key));
                d.toJson();
            }
            return true;
        } catch (Exception e) {
            System.out.println("ERROR Occured Deleting Data..\nPlease Enter correct key");
            return false;
        }
    }
    
}
