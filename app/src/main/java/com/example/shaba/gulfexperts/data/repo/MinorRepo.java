package com.example.shaba.gulfexperts.data.repo;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.shaba.gulfexperts.data.DatabaseManager;
import com.example.shaba.gulfexperts.data.model.Minor;


/**
 * Created by Tan on 1/26/2016.
 */
public class MinorRepo {

    private Minor minor;

    public MinorRepo(){

        minor= new Minor();
      //  this.delete();

//        minor.setMInorId("minor");
//        minor.setName("1");
//        this.insert(minor);
//        minor.setMInorId("minor2");
//        minor.setName("2");
//        this.insert(minor);
//        minor.setMInorId("minor3");
//        minor.setName("3");
//        this.insert(minor);
//        minor.setMInorId("minor4");
//        minor.setName("4");
//        this.insert(minor);
//        minor.setMInorId("minor5");
//        minor.setName("5");
//        this.insert(minor);

    }


    public static String createTable(){
        return "CREATE TABLE " + Minor.TABLE  + "("
                + Minor.KEY_MinorId + " TEXT  PRIMARY KEY) ";
              //  + Minor.KEY_Name + " TEXT )";
    }



    public int insert(Minor minor) {
        int minorId;
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(Minor.KEY_MinorId, minor.getMinorId());
      //  values.put(Minor.KEY_Name, minor.getName());

        // Inserting Row
        minorId=(int)db.insert(Minor.TABLE, null, values);
        DatabaseManager.getInstance().closeDatabase();
        return minorId;

    }



    public void delete( ) {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        db.delete(Minor.TABLE, null,null);
        DatabaseManager.getInstance().closeDatabase();
    }








}
