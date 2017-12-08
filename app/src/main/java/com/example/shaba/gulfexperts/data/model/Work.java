package com.example.shaba.gulfexperts.data.model;

/**
 * Created by Tan on 1/26/2016.
 */
public class Work {

    public static final String TAG = Work.class.getSimpleName();
    public static final String TABLE = "Work";
    // Labels Table Columns names
    public static final String KEY_WorkId = "WorkId";
//    public static final String KEY_Name = "Name";
//
    private String workId;
//    private String name;
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String ref) {
        this.workId = ref;
    }
}
