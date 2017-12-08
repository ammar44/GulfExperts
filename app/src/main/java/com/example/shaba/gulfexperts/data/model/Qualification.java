package com.example.shaba.gulfexperts.data.model;

/**
 * Created by shaba on 2017-11-22.
 */

public class Qualification {

    public static final String TAG = Qualification.class.getSimpleName();
    public static final String TABLE = "Qualification";
    // Labels Table Columns names
    public static final String KEY_QualificationId = "QualificationId";
//    public static final String KEY_Name = "QualificationName";

    private String qualificationId;
//    private String name;
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    public String getQualificationId() {
        return qualificationId;
    }

    public void setQualificationId(String qualificationId) {
        this.qualificationId = qualificationId;
    }
}
