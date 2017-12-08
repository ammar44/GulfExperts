package com.example.shaba.gulfexperts.data.repo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.shaba.gulfexperts.data.DatabaseManager;
import com.example.shaba.gulfexperts.data.model.Expert;
import com.example.shaba.gulfexperts.model.ExpertList;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by Tan on 1/26/2016.
 */
public class ExpertRepo {

    private Expert expert;

    public ExpertRepo(){

        expert= new Expert();





    }


    public static String createTable(){
        return "CREATE TABLE " + Expert.TABLE  +  "("
                + Expert.KEY_ExpertId  + " INTEGER   , "
                + Expert.KEY_Name + " TEXT, "
               + Expert.KEY_Phone + " TEXT, "
                + Expert.KEY_Email + " TEXT PRIMARY KEY ) ";
    }



    public void insert(Expert expert) {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(Expert.KEY_ExpertId, expert.getExpertId());
        values.put(Expert.KEY_Name, expert.getName());
        values.put(Expert.KEY_Phone, expert.getPhone());
        values.put(Expert.KEY_Email, expert.getEmail());

        // Inserting Row
        db.insert(Expert.TABLE, null, values);
        DatabaseManager.getInstance().closeDatabase();
    }



    public void delete( ) {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        db.delete(Expert.TABLE, null,null);
        DatabaseManager.getInstance().closeDatabase();
    }

//    public ArrayList<HashMap<String, String>> getExpertList() {
//        //Open connection to read only
//
//
//        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
//        String selectQuery =  "SELECT  " +
//                Expert.KEY_ExpertId + "," +
//                Expert.KEY_Name + " ," +
//                Expert.KEY_Phone + " , " +
//                Expert.KEY_Email + " , " +
//                " FROM " + Expert.TABLE;
//
//
//        //Student student = new Student();
//        ArrayList<HashMap<String, String>> expertList = new ArrayList<HashMap<String, String>>();
//
//        Cursor cursor = db.rawQuery(selectQuery, null);
//        // looping through all rows and adding to list
//
//        if (cursor.moveToFirst()) {
//            do {
//                HashMap<String, String> expert = new HashMap<String, String>();
//                expert.put(Expert.KEY_ExpertId, cursor.getInt(cursor.getColumnIndex(Expert.KEY_ExpertId)));
//                expert.put(Expert.KEY_Name, cursor.getString(cursor.getColumnIndex(Expert.KEY_Name)));
//                expert.put(Expert.KEY_Phone, cursor.getString(cursor.getColumnIndex(Expert.KEY_Phone)));
//                expert.put(Expert.KEY_Email, cursor.getString(cursor.getColumnIndex(Expert.KEY_Email)));
//              //  expert.put(cursor.getInt(cursor.getColumnIndex("Total")));
//                expertList.add(expert);
//
//            } while (cursor.moveToNext());
//        }
//
//
//        cursor.close();
//        DatabaseManager.getInstance().closeDatabase();
//     //   db.close();
//        return expertList;
//
//    }



    public List<ExpertList> getExpert(){
        ExpertList expertList = new ExpertList();
        List<ExpertList> expertLists = new ArrayList<ExpertList>();

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        String selectQuery =  " SELECT Expert." + Expert.KEY_ExpertId
                + ", Expert." + Expert.KEY_Name
                + ", Expert." + Expert.KEY_Phone
                + ", Expert." + Expert.KEY_Email
                + " FROM " + Expert.TABLE + "  As Expert "
               // + " INNER JOIN " + Major.TABLE + " Major ON Major." + Major.KEY_MajorId + "=  Expert." + Expert.KEY_Phone
                ;

        Log.d(TAG, selectQuery);
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                expertList= new ExpertList();
                expertList.setExpertId(cursor.getInt(cursor.getColumnIndex(Expert.KEY_ExpertId)));
                expertList.setExpertName(cursor.getString(cursor.getColumnIndex(Expert.KEY_Name)));
                expertList.setPhone(cursor.getString(cursor.getColumnIndex(Expert.KEY_Phone)));
                expertList.setEmail(cursor.getString(cursor.getColumnIndex(Expert.KEY_Email)));

               // expertList.setBookId(cursor.getString(cursor.getColumnIndex(Book.KEY_BookId)));
//                expertList.setBookName(cursor.getString(cursor.getColumnIndex("BookName")));

                expertLists.add(expertList);
            } while (cursor.moveToNext());
        }

        cursor.close();
        DatabaseManager.getInstance().closeDatabase();

        return expertLists;

    }

    public Expert getExpertById(int Id){
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();

        String selectQuery =  "SELECT  " +
                Expert.KEY_ExpertId + "," +
                Expert.KEY_Name + "," +
                Expert.KEY_Phone + "," +
                Expert.KEY_Email + "," +
                " FROM " + Expert.TABLE
                + " WHERE " +
                Expert.KEY_ExpertId + "=?";// It's a good practice to use parameter ?, instead of concatenate string

        int iCount =0;
        Expert expert = new Expert();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(Id) } );

        if (cursor.moveToFirst()) {
            do {
                expert.setExpertId(cursor.getInt(cursor.getColumnIndex(Expert.KEY_ExpertId)));
                expert.setName(cursor.getString(cursor.getColumnIndex(Expert.KEY_Name)));
                expert.setPhone(cursor.getString(cursor.getColumnIndex(Expert.KEY_Phone)));
                expert.setEmail(cursor.getString(cursor.getColumnIndex(Expert.KEY_Email)));


            } while (cursor.moveToNext());
        }

        cursor.close();
        DatabaseManager.getInstance().closeDatabase();
        return expert;
    }





}
