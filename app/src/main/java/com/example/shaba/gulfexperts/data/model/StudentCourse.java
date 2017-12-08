package com.example.shaba.gulfexperts.data.model;

/**
 * Created by Tan on 1/27/2016.
 */
public class StudentCourse {
    public static final String TAG = StudentCourse.class.getSimpleName();
    public static final String TABLE = "StudentCourse";

    // Labels Table Columns names
    public static final String KEY_RunningId = "RunningId";
    public static final String KEY_ExpertId = "ExpertId";
    public static final String KEY_BookId = "BookId";
    public static final String KEY_Grade = "Grade";

    public   String expertId;
    public   String bookId;
    public   String grade;

    public String getExpertId() {
        return expertId;
    }

    public void setExpertId(String expertId) {
        this.expertId = expertId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }





}
