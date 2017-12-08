package com.example.shaba.gulfexperts.data.model;

/**
 * Created by Tan on 1/26/2016.
 */
public class Expert {
    public static final String TAG = Expert.class.getSimpleName();
    public static final String TABLE = "Expert";

    // Labels Table Columns names
    public static final String KEY_ExpertId = "ExpertId";
    public static final String KEY_Name = "ExpertName";
    public static final String KEY_Phone = "Phone";
    public static final String KEY_Email = "Email";


public Expert(){


}
    private int id ;
    private String name;

    private String email ;
    private String  phone;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getExpertId() {
        return id;
    }

    public void setExpertId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
