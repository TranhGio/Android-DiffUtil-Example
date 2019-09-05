package com.sun.diffuntil;

import androidx.annotation.NonNull;

public class Country implements Cloneable, Comparable {
    private int mImageResource, mId;
    private String mCountryName;

    public Country(int mId, int mImageResource, String mCountryName) {
        this.mId = mId;
        this.mImageResource = mImageResource;
        this.mCountryName = mCountryName;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public int getmImageResource() {
        return mImageResource;
    }

    public void setmImageResource(int mImageResource) {
        this.mImageResource = mImageResource;
    }

    public String getmCountryName() {
        return mCountryName;
    }

    public void setmCountryName(String mCountryName) {
        this.mCountryName = mCountryName;
    }

    @Override
    public int compareTo(Object o) {
        Country countryCompare = (Country) o;
        if(countryCompare.mId == this.mId && countryCompare.mImageResource == this.mImageResource && countryCompare.mCountryName.equals(this.mCountryName)){
            return 0;
        }
        return 1;
    }

    @NonNull
    @Override
    protected Country clone() throws CloneNotSupportedException {
        Country country = (Country) super.clone();
        return country;
    }
}
