package com.emmanuel.services;
import com.emmanuel.repositories.DBRepository;

public class DBService {
    DBRepository dbRepository;

    public DBService(DBRepository dbRepository){
        this.dbRepository = dbRepository;
    }

    public void insertRecord(String userName, String userEmail, String userPhone){
        this.dbRepository.insertOneRecord(userName, userEmail, userPhone);
    }

    public void connectToDatabase(){
        this.dbRepository.connectToDB();
    }

    public void getRecords(){
       this.dbRepository.getRecords();
    }
}
