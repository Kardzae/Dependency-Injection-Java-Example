package com.emmanuel.repositories;

public interface DBRepository {
    public void connectToDB();

    public void insertOneRecord(String userName, String userEmail, String userPhone);

    public void getRecords();
}
