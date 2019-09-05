package com.sun.diffuntil;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

import java.util.ArrayList;

public class CountryDiffUtil extends DiffUtil.Callback {

    ArrayList<Country> mOldCountries;
    ArrayList<Country> mNewCountries;

    public CountryDiffUtil(ArrayList<Country> mOldCountries, ArrayList<Country> mNewCountries) {
        this.mOldCountries = mOldCountries;
        this.mNewCountries = mNewCountries;
    }

    @Override
    public int getOldListSize() {
        if(mOldCountries!=null){
            return mOldCountries.size();
        }
        return 0;
    }

    @Override
    public int getNewListSize() {
        if(mNewCountries!=null){
            return mNewCountries.size();
        }
        return 0;
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        Country oldCountry = mOldCountries.get(oldItemPosition);
        Country newCountry = mNewCountries.get(newItemPosition);

        return oldCountry.getmId() == newCountry.getmId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        int result = mNewCountries.get(newItemPosition).compareTo(mOldCountries.get(oldItemPosition));
        return result == 0;
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        Country newCountry = mNewCountries.get(newItemPosition);
        Country oldCountry = mOldCountries.get(oldItemPosition);
        Bundle bundle = new Bundle();
        if(newCountry.getmCountryName().equals(oldCountry.getmCountryName())){
            bundle.putString("CountryName", newCountry.getmCountryName());
        }
        if(bundle.size() == 0){
            return null;
        }
        return bundle;
    }


}
