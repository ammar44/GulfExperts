package com.example.shaba.gulfexperts.data.repo;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.shaba.gulfexperts.data.DatabaseManager;
import com.example.shaba.gulfexperts.data.model.Book;


/**
 * Created by Tan on 1/26/2016.
 */
public class BookRepo  {

    private Book book;

    public BookRepo(){

        book= new Book();

    }


    public static String createTable(){
        return "CREATE TABLE " + Book.TABLE  + " ("
                + Book.KEY_BookId  + "   PRIMARY KEY    ,"
                + Book.KEY_Name + " TEXT )";
    }


    public int insert(Book book) {
        int bookId;
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(Book.KEY_BookId, book.getBookId());
        values.put(Book.KEY_Name, book.getName());

        // Inserting Row
        bookId=(int)db.insert(Book.TABLE, null, values);
        DatabaseManager.getInstance().closeDatabase();

        return bookId;
    }



    public void delete( ) {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        db.delete(Book.TABLE,null,null);
        DatabaseManager.getInstance().closeDatabase();
    }






}
