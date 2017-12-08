package com.example.shaba.gulfexperts.model;

/**
 * Created by Tan on 1/28/2016.
 */
public class CourseGradeCount {

    private String bookId;
    private String bookName;
    private String grade;
    private Integer count;

    public String getBookID() {
        return bookId;
    }

    public void setBookID(String courseID) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String courseName) {
        this.bookName = bookName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
