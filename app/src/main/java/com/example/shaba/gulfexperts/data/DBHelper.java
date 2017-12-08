package com.example.shaba.gulfexperts.data;

/**
 * Created by Tan on 1/26/2016.
 */

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.shaba.gulfexperts.app.App;
import com.example.shaba.gulfexperts.data.model.Book;
import com.example.shaba.gulfexperts.data.model.CV;
import com.example.shaba.gulfexperts.data.model.Country;
import com.example.shaba.gulfexperts.data.model.Expert;
import com.example.shaba.gulfexperts.data.model.Major;
import com.example.shaba.gulfexperts.data.model.Minor;
import com.example.shaba.gulfexperts.data.model.Qualification;
import com.example.shaba.gulfexperts.data.model.StudentCourse;
import com.example.shaba.gulfexperts.data.model.Work;
import com.example.shaba.gulfexperts.data.repo.BookRepo;
import com.example.shaba.gulfexperts.data.repo.CVRepo;
import com.example.shaba.gulfexperts.data.repo.CountryRepo;
import com.example.shaba.gulfexperts.data.repo.ExpertRepo;
import com.example.shaba.gulfexperts.data.repo.MajorRepo;
import com.example.shaba.gulfexperts.data.repo.QualificationRepo;
import com.example.shaba.gulfexperts.data.repo.WorkRepo;


public class DBHelper  extends SQLiteOpenHelper {
    //version number to upgrade database version
    //each time if you Add, Edit table, you need to change the
    //version number.
    private static final int DATABASE_VERSION =39;
    // Database Name
    private static final String DATABASE_NAME = "gulfTraining.db";
    private static final String TAG = DBHelper.class.getSimpleName().toString();



    public DBHelper( ) {
        super(App.getContext(), DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //All necessary tables you like to create will create here

        db.execSQL(BookRepo.createTable());
        db.execSQL(ExpertRepo.createTable());
        db.execSQL(MajorRepo.createTable());
db.execSQL(CVRepo.createTable());
   db.execSQL(WorkRepo.createTable());
        db.execSQL(CountryRepo.createTable());
       // db.execSQL(StudentCourseRepo.createTable());
       // db.execSQL(MinorRepo.createTable());
        db.execSQL(QualificationRepo.createTable());



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, String.format("SQLiteDatabase.onUpgrade(%d -> %d)", oldVersion, newVersion));

        // Drop table if existed, all data will be gone!!!
        db.execSQL("DROP TABLE IF EXISTS " + Book.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Expert.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + CV.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Minor.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Work.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Country.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Qualification.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Major.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + StudentCourse.TABLE);
        onCreate(db);
    }

}