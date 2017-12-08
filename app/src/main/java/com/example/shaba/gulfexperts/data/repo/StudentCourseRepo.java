package com.example.shaba.gulfexperts.data.repo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.shaba.gulfexperts.data.DatabaseManager;
import com.example.shaba.gulfexperts.data.model.Book;
import com.example.shaba.gulfexperts.data.model.Expert;
import com.example.shaba.gulfexperts.data.model.Major;
import com.example.shaba.gulfexperts.data.model.StudentCourse;
import com.example.shaba.gulfexperts.model.CourseNotTakenByStudent;
import com.example.shaba.gulfexperts.model.StudentCourseList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by Tan on 1/27/2016.
 */
public class StudentCourseRepo {
    private final String TAG = StudentCourseRepo.class.getSimpleName().toString();

    public StudentCourseRepo() {

    }

    private StudentCourse studentCourse;



    public static String createTable(){
        return "CREATE TABLE " + StudentCourse.TABLE  + "("
                + StudentCourse.KEY_RunningId+ " INTEGER PRIMARY KEY AUTOINCREMENT , "
                + StudentCourse.KEY_ExpertId + " TEXT, "
                + StudentCourse.KEY_BookId + " TEXT, "
                + StudentCourse.KEY_Grade + " TEXT )";
    }



    public void insert(StudentCourse studentCourse) {

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(studentCourse.KEY_ExpertId, studentCourse.getExpertId());
        values.put(studentCourse.KEY_BookId, studentCourse.getBookId());
        values.put(studentCourse.KEY_Grade, studentCourse.getGrade());

        // Inserting Row
        db.insert(StudentCourse.TABLE, null, values);
        DatabaseManager.getInstance().closeDatabase();

    }


    public void delete( ) {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        db.delete(StudentCourse.TABLE, null, null);
        DatabaseManager.getInstance().closeDatabase();
    }

    public List<StudentCourseList> getStudentCourse(){
        StudentCourseList studentCourseList = new StudentCourseList();
        List<StudentCourseList> studentCourseLists = new ArrayList<StudentCourseList>();

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        String selectQuery =  " SELECT Expert." + Expert.KEY_ExpertId
                + ", Expert." + Expert.KEY_Name
                + ", Book." + Book.KEY_BookId
                + ", Book." + Book.KEY_Name + " As BookName"
                + ", StudentCourse." + StudentCourse.KEY_Grade
                + ", Major." + Major.KEY_MajorId
              //  + ", Major." + Major.KEY_Name + " As MajorName"
                + " FROM " + Expert.TABLE + "  As Expert "
                + " INNER JOIN " + StudentCourse.TABLE + " StudentCourse ON StudentCourse." + StudentCourse.KEY_ExpertId + " =  Expert." + Expert.KEY_ExpertId
                + " INNER JOIN " + Book.TABLE + " Book ON Book." + Book.KEY_BookId + "=  StudentCourse." + StudentCourse.KEY_BookId

                ;

        Log.d(TAG, selectQuery);
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                studentCourseList= new StudentCourseList();
                studentCourseList.setExpertId(cursor.getString(cursor.getColumnIndex(Expert.KEY_ExpertId)));
                studentCourseList.setExpertName(cursor.getString(cursor.getColumnIndex(Expert.KEY_Name)));
                studentCourseList.setBookId(cursor.getString(cursor.getColumnIndex(Book.KEY_BookId)));
                studentCourseList.setBookName(cursor.getString(cursor.getColumnIndex("BookName")));
                studentCourseList.setGrade(cursor.getString(cursor.getColumnIndex(StudentCourse.KEY_Grade)));
                studentCourseList.setMajorId(cursor.getString(cursor.getColumnIndex(Major.KEY_MajorId)));
                studentCourseList.setMajorName(cursor.getString(cursor.getColumnIndex("MajorName")));

                studentCourseLists.add(studentCourseList);
            } while (cursor.moveToNext());
        }

        cursor.close();
        DatabaseManager.getInstance().closeDatabase();

        return studentCourseLists;

    }

