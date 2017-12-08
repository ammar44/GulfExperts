package com.example.shaba.gulfexperts.data.repo;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.shaba.gulfexperts.data.DatabaseManager;
import com.example.shaba.gulfexperts.data.model.Qualification;

/**
 * Created by Tan on 1/26/2016.
 */
public class QualificationRepo   {

    private Qualification qualification;

    public QualificationRepo(){

        qualification= new Qualification();
      //  this.delete();

//        qualification.setQualificationId("qualification");
//        qualification.setName("qualification2");
//        this.insert(qualification);
//
//        qualification.setQualificationId("work");
//        qualification.setName("work2");
//        this.insert(qualification);
//        qualification.setWorkId("minor3");
//        this.insert(qualification);
//        qualification.setWorkId("minor4");
//        this.insert(qualification);
//        qualification.setWorkId("minor5");
//        this.insert(qualification);


    }


    public static String createTable(){
        return "CREATE TABLE " + Qualification.TABLE  + "("
                + Qualification.KEY_QualificationId + " TEXT  PRIMARY KEY) ";
              //  + Qualification.KEY_Name + " TEXT )";
    }



    public int insert(Qualification qualification) {
        int qualificationId;
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(Qualification.KEY_QualificationId, qualification.getQualificationId());
      //  values.put(Qualification.KEY_Name, qualification.getName());

        // Inserting Row
        qualificationId=(int)db.insert(Qualification.TABLE, null, values);
        DatabaseManager.getInstance().closeDatabase();
        return qualificationId;

    }



    public void delete( ) {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        db.delete(Qualification.TABLE, null,null);
        DatabaseManager.getInstance().closeDatabase();
    }








}
