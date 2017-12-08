package com.example.shaba.gulfexperts;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by shaba on 2017-10-10.
 */

public class Exper implements Parcelable {
    private final String name;
    private final String major;
    private final int id;
    private final String minor ;
    private final String country;
    private final String work;
    private final String qualification ;

    final String DRAWABLE = "@drawable/" ;

    public Exper(int id , String name , String major, String minor , String country, String work , String qualification ){
        this.major = major ;
        this.id = id ;
        this.name = name ;
        this.minor = minor ;
        this.country = country ;
        this.work = work;
        this.qualification =qualification ;


    }



    public static final Creator<Exper> CREATOR = new Creator<Exper>() {
        @Override
        public Exper createFromParcel(Parcel in) {
            return new Exper(in);
        }

        @Override
        public Exper[] newArray(int size) {
            return new Exper[size];
        }
    };

    public String getName() {
        return name;}
    public String getMajor() {
        return  major;
    }
    public int getId() {
        return id;
    }

    public String getMinor() {
        return minor;
    }

    public String getCountry() {
        return country;
    }

    public String getWork() {
        return work;
    }

    public String getQualification() {
        return qualification;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt( this.id);
        dest.writeString(this.name);
        dest.writeString(this.major);
        dest.writeString(this.minor);
        dest.writeString(this.country);
        dest.writeString(this.work);
        dest.writeString(this.qualification);
    }


    protected Exper(Parcel in) {
        this.name = in.readString();
        this.major = in.readString();
        this.minor = in.readString();
        this.country = in.readString();
        this.work = in.readString();
        this.qualification = in.readString();
        this.id = in.readInt();



    }
}