/*
    public List<StudentCourseList> getStudentCourse(){
        StudentCourseList studentCourseList = new StudentCourseList();
        List<StudentCourseList> studentCourseLists = new ArrayList<StudentCourseList>();
 */
        //  ArrayList<HashMap<String, String>> courseGradeCounts= studentCourseRepo.getCourseGradeCount();

    public ArrayList<HashMap<String, String>> getCourseGradeCount(){
        HashMap<String, String> courseGradeCount ;
        ArrayList<HashMap<String, String>>  courseGradeCounts =  new ArrayList<HashMap<String, String>>();

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        String selectQuery =  " SELECT Book." + Book.KEY_BookId
                + ", Book." + Book.KEY_Name
                + ", StudentCourse." + StudentCourse.KEY_Grade
                + ", COUNT('') AS Total"
                + " FROM " + StudentCourse.TABLE
                + " INNER JOIN " + Book.TABLE + " Book ON Book." + Book.KEY_BookId + "=  StudentCourse." + StudentCourse.KEY_BookId
                + " GROUP BY Book." + Book.KEY_BookId + ", Book." + Book.KEY_Name
                + " ORDER BY Book." + Book.KEY_Name
                ;


        Log.d(TAG, selectQuery);
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
                    do {
                courseGradeCount =new HashMap<String, String>();
                courseGradeCount.put(studentCourse.KEY_BookId,(cursor.getString(cursor.getColumnIndex(Book.KEY_BookId))));
                courseGradeCount.put(studentCourse.KEY_BookId,(cursor.getString(cursor.getColumnIndex(Book.KEY_Name))));
                courseGradeCount.put(studentCourse.KEY_Grade,(cursor.getString(cursor.getColumnIndex(StudentCourse.KEY_Grade))));
                courseGradeCount.put(StudentCourse.KEY_Grade,""+(cursor.getInt(cursor.getColumnIndex("Total"))));

                courseGradeCounts.add(courseGradeCount);
            } while (cursor.moveToNext());
        }

        cursor.close();
        DatabaseManager.getInstance().closeDatabase();

        return courseGradeCounts;

    }

    public List<CourseNotTakenByStudent> getCourseNotTakenByStudent(String studentId){
        CourseNotTakenByStudent courseNotTakenByStudent = new CourseNotTakenByStudent();
        List<CourseNotTakenByStudent> courseNotTakenByStudents = new ArrayList<CourseNotTakenByStudent>();

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        String selectQuery =  " SELECT Book." + Book.KEY_BookId
                + ", Book." + Book.KEY_Name
                + " FROM " + Book.TABLE
                + " LEFT JOIN " +StudentCourse.TABLE + " ON Book." + Book.KEY_BookId+ "=  StudentCourse." + StudentCourse.KEY_BookId
                + " AND StudentCourse." + StudentCourse.KEY_ExpertId + "=?"
                + " WHERE RunningId IS NULL "
                ;

        Log.d(TAG, selectQuery);
        Cursor cursor = db.rawQuery(selectQuery,  new String[] { String.valueOf(studentId) });
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                courseNotTakenByStudent= new CourseNotTakenByStudent();
                courseNotTakenByStudent.setBookId(cursor.getString(cursor.getColumnIndex(Book.KEY_BookId)));
                courseNotTakenByStudent.setBookName(cursor.getString(cursor.getColumnIndex(Book.KEY_Name)));

                courseNotTakenByStudents.add(courseNotTakenByStudent);
            } while (cursor.moveToNext());
        }

        cursor.close();
        DatabaseManager.getInstance().closeDatabase();

        return courseNotTakenByStudents;

    }


    public void failALLBUStudent(){



        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();

        String selectQuery =  " UPDATE  StudentCourse " +
                " SET Grade= (SELECT 'F' FROM Expert WHERE Expert.ExpertId=StudentCourse.ExpertId) " +
                " WHERE EXISTS( " +
                " SELECT * " +
                " FROM Expert " +
                " WHERE StudentCourse.ExpertId=Expert.ExpertId AND MajorId='BU' " +
                ") "
                ;

        try{
            db.beginTransaction();

            Log.d(TAG, selectQuery);
            db.execSQL(selectQuery);
            db.setTransactionSuccessful();

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }finally {
            db.endTransaction();
        }

        DatabaseManager.getInstance().closeDatabase();
    }

    public void deleteAllBUStudent(){

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();

        String selectQuery1 =
                " DELETE FROM StudentCourse WHERE ExpertId IN (SELECT ExpertId FROM Expert WHERE MajorId='BU'); "
                ;

        String selectQuery2 =
                         " DELETE FROM Expert WHERE MajorId='BU';"
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
}
