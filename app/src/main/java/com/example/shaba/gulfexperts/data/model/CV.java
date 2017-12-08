package com.example.shaba.gulfexperts.data.model;

/**
 * Created by shaba on 2017-11-22.
 */

public class CV {


    public static final String TAG = CV.class.getSimpleName();
    public static final String TABLE = "CV";

    // Labels Table Columns names
    public static final String KEY_RunningId = "RunningId";
    public static final String KEY_ExpertId = "ExpertId";
    public static final String KEY_Email = "Email";
    public static final String KEY_QualificationId = "QualificationId";
    public static final String KEY_MajorId = "MajorId";
    public static final String KEY_CountryId = "CountryId";
    public static final String KEY_WorkId = "WorkId";
    public static final String KEY_Name = "ExpertName";


    private    int expertId;
    private  String ExpertEmail ;
    private    String qualificationId;
    private String ID ;
    private String majorId ;
    private String workId ;

    private String countryId ;

    public String getExpertEmail() {
        return ExpertEmail;
    }

    public void setExpertEmail(String expertEmail) {
        ExpertEmail = expertEmail;
    }

    public String getQualificationId() {
        return qualificationId;
    }

    public void setQualificationId(String qualificationId) {
        this.qualificationId = qualificationId;
    }

    public int getExpertId() {
        return expertId;
    }

    public void setExpertId(int expertId) {
        this.expertId = expertId;
    }


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }
}
