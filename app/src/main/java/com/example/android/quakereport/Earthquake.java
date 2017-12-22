package com.example.android.quakereport;

/**
 * Created by Amani on 15-12-2017.
 */

public class Earthquake {
    private double mMagnitude;
    private String mLocation;
    /** Time of the earthquake */
    private long mTimeInMilliseconds;

    private String mWebsiteURL;


    public Earthquake(double magnitude, String location, long dateOccured, String url){
        this.mMagnitude = magnitude;
        this.mLocation =  location;
        this.mTimeInMilliseconds = dateOccured;
        this.mWebsiteURL = url;
    }

    public String getmWebsiteURL() {
        return mWebsiteURL;
    }

    public void setmWebsiteURL(String mWebsiteURL) {
        this.mWebsiteURL = mWebsiteURL;
    }

    public double getmMagnitude() {
        return mMagnitude;
    }

    public void setmMagnitude(double mMagnitude) {
        this.mMagnitude = mMagnitude;
    }

    public String getmLocation() {
        return mLocation;
    }

    public void setmLocation(String mLocation) {
        this.mLocation = mLocation;
    }

    public long getmTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

    public void setmTimeInMilliseconds(long mTimeInMilliseconds) {
        this.mTimeInMilliseconds = mTimeInMilliseconds;
    }

    @Override
    public String toString() {
        return "Earthquake{" +
                "mMagnitude='" + mMagnitude + '\'' +
                ", mLocation='" + mLocation + '\'' +
                ", mTimeInMilliseconds=" + mTimeInMilliseconds +
                '}';
    }
}
