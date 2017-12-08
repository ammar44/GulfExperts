package com.example.shaba.gulfexperts.data.model;

/**
 * Created by Tan on 1/26/2016.
 */
public class Book {

    public static final String TAG = Book.class.getSimpleName();
    public static final String TABLE = "Book";
    // Labels Table Columns names
    public static final String KEY_BookId = "BookId";
    public static final String KEY_Name = "Name";

    private String BookId;
    private String name;


    public String getBookId() {
        return BookId;
    }

    public void setBookId(String BookId) {
        this.BookId = BookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
