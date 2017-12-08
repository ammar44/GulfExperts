package com.example.shaba.gulfexperts.data.model;

/**
 * Created by Tan on 1/26/2016.
 */
public class Country {

    public static final String TAG = Country.class.getSimpleName();
    public static final String TABLE = "Country";
    // Labels Table Columns names
    public static final String KEY_CountryId = "CountryId";


    private String countryId;


    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String ref) {
        this.countryId = ref;
    }
}
