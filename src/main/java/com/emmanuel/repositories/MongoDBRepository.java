package com.emmanuel.repositories;

import com.mongodb.client.*;
import org.bson.Document;
import java.util.List;

public class MongoDBRepository implements DBRepository{
    // Here goes you connection URI for MongoDB
    private final String uriMongoDB = "";
    private MongoDatabase db;
    private MongoCollection<Document> col;

    public MongoDBRepository(){
        connectToDB();
    }

    @Override
    public void connectToDB(){
        try{
            MongoClient client = MongoClients.create(this.uriMongoDB);
            // Here goes the name of your Database in MongoDB
            this.db = client.getDatabase("");
            // here goes the name of Collection "Users"
            this.col = db.getCollection("users");

            System.out.println("Connection Successfull to MongoDB");
        }catch (Exception e){
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
    }
    @Override
    public void insertOneRecord(String userName, String userEmail, String userPhone){
        Document doc = new Document("name_user", userName)
                .append("email_user", userEmail)
                .append("phone_user", userPhone);

        this.col.insertOne(doc);

        System.out.println("Doc inserted successfully");
    }

    @Override
    public void getRecords(){
        MongoCursor<Document> cursor = this.col.find().iterator();
        try{
            while (cursor.hasNext()) {
                System.out.println("COLLECTION: " +cursor.next().toJson() );
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            cursor.close();
        }
    }
}
