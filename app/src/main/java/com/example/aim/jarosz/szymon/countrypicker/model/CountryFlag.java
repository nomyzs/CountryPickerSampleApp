package com.example.aim.jarosz.szymon.countrypicker.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Szymon on 29-Jan-15.
 */
public class CountryFlag {
    @SerializedName("name")
    private String name;

    @SerializedName("dial_code")
    private String dialCode;

    @SerializedName("code")
    private String countryCode;

    public String getName() {
        return name;
    }

    public String getDialCode() {
        return dialCode;
    }

    public String getCountryCode() {
        return countryCode;
    }
}

