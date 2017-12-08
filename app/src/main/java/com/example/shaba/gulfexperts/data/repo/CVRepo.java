package com.example.shaba.gulfexperts.data.repo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.shaba.gulfexperts.data.DatabaseManager;
import com.example.shaba.gulfexperts.data.model.CV;
import com.example.shaba.gulfexperts.data.model.Country;
import com.example.shaba.gulfexperts.data.model.Expert;
import com.example.shaba.gulfexperts.data.model.Major;
import com.example.shaba.gulfexperts.data.model.Qualification;
import com.example.shaba.gulfexperts.data.model.Work;
import com.example.shaba.gulfexperts.model.AdvanceList;
import com.example.shaba.gulfexperts.model.CVList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shaba on 2017-11-22.
 */

public class CVRepo {

    private final String TAG = CVRepo.class.getSimpleName().toString();
    private CV cv;


    public CVRepo() {
cv = new CV() ;
    }





    public static String createTable(){
        return "CREATE TABLE " + CV.TABLE  + "("
                + CV.KEY_RunningId+ " INTEGER PRIMARY KEY AUTOINCREMENT , "
                + CV.KEY_Email + " TEXT, "
                + CV.KEY_QualificationId + " TEXT , "
                + CV.KEY_MajorId + " TEXT, "
                + CV.KEY_WorkId + " TEXT ,"
                + CV.KEY_CountryId + " TEXT ,"
                + "FOREIGN KEY("+ CV.KEY_Email  + ") REFERENCES Expert("+ Expert.KEY_Email  + "))" ;
    }


    public void insert(CV cv) {

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(cv.KEY_Email , cv.getExpertEmail());
        values.put(cv.KEY_QualificationId, cv.getQualificationId());
        values.put(cv.KEY_MajorId, cv.getMajorId());
        values.put(cv.KEY_WorkId, cv.getWorkId());
        values.put(cv.KEY_CountryId, cv.getCountryId());


        // Inserting Row
        db.insert(CV.TABLE, null, values);
        DatabaseManager.getInstance().closeDatabase();

    }


    public void delete( ) {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        db.delete(CV.TABLE, null, null);
        DatabaseManager.getInstance().closeDatabase();
    }

    public List<CVList> getCVList(){
        CVList cvList = new CVList();
        List<CVList> cvLists = new ArrayList<CVList>();

      //  String selectQuery =  " SELECT * From "+ CV.TABLE  ;

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        String selectQuery =  " SELECT Expert." + Expert.KEY_Email
                + ", Expert." + Expert.KEY_Name
                + ", Qualification." + Qualification.KEY_QualificationId
              + ", Country." + Country.KEY_CountryId
                + ", Major." + Major.KEY_MajorId
                + ", Work." + Work.KEY_WorkId
                + " FROM " + Expert.TABLE + "  As Expert "
                + " INNER JOIN " + CV.TABLE + " CV ON CV." + CV.KEY_Email + " =  Expert." + Expert.KEY_Email
                + " INNER JOIN " + Qualification.TABLE + " Qualification ON Qualification." + Qualification.KEY_QualificationId + " =  CV." + CV.KEY_QualificationId
                + " INNER JOIN " + Major.TABLE + " Major ON Major." + Major.KEY_MajorId + " =  CV." + CV.KEY_MajorId
                + " INNER JOIN " + Work.TABLE + " Work ON Work." +  Work.KEY_WorkId + " =  CV." + CV.KEY_WorkId
                + " INNER JOIN " + Country.TABLE + " Country ON Country." + Country.KEY_CountryId + " =  CV." + CV.KEY_CountryId
                ;

        Log.d(TAG, selectQuery);
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                cvList= new CVList();
                cvList.setExpertEmail(cursor.getString(cursor.getColumnIndex(Expert.KEY_Email)));
                cvList.setExpertName(cursor.getString(cursor.getColumnIndex(Expert.KEY_Name)));
                cvList.setQualificationId(cursor.getString(cursor.getColumnIndex(Qualification.KEY_QualificationId)));
                cvList.setMajorId(cursor.getString(cursor.getColumnIndex(Major.KEY_MajorId)));
                cvList.setCountryId(cursor.getString(cursor.getColumnIndex(Country.KEY_CountryId)));
               cvList.setWorkId(cursor.getString(cursor.getColumnIndex(Work.KEY_WorkId)));


                cvLists.add(cvList);
            } while (cursor.moveToNext());
        }

        cursor.close();
        DatabaseManager.getInstance().closeDatabase();

        return cvLists;

    }



    public void deleteAllExperts(){

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();

        String selectQuery1 =
                " DELETE FROM CV WHERE ExpertId >0; "
                ;

        String selectQuery2 =
                " DELETE FROM Expert WHERE MajorId='M';"
                ;

        try{
            db.beginTransaction();

            Log.d(TAG, selectQuery1);
            Log.d(TAG, selectQuery2);
            db.execSQL(selectQuery1);
            db.execSQL(selectQuery2);
            db.setTransactionSuccessful();

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }finally {
            db.endTransaction();
        }

        DatabaseManager.getInstance().closeDatabase();

    }


    public List<AdvanceList> getAdvanceSearch(String major , String qualification , String country){
        AdvanceList advanceList = new AdvanceList();
        List<AdvanceList> advanceLists = new ArrayList<AdvanceList>();

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        String selectQuery =  " SELECT CV." + CV.KEY_CountryId
                + ", CV." + CV.KEY_QualificationId
                + ", CV." + CV.KEY_MajorId
                + ", CV." + CV.KEY_Email
                + ", Expert." + Expert.KEY_Name
                + ", Expert." + Expert.KEY_Phone
                + " FROM " + Expert.TABLE
                + " INNER JOIN " + CV.TABLE + " CV ON CV." + CV.KEY_Email + " =  Expert." + Expert.KEY_Email
                + " where " + CV.KEY_CountryId +" = " + country
                + " where " + CV.KEY_QualificationId + " = " +  qualification
                + " where " + CV.KEY_MajorId + " = " + major
                ;

        Log.d(TAG, selectQuery);
        Cursor cursor = db.rawQuery(selectQuery,  new String[] { major , qualification ,country  });
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                advanceList= new AdvanceList();
                advanceList.setCountryId(cursor.getString(cursor.getColumnIndex(CV.KEY_CountryId)));
                advanceList.setMajorId(cursor.getString(cursor.getColumnIndex(CV.KEY_MajorId)));
                advanceList.setQualificationId(cursor.getString(cursor.getColumnIndex(CV.KEY_QualificationId)));
                advanceList.setExpertEmail(cursor.getString(cursor.getColumnIndex(CV.KEY_Email)));
                advanceList.setExpertName(cursor.getString(cursor.getColumnIndex(Expert.KEY_Name)));
                advanceList.setPhone(cursor.getString(cursor.getColumnIndex(Expert.KEY_Phone)));


                advanceLists.add(advanceList);
            } while (cursor.moveToNext());
        }

        cursor.close();
        DatabaseManager.getInstance().closeDatabase();

        return advanceLists;

    }



}
