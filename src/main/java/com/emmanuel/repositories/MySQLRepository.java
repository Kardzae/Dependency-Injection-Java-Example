package com.emmanuel.repositories;

import java.sql.*;

public class MySQLRepository implements DBRepository{
    // Here goes your URI for MySQL Connection Database
    private String url = "";
    // here goes your user for your database
    private String user = "";
    // Here goes your password for database
    private String password = "";

    private Connection connection;
    public MySQLRepository(){
        connectToDB();
    }
    @Override
    public void connectToDB(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection succesfull to MySQL");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
    }

    @Override
    public void insertOneRecord(String userName, String userEmail, String userPhone){
        String query = "INSERT INTO users(name_user, email_user, phone_user) VALUES(" +
                "'" + userName + "', '" + userEmail + "', '" +
                userPhone+ "'" + ")";

        try{
            Statement statement = this.connection.createStatement();
            statement.execute(query);
            System.out.println("User saved successfully");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void getRecords(){
        String query = "SELECT * FROM users";

        try{
            Statement statement = this.connection.createStatement();
            ResultSet results = statement.executeQuery(query);
            while(results.next()){
                System.out.println("Id: " + results.getString(1) +
                        ", Name: "+ results.getString(2) +
                        ", Email: "+ results.getString(3) +
                        ", Phone user: "+ results.getString(4));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
