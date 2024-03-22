package com.emmanuel;

import com.emmanuel.repositories.DBRepository;
import com.emmanuel.repositories.MongoDBRepository;
import com.emmanuel.repositories.MySQLRepository;
import com.emmanuel.services.DBService;

/**
 * Dependency Injection for Database Services MongoDB and MySQL
 */
public class App 
{
    public static void main( String[] args )
    {

        // MongoDB Service usage

        DBRepository mongoDBRep = new MongoDBRepository();
        DBService mongoDBService = new DBService(mongoDBRep);

        mongoDBService.insertRecord("PRUEBA-EDUARDO", "RTEST@email.com", "3124212312");
        mongoDBService.getRecords();

        // MySQL Service usage

        DBRepository mySQLRep = new MySQLRepository();
        DBService mySQLService = new DBService(mySQLRep);

        mySQLService.getRecords();
        mySQLService.insertRecord("PRUEBA-EDUARDO", "RTEST@email.com", "3124212312");

        mySQLService.getRecords();
    }
}
