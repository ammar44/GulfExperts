package com.example.shaba.gulfexperts.data.repo;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.shaba.gulfexperts.data.DatabaseManager;
import com.example.shaba.gulfexperts.data.model.Work;

/**
 * Created by Tan on 1/26/2016.
 */
public class WorkRepo {

    private Work work;

    public WorkRepo(){

        work= new Work();


    }


    public static String createTable(){
        return "CREATE TABLE " + Work.TABLE  + "("
                + Work.KEY_WorkId + " TEXT  ) ";

    }



    public int insert(Work work) {
        int workId;
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(Work.KEY_WorkId, work.getWorkId());
     //   values.put(Work.KEY_Name, work.getName());

        // Inserting Row
        workId=(int)db.insert(Work.TABLE, null, values);
        DatabaseManager.getInstance().closeDatabase();
        return workId;

    }



    public void delete( ) {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        db.delete(Work.TABLE, null,null);
        DatabaseManager.getInstance().closeDatabase();
    }








}
