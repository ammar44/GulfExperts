package com.example.shaba.gulfexperts.data.repo;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.shaba.gulfexperts.data.DatabaseManager;
import com.example.shaba.gulfexperts.data.model.Country;

/**
 * Created by Tan on 1/26/2016.
 */
public class CountryRepo {

    private Country country;

    public CountryRepo(){

        country= new Country();

    }


    public static String createTable(){
        return "CREATE TABLE " + Country.TABLE  + "("
                + Country.KEY_CountryId + " TEXT  PRIMARY KEY) " ;

    }



    public int insert(Country country) {
        int countryId;
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(Country.KEY_CountryId, country.getCountryId());
       // values.put(Country.KEY_Name, country.getName());

        // Inserting Row
        countryId=(int)db.insert(Country.TABLE, null, values);
        DatabaseManager.getInstance().closeDatabase();
        return countryId;

    }



    public void delete( ) {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        db.delete(Country.TABLE, null,null);
        DatabaseManager.getInstance().closeDatabase();
    }








}
