package com.example.shaba.gulfexperts.model;

/**
 * Created by Tan on 1/27/2016.
 */
public class StudentCourseList {
    private String expertId;
    private String expertName;
    private String bookId;
    private String bookName;
    private String majorId;
    private String majorName;
    private String grade;

    public void setExpertId(String expertId) {
        this.expertId = expertId;
    }

    public void setExpertName(String expertName) {
        this.expertName = expertName;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getExpertId() {
        return expertId;
    }

    public String getExpertName() {
        return expertName;
    }

    public String getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getMajorId() {
        return majorId;
    }

    public String getMajorName() {
        return majorName;
    }



    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }



}
