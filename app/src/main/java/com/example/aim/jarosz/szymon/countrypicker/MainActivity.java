package com.example.aim.jarosz.szymon.countrypicker;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

import com.example.aim.jarosz.szymon.countrypicker.fragment.CountryFlagFragment;

/**
 * Created by Szymon on 29-Jan-15.
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_country_code_picker);

        if (savedInstanceState == null) {
            Fragment phoneCountryCodeFragment = new CountryFlagFragment();
            getFragmentManager().beginTransaction()
                    .add(R.id.content_frame, phoneCountryCodeFragment).commit();
        }
    }
}