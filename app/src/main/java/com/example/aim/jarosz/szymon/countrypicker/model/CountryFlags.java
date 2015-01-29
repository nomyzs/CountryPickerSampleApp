package com.example.aim.jarosz.szymon.countrypicker.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Szymon on 29-Jan-15.
 */
public class CountryFlags {

    @SerializedName( "codes" )
    List<CountryFlag> countryFlags;

    public List<CountryFlag> getCountryFlags() {
        return countryFlags;
    }
}
