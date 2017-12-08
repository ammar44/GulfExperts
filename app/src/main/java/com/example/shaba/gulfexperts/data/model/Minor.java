package com.example.shaba.gulfexperts.data.model;

/**
 * Created by Tan on 1/26/2016.
 */
public class Minor {

    public static final String TAG = Minor.class.getSimpleName();
    public static final String TABLE = "Minor";
    // Labels Table Columns names
    public static final String KEY_MinorId = "MinorId";
//    public static final String KEY_Name = "Name";

    private String minorId;
    private String name;

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    public String getMinorId() {
        return minorId;
    }

    public void setMInorId(String ref) {
        this.minorId = ref;
    }
}
